package com.app.packs.service.impl;

import java.nio.file.AccessDeniedException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.packs.domain.pack.Pack;
import com.app.packs.domain.user.UserPack;
import com.app.packs.enums.EEstadoPack;
import com.app.packs.enums.ETipoPlan;
import com.app.packs.enums.EVigencia;
import com.app.packs.repository.IPackRepository;
import com.app.packs.repository.IUserPackRepository;
import com.app.packs.service.interfaces.IPackService;
import com.app.packs.util.BuilderClasses;
import com.app.packs.web.soap.prepaidService.client.PrepaidClient;

@Service
public class PackServiceImpl implements IPackService{
	
	@Autowired
	private PrepaidClient prepaidClient;
	
	@Autowired
	private IUserPackRepository userPackRepository;
	
	@Autowired
	private Map<EVigencia,IPackRepository<?>> packRepositories;
	
	@Transactional
	public void purchasePack(long phone, String pack) throws Exception{
		String plan = prepaidClient.getPlanForUser(phone);
		
		if(plan == null){
			throw new AccessDeniedException("El usuario no tiene ningun plan asignado");
		}
		
		ETipoPlan ePlan = ETipoPlan.valueOf(plan.toUpperCase());
		if(ePlan.equals(ETipoPlan.PREPAGO)){
			Pack p = (Pack) packRepositories.get(EVigencia.findByKey(pack)).findAll().iterator().next();
			verificarUnicidad(phone,p);
			UserPack userPack = BuilderClasses.buildUser(phone, p);
			userPackRepository.saveAndFlush(userPack);
			prepaidClient.purchase(phone, p);
		}else{
			throw new AccessDeniedException("El plan del usuario no es PREPAGO");
		}
	}
	
	/**
	 * Si bien no se duplica la clave, lanza esta exception debido
	 * a que ya existe un registro en estado nuevo para ese telefono
	 * con ese pack
	 * @param phone
	 * @param p
	 * @throws DuplicateKeyException
	 */
	private void verificarUnicidad(long phone,Pack p)throws DuplicateKeyException{
		UserPack up = userPackRepository.findByEstadoAndPhoneAndPack(EEstadoPack.N, phone, p);
		if(up!=null){
			throw new DuplicateKeyException("Ya existe un pack vigente para ese telefono");
		}
	}

	@Transactional
	public void deletePack(long phone) {
		List<UserPack> userCol = this.userPackRepository.findByPhoneAndEstado(phone, EEstadoPack.N);
		userCol.stream().forEach(u->u.setEstado(EEstadoPack.E));
		userPackRepository.save(userCol);
		prepaidClient.deleteBolton(phone, userCol.stream().map(UserPack::getPack).collect(Collectors.toList()));
	}

	@Override
	public void verificarVencimiento() {
		java.util.Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime()); 
		List<UserPack> userCol = this.userPackRepository.findByEstadoAndFechaVencimientoLessThanEqual(EEstadoPack.N, ts);
		userCol.stream().forEach(u->u.setEstado(EEstadoPack.V));
		userPackRepository.save(userCol);
		
		Map<Long,List<Pack>> map = listToMap(userCol);
		
		for(Map.Entry<Long,List<Pack>> entry : map.entrySet()){
			prepaidClient.deleteBolton(entry.getKey(),entry.getValue());
		}
	}
	
	private Map<Long,List<Pack>> listToMap(List<UserPack> collection){
		Map<Long,List<Pack>> map = new HashMap<Long, List<Pack>>();
		for(UserPack up : collection){
			if(map.get(up.getPhone())==null){
				List<Pack> packs = new ArrayList<Pack>();
				map.put(up.getPhone(), packs);
			}
			map.get(up.getPhone()).add(up.getPack());
		}
		return map;
	}

}

package com.app.packs.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.packs.domain.pack.Pack;
import com.app.packs.domain.user.UserPack;
import com.app.packs.enums.EEstadoPack;

public interface IUserPackRepository extends JpaRepository<UserPack, Long>{
	
	List<UserPack> findByPhoneAndEstado(long phone, EEstadoPack estado);
	List<UserPack> findByEstadoAndFechaVencimientoLessThanEqual(EEstadoPack estado, Timestamp ts);
	UserPack findByEstadoAndPhoneAndPack(EEstadoPack estado, long phone, Pack pack);
}

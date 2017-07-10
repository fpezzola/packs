package com.app.packs.domain.user;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.app.packs.domain.pack.Pack;
import com.app.packs.enums.EEstadoPack;

@Entity
@Table(name="user_pack")
public class UserPack implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private Long phone;
	@ManyToOne
	@JoinColumn(name="pack")
	private Pack pack;
	@Enumerated(EnumType.STRING)
	@Column
	private EEstadoPack estado;
	@Column
	private Timestamp fecha;
	@Column(name="fecha_vencimiento")
	private Timestamp fechaVencimiento;
	
	public UserPack() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public Pack getPack() {
		return pack;
	}
	public void setPack(Pack pack) {
		this.pack = pack;
	}
	public EEstadoPack getEstado() {
		return estado;
	}
	public void setEstado(EEstadoPack estado) {
		this.estado = estado;
	}
	public Timestamp getFecha() {
		return fecha;
	}
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}


	public Timestamp getFechaVencimiento() {
		return fechaVencimiento;
	}


	public void setFechaVencimiento(Timestamp fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	
	
	

}

package com.app.packs.domain.pack;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.app.packs.domain.bono.Bono;
import com.app.packs.domain.bono.datos.Datos;
import com.app.packs.domain.bono.llamada.Llamada;
import com.app.packs.domain.bono.sms.Sms;
import com.app.packs.enums.EVigencia;
@Entity
@Table(name="pack")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="vigencia",discriminatorType=DiscriminatorType.STRING)
public abstract class Pack implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	@Column(insertable = false, updatable = false)
	private EVigencia vigencia;
	@OneToOne
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name="llamada")
	private Llamada llamada;
	@OneToOne
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name="sms")
	private Sms sms;
	@OneToOne
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name="datos")
	private Datos datos;
	
	public Pack() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EVigencia getVigencia() {
		return vigencia;
	}

	public void setVigencia(EVigencia vigencia) {
		this.vigencia = vigencia;
	}

	public Llamada getLlamada() {
		return llamada;
	}

	public void setLlamada(Llamada llamada) {
		this.llamada = llamada;
	}

	public Sms getSms() {
		return sms;
	}

	public void setSms(Sms sms) {
		this.sms = sms;
	}

	public Datos getDatos() {
		return datos;
	}

	public void setDatos(Datos datos) {
		this.datos = datos;
	}
	
	public Set<Bono> getBonos(){
		Set<Bono> bonos = new HashSet<Bono>(3);
		bonos.add(datos);
		bonos.add(sms);
		bonos.add(llamada);
		return bonos;
	}
	
	
	public abstract Timestamp darFechaVencimiento(Timestamp ts);

}

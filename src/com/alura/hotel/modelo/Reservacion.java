package com.alura.hotel.modelo;

import java.math.BigDecimal;
import java.util.Date;

public class Reservacion {
	
	private Integer idReserva;
	
	private Date fechaEntrada;
	
	private Date fechaSalida;
	
	private float valor;
	
	private Object formaPago;
	
	public Reservacion(Integer id, Date fechaEntrada, Date fechaSalida, float valor, Object formaPago) {
		super();
		this.idReserva = id;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valor = valor;
		this.formaPago = formaPago;
	}
	
	public Reservacion(Date fechaEntrada, Date fechaSalida, float valor, Object formaPago) {
		super();
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valor = valor;
		this.formaPago = formaPago;
	}

	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Object getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	
	public void setIdReserva(Integer idReserva) {
		this.idReserva=idReserva;
	}
	public Integer getIdReserva() {
		return idReserva;
	}
}

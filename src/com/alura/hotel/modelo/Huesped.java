package com.alura.hotel.modelo;

import java.util.Date;

public class Huesped {
	
	private Integer idHuesped;

	private String nombre;

	private String apellido;
	
	private Date fechaNacimiento;
	
	private String nacionalidad;
	
	private String telefono;
	
	private Integer numeroReserva;
	
	public Huesped(String nombre, String apellido, Date fechaNacimiento, String nacionalidad, String telefono,
			Integer numeroReserva) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.numeroReserva = numeroReserva;
	}
	public Huesped(Integer id, String nombre, String apellido, Date fechaNacimiento, String nacionalidad, String telefono,
			Integer numeroReserva) {
		super();
		this.idHuesped= id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.numeroReserva = numeroReserva;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Integer getNumeroReserva() {
		return numeroReserva;
	}

	public void setNumeroReserva(Integer numeroReserva) {
		this.numeroReserva = numeroReserva;
	}
	
	public void setIdHuesped(Integer idHuesped) {
		this.idHuesped=idHuesped;
	}
	
	public Integer getIdHuesped() {
		return idHuesped;
	}

}

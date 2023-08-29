package com.alura.hotel.controller;

import java.util.Hashtable;

import javax.swing.JOptionPane;

import com.alura.hotel.dao.ReservacionDao;
import com.alura.hotel.factory.ConnectionFactory;
import com.alura.hotel.modelo.Huesped;
import com.alura.hotel.modelo.Reservacion;

public class BusquedaController {
	private String busqueda;
	public BusquedaController(String busqueda) {
		this.busqueda=busqueda;
	}
	
	public Hashtable<Huesped, Reservacion> buscar () {
		ReservacionDao reservacionDao= new ReservacionDao(new ConnectionFactory().recuperaConexion());
		Hashtable<Huesped, Reservacion> datos= reservacionDao.buscar(busqueda);
		
		if(datos.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Sin resultados que mostrar");	
		}
		return datos;
	}
	
	public int eliminar() {
		ReservacionDao reservacionDao= new ReservacionDao(new ConnectionFactory().recuperaConexion());
		return reservacionDao.eliminar(busqueda);
	}
}

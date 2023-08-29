package com.alura.hotel.controller;

import com.alura.hotel.dao.HuespedDao;
import com.alura.hotel.factory.ConnectionFactory;
import com.alura.hotel.modelo.Huesped;

public class HuespedController {
	public void guardar(Huesped huesped) {
		HuespedDao huespedDao= new HuespedDao(new ConnectionFactory().recuperaConexion());
		huespedDao.guardar(huesped);
	}
	public void actualiza(Huesped huesped) {
		HuespedDao huespedDao= new HuespedDao(new ConnectionFactory().recuperaConexion());
		huespedDao.actualizar(huesped);
	}
}

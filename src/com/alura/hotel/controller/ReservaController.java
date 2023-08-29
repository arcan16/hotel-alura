package com.alura.hotel.controller;

import com.alura.hotel.dao.ReservacionDao;
import com.alura.hotel.factory.ConnectionFactory;
import com.alura.hotel.modelo.Reservacion;

import views.ReservasView;

public class ReservaController {
	public void guardar(Reservacion reservacion) {
		ReservacionDao reservacionDao= new ReservacionDao(new ConnectionFactory().recuperaConexion());
		reservacionDao.guardar(reservacion);
	}
	public void actualizar(Integer id,Reservacion reserva) {
		ReservacionDao reservaciondao= new ReservacionDao(new ConnectionFactory().recuperaConexion());
		reservaciondao.actualizar(reserva);
	}
}

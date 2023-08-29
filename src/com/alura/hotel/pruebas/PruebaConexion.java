package com.alura.hotel.pruebas;

import java.sql.Connection;
import java.sql.SQLException;

import com.alura.hotel.factory.ConnectionFactory;

public class PruebaConexion {
	public static void main(String[] args) {
		try {
			PruebaConexion test= new PruebaConexion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public PruebaConexion() throws SQLException {
		Connection con = new ConnectionFactory().recuperaConexion();
		
		System.out.println("Conexion abierta");
		
		con.close();
	}
}

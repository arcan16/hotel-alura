package com.alura.hotel.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	private DataSource dataSource;
	
	public ConnectionFactory() {
		ComboPooledDataSource poolDataSource = new ComboPooledDataSource();
		poolDataSource.setJdbcUrl("jdbc:mysql://localhost/hotel_alura?useTimeZone=true&serverTimeZone=UTC");
		// Credenciales tomadas de las variables de entorno DB_USERNAME y DB_PASSWORD
		poolDataSource.setUser(System.getenv().getOrDefault("DB_USERNAME", "root"));
		poolDataSource.setPassword(System.getenv("DB_PASSWORD"));
		
		this.dataSource=poolDataSource;
	}
	
	public Connection recuperaConexion() {
		try {
			return this.dataSource.getConnection();
		} catch (SQLException e) {
			System.out.println("Error en al conexion");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}

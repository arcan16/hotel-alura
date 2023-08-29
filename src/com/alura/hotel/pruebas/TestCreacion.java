package com.alura.hotel.pruebas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.alura.hotel.factory.ConnectionFactory;

public class TestCreacion {
	
	public static void main(String[] args) throws SQLException {
		Connection con = new ConnectionFactory().recuperaConexion();
		try(con){
			PreparedStatement statement= con.prepareStatement(
	    			"INSERT INTO reservas (FechaEntrada, FechaSalida, Valor, FormaPago) "
	    			+ " VALUES(?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
	    	
	    	try(statement){
	    		statement.setDate(1, java.sql.Date.valueOf("2023-08-22"));
	    		statement.setDate(2, java.sql.Date.valueOf("2023-08-24"));
	    		statement.setFloat(3, 2428);
	    		statement.setString(4, "Efectivales coppel");
	    		statement.execute();
	    		
	    		final ResultSet resultSet= statement.getGeneratedKeys();
	    		try(resultSet){
	    			System.out.println(resultSet);
	    			while(resultSet.next()) {
	    				System.out.println("Fue insertado con exito el registro"+resultSet.getInt(1));
	    			}
	    		}
	    	}
		}catch(Exception e) {
			throw new SQLException(e);
		}
		
		
		con.close();
	}
	
}

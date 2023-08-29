package com.alura.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;

import javax.swing.JOptionPane;

import com.alura.hotel.modelo.Huesped;
import com.alura.hotel.modelo.Reservacion;

import views.Exito;
import views.ReservasView;

public class HuespedDao {

	final private Connection con;

	public HuespedDao(Connection con) {
		this.con = con;
	}

	public void guardar(Huesped huesped) {
		try (con) {
			final PreparedStatement statement = con.prepareStatement(
					"INSERT INTO huespedes (nombre, apellido, fechaDeNacimiento, nacionalidad, telefono, idReserva) "
							+ " VALUES(?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

			try (statement) {

				statement.setString(1, huesped.getNombre());
				statement.setString(2, huesped.getApellido());
				statement.setString(3, ReservasView.dateFormat.format(huesped.getFechaNacimiento()));
				statement.setString(4, huesped.getNacionalidad());
				statement.setString(5, huesped.getTelefono());
				statement.setInt(6, huesped.getNumeroReserva());
				statement.execute();

				System.out.println(huesped.getNombre());
				System.out.println(huesped.getApellido());
				System.out.println(huesped.getFechaNacimiento());
				System.out.println(huesped.getNacionalidad());
				System.out.println(huesped.getTelefono());
				System.out.println(huesped.getNumeroReserva());
				final ResultSet resultSet = statement.getGeneratedKeys();
				try (resultSet) {
					System.out.println(resultSet);
					while (resultSet.next()) {
						System.out.println("Fue insertado con exito el registro" + resultSet.getInt(1));
						Exito exito = new Exito();
						exito.setVisible(true);
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void actualizar(Huesped huesped) {
		try(con){
			PreparedStatement statement= con.prepareStatement(
					"UPDATE huespedes SET nombre=?, apellido=?, fechaDeNacimiento=?,"
					+ " nacionalidad=?, telefono=? WHERE id=?");
			try(statement){
				statement.setString(1, huesped.getNombre());
				statement.setString(2, huesped.getApellido());
				statement.setString(3, ReservasView.dateFormat.format(huesped.getFechaNacimiento()));
				statement.setString(4, huesped.getNacionalidad());
				statement.setString(5, huesped.getTelefono());
				statement.setInt(6, huesped.getIdHuesped());
				statement.execute();
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		/*
		JOptionPane.showMessageDialog(null, "Vamos a actualizar el registro ");
		System.out.println(huesped.getIdHuesped());
		System.out.println(huesped.getNombre());
		System.out.println(huesped.getApellido());
		System.out.println(huesped.getFechaNacimiento());
		System.out.println(huesped.getNacionalidad());
		System.out.println(huesped.getTelefono());
		System.out.println(huesped.getNumeroReserva());*/
	}

}

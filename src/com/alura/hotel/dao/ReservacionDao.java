package com.alura.hotel.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.swing.JOptionPane;

import com.alura.hotel.modelo.Huesped;
import com.alura.hotel.modelo.Reservacion;

import views.ReservasView;

public class ReservacionDao {
	final private Connection con;
	private static Integer idReservacion;

	public ReservacionDao(Connection con) {
		this.con = con;
	}

	public void guardar(Reservacion reservacion) {
		try (con) {
			final PreparedStatement statement = con.prepareStatement(
					"INSERT INTO reservas (FechaEntrada, FechaSalida, Valor, FormaPago) " + " VALUES(?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

			try (statement) {
				System.out.println(ReservasView.dateFormat.format(reservacion.getFechaEntrada()));
				// System.out.println(Date.valueOf(LocalDate.of(reservacion.getFechaEntrada().getDate(),reservacion.getFechaEntrada().getMonth(),reservacion.getFechaEntrada().getYear())));

				statement.setString(1, ReservasView.dateFormat.format(reservacion.getFechaEntrada()));
				statement.setString(2, ReservasView.dateFormat.format(reservacion.getFechaSalida()));
				statement.setFloat(3, reservacion.getValor());
				statement.setString(4, (String) reservacion.getFormaPago());
				statement.execute();

				final ResultSet resultSet = statement.getGeneratedKeys();
				try (resultSet) {
					System.out.println(resultSet);
					while (resultSet.next()) {
						System.out.println("Fue insertado con exito el registro" + resultSet.getInt(1));
						setIdReservacion(resultSet.getInt(1));
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Hashtable<Huesped, Reservacion> buscar(String busqueda) {
		Hashtable<Huesped, Reservacion> resultados = new Hashtable<Huesped, Reservacion>();
		final PreparedStatement statement;
		try {
			if(busqueda.isEmpty()) {
				System.out.println("Busqueda vacia");
				statement = con.prepareStatement(
						" SELECT * FROM huespedes h INNER JOIN reservas r ON h.idReserva=r.id");

			}else {				
				statement = con.prepareStatement(
						" SELECT * FROM huespedes h INNER JOIN reservas r ON h.idReserva=r.id WHERE (h.nombre=?"
								+ " OR h.apellido =? OR h.idReserva=?)");
			}

			try (statement) {
				if(busqueda.isEmpty()) {
					System.out.println("Vacio");
				}else if(esNumero(busqueda)) {
					statement.setString(1, busqueda);
					statement.setString(2, busqueda);
					statement.setInt(3, Integer.parseInt(busqueda));
				}else {
					statement.setString(1, busqueda);
					statement.setString(2, busqueda);
					statement.setInt(3, 0);
				}
				statement.execute();

				final ResultSet resultSet = statement.getResultSet();
				try (resultSet) {
					while (resultSet.next()) {
						Huesped huesped = new Huesped(resultSet.getString("nombre"), resultSet.getString("Apellido"),
								resultSet.getDate("fechaDeNacimiento"), resultSet.getString("nacionalidad"),
								resultSet.getString("telefono"), resultSet.getInt("idReserva"));
						Reservacion reservacion = new Reservacion(resultSet.getDate("fechaEntrada"),
								resultSet.getDate("fechaSalida"), resultSet.getFloat("valor"),
								resultSet.getString("FormaPago"));
						reservacion.setIdReserva(resultSet.getInt("idReserva"));
						huesped.setIdHuesped(resultSet.getInt("id"));
						resultados.put(huesped, reservacion);
					}
					return resultados;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}
	
	public static boolean esNumero(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	public int eliminar(String idReserva) {
		//JOptionPane.showMessageDialog(null, "Aqui vamos a eliminar los registros con id "+idReserva);
		try {
			final PreparedStatement statement = con.prepareStatement(
					"DELETE FROM reservas where id=?");
			
			try(statement){
				statement.setInt(1, Integer.parseInt(idReserva));
				statement.execute();
				
				return statement.getUpdateCount();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static void setIdReservacion(Integer id) {
		idReservacion = id;
	}

	public static Integer getIdreservacion() {
		return idReservacion;
	}
	
	public int actualizar(Reservacion reservacion) {
		/*JOptionPane.showMessageDialog(null, "Estamos actualizando el registro");
		System.out.println(reservacion.getIdReserva());
		System.out.println(reservacion.getFechaEntrada());
		System.out.println(reservacion.getFechaSalida());
		System.out.println(reservacion.getValor());
		System.out.println(reservacion.getFormaPago());*/
		
		try {
			final PreparedStatement statement= con.prepareStatement(
					"UPDATE reservas SET FechaEntrada=?, FechaSalida=?, valor=?, FormaPago=? WHERE id=?");
			try(statement){
				statement.setString(1, ReservasView.dateFormat.format(reservacion.getFechaEntrada()));
				statement.setString(2, ReservasView.dateFormat.format(reservacion.getFechaSalida()));
				statement.setFloat(3, reservacion.getValor());
				statement.setString(4, (String) reservacion.getFormaPago());
				statement.setInt(5, Integer.valueOf(reservacion.getIdReserva()));
				statement.execute();
				
				return statement.getUpdateCount();
			}
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

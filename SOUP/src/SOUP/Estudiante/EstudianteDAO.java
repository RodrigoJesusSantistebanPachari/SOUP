package SOUP.Estudiante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import SOUP.Estudiantes.model.Conexion;
//Clase que ingresa a la tabla  estudiante para insertar y eliminar estudiante
public class EstudianteDAO {
	private Conexion con;
	private Connection connection;
	
	public EstudianteDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) //conexion a la base de datos soup
	{
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}
	
	public boolean insertar(Estudiante estudiante)throws SQLException{
		String sql = "INSERT INTO estudiante (cui, nombre, dni, correo) VALUES (?,?,?,?)";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, estudiante.getCUI());
		statement.setString(2, estudiante.getNombre());
		statement.setInt(3, estudiante.getDNI());
		statement.setString(4, estudiante.getCorreo());
				
		
		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		
		return rowInserted;
		
	}
	
	public boolean eliminar(int cui) throws SQLException {
		boolean rowEliminar = false;
		System.out.println("Creando sql");
		String sql = "DELETE FROM estudiante WHERE cui="+cui;
		System.out.println(sql);
		con.conectar();
		System.out.println("Coneccion Establecida");
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		
		rowEliminar = statement.executeUpdate(sql) > 0;
		statement.close();
		con.desconectar();
		System.out.println("Eliminado");
		return rowEliminar;
	}

}

package SOUP.Matriculas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import SOUP.Estudiantes.model.Conexion;
import SOUP.Estudiante.*;
import SOUP.Cursos.model.*;

//clase que accede a la tabla de matricula para insertar, eliminar y listar matriculas 
public class MatriculaDAO {
	private static Conexion con;
	private static Connection connection;
	
	public MatriculaDAO(String jdbcURL, String jdbcUsername, String jdbcPassword)
	{
		System.out.println(jdbcURL); //conexion a la base de datos soup
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}
	
	public boolean insertar(Matricula matricula)throws SQLException{
		String sql = "INSERT INTO matriculas (id, cui, idCurso, turno) VALUES (?,?,?,?)";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, null);
		statement.setInt(2, matricula.getCUI());
		statement.setInt(3, matricula.getCurso());
		statement.setInt(4, matricula.getTurno());

		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		
		return rowInserted;
		
	}
	
	public static List<Estudiante> ListarPorCurso(int curso) throws SQLException{
		System.out.println("entro al dao");
		System.out.println(curso);
		List<Estudiante> listaArticulos = new ArrayList<Estudiante>();
		System.out.println("creo la lista");
		String sql = "SELECT estudiante.nombre, estudiante.cui, estudiante.correo, matriculas.turno, matriculas.id, matriculas.idCurso FROM matriculas INNER JOIN estudiante ON matriculas.cui = estudiante.cui WHERE matriculas.idCurso ="+curso;
		System.out.println("sql listo");
		System.out.println(sql);
		con.conectar();   
		System.out.println("1");
		connection = con.getJdbcConnection();
		System.out.println("2");
		Statement statement = connection.createStatement();
		System.out.println("conneccion establecida");
		ResultSet resulSet = statement.executeQuery(sql);
		System.out.println("extrayendo datos");
		while (resulSet.next()) {
			String nombre = resulSet.getString("nombre");
			int cui = resulSet.getInt("cui");
			String correo = resulSet.getString("correo");
			int turno = resulSet.getInt("turno");
			int id = resulSet.getInt("id");
			int idCurso = resulSet.getInt("idCurso");
			Estudiante articulo = new Estudiante(cui, nombre, correo, turno, id,idCurso);
			listaArticulos.add(articulo);
		}
		con.desconectar();
		return listaArticulos;
	}
	
	public static List<Curso> ListarPorEstudiante(int cui) throws SQLException{
		 
		List<Curso> listaCursos = new ArrayList<Curso>();
		String sql = "SELECT cursos.Nombre,  cursos.Profesor, cursos.Año, cursos.Semestre, matriculas.turno, matriculas.id, matriculas.cui FROM matriculas INNER JOIN cursos ON matriculas.idCurso = cursos.idCurso WHERE matriculas.cui ='"+cui+"'";
		
		con.conectar();                                   
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);
		System.out.println("Buscando");
 
		while (resulSet.next()) {
			String nombre = resulSet.getString("Nombre");
			String profesor = resulSet.getString("Profesor");
			int año = resulSet.getInt("Año");
			String semestre = resulSet.getString("Semestre");
			int turno = resulSet.getInt("turno");
			System.out.println(turno);
			int id = resulSet.getInt("id");
			int mycui = resulSet.getInt("cui");
			Curso articulo = new Curso(nombre,profesor, año, semestre ,turno,id,mycui);
			listaCursos.add(articulo);
		}
		con.desconectar();
		return listaCursos;
	}
	
	public boolean eliminar(int id) throws SQLException {
		boolean rowEliminar = false;
		System.out.println("id");
		String sql = "DELETE FROM matriculas WHERE id="+id;
		con.conectar();
		connection = con.getJdbcConnection();
		
		Statement statement = connection.createStatement();
		
		rowEliminar = statement.executeUpdate(sql) > 0;
		statement.close();
		con.desconectar();
		System.out.println("Eliminado");
		return rowEliminar;
	}
}


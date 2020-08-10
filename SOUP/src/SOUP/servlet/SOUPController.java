package SOUP.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
 

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import SOUP.Estudiante.*;
import SOUP.Matriculas.*;
import SOUP.Cursos.model.*;
//import SOUP.Estudiantes.model.Estudiante;
//import SOUP.Estudiantes.dao.*;
/**
 * Servlet implementation class SOUPController
 * 
 * 
 * Aqui llegan todas las peticiones
 * 
 */
@WebServlet("/SOUPController")
public class SOUPController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      EstudianteDAO estudianteDAO;
      MatriculaDAO matriculaDAO;
	
      public void init() {
    	String jdbcURL = "jdbc:mysql://localhost:3306/soup?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
  		String jdbcUsername = "root";
  		String jdbcPassword = "ADMIN";
  		try {
  			 
  			estudianteDAO = new EstudianteDAO(jdbcURL, jdbcUsername, jdbcPassword);
  			matriculaDAO = new MatriculaDAO(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {
			// TODO: handle exception
		}
      }
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SOUPController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Hola Servlet..");
		String action = request.getParameter("action");	//aqui llegan todas las peticiones
		System.out.println(action);
		try {
			switch (action) {
			case "registrer":
				System.out.println("entro");
				registrer(request, response);
				break;
			case "matricular":
				System.out.println("entro");
				matricular(request, response);
				break;
			case "mostrarPorCurso":
				System.out.println("entro");
				mostrarPorCurso(request, response);
				break;
			case "mostrarEstudiante":
				System.out.println("entro");
				mostrarEstudiante(request, response);
				break;
			case "eliminar":
				System.out.println("entro");
				eliminar(request, response);
				break;
			case "eliminarEstudiante":
				System.out.println("entro");
				eliminarEstudiante(request, response);
				break;
			default:
				break;
			}			
		} catch (SQLException e) {
			e.getStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	//registrar estudiante
	private void registrer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		Estudiante estudiante = new Estudiante(Integer.parseInt(request.getParameter("cui")), request.getParameter("nombre"), Integer.parseInt(request.getParameter("dni")),request.getParameter("email"));
		System.out.println("estudiante creado");
		estudianteDAO.insertar(estudiante);
		System.out.println("Insertado");
		request.setAttribute("estudiante", estudiante);
		getServletContext().getRequestDispatcher("/HTMLFiles/RegistrarEstudiante/RegistroFinalizado.jsp").forward(request, response);
		
	}
	//matricular un estudiante en un laboratorio
	private void matricular(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		System.out.println("Insertado");
		System.out.println(Integer.parseInt(request.getParameter("cui")));
		System.out.println(Integer.parseInt(request.getParameter("idCurso")));
		System.out.println(Integer.parseInt(request.getParameter("turno")));
		Matricula matricula = new Matricula(0, Integer.parseInt(request.getParameter("cui")), Integer.parseInt(request.getParameter("idCurso")), Integer.parseInt(request.getParameter("turno")));
		System.out.println("matricula creado");
		
		matriculaDAO.insertar(matricula);
		System.out.println("Insertado");
		request.setAttribute("estudiante", matricula);
		getServletContext().getRequestDispatcher("/Index.html").forward(request, response);
		
	}
	
	//mostrar los estudiantes por curso
	private void mostrarPorCurso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		
		System.out.println(Integer.parseInt(request.getParameter("idCurso")));
		List<Estudiante> ListaEstudiante = MatriculaDAO.ListarPorCurso(Integer.parseInt(request.getParameter("idCurso")));
		System.out.println("Listo");
		request.setAttribute("lista", ListaEstudiante);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/HTMLFiles/Mostrar/MostrarPorCurso.jsp");
		dispatcher.forward(request, response);
	
	}

	//mostrar lo cursos en los que un estudiante esta matriculado
	private void mostrarEstudiante(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
			
			System.out.println(Integer.parseInt(request.getParameter("mycui")));
			List<Curso> ListaCursos = MatriculaDAO.ListarPorEstudiante(Integer.parseInt(request.getParameter("mycui")));
			System.out.println("Listo");
			request.setAttribute("lista", ListaCursos);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/HTMLFiles/Mostrar/MostrarEstudiante.jsp");
			dispatcher.forward(request, response);
		}

		//elimina una matricula
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		
		matriculaDAO.eliminar(Integer.parseInt(request.getParameter("id")));
		if (request.getParameter("mycui")!=null)
		{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/SOUPController?action=mostrarEstudiante&mycui="+Integer.parseInt(request.getParameter("mycui")));
		dispatcher.forward(request, response);
		}
		if (request.getParameter("idCurso")!=null)
		{
			System.out.println("Rediriginedo");
			System.out.println(Integer.parseInt(request.getParameter("idCurso")));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/SOUPController?action=mostrarPorCurso&idCurso="+Integer.parseInt(request.getParameter("idCurso")));
			dispatcher.forward(request, response);
		}
	}
	
	//elimina un estudiente y las matriculas registradas un su cui
	
	private void eliminarEstudiante(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
			System.out.println("entro a eliminar");
			System.out.println(Integer.parseInt(request.getParameter("cui")));
			estudianteDAO.eliminar(Integer.parseInt(request.getParameter("cui")));
			System.out.println("Rediriginedo");
			getServletContext().getRequestDispatcher("/Index.html").forward(request, response);
		}
	
	
	

}

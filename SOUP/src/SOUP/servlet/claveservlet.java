package SOUP.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *Servlet de comprobacion de administrador
 * Servlet implementation class claveservlet
 */
@WebServlet("/claveservlet")
public class claveservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public claveservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String clave = request.getParameter("admi");
		System.out.println("En el servlet");
		if("admin".equals(clave)) {		//si la contraseña ingresada es igual a la definida, redirecciona al html de registro del estudiante	
			System.out.println("Correcto");
			request.getRequestDispatcher("/HTMLFiles/RegistrarEstudiante/EstudianteIndex.html").forward(request, response);
		}
		
		else {
			System.out.println("Incorrecto");
			request.getRequestDispatcher("/Index.html").forward(request, response);
		}
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//doGet(request, response);
	}
}
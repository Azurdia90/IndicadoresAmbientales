package Controlador;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelos.Variable;
import Modelos.Areas_Geograficas;
import Modelos.Areas_Intervencion;
import Modelos.Periodicidad;

/**
 * Servlet implementation class variable_controlador
 */
@WebServlet("/variable_controlador")
public class variable_controlador extends HttpServlet {

	Variable variable;
	Areas_Geograficas area_geografica;
	Areas_Intervencion area_intervencion;
	Periodicidad periodicidad;
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public variable_controlador() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("command");
		
		if (action.equalsIgnoreCase("showAll"))
		{ 
			variable = new Variable();
			request.setAttribute("variables", variable.listar());
			request.getRequestDispatcher("catalogo_variables.jsp").forward(request, response);	
		}
		else if (action.equalsIgnoreCase("edit"))
		{
			
			variable = new Variable(); 
			int p_id = Integer.parseInt(request.getParameter("id")); 
			request.setAttribute("variable", variable.buscar(p_id));
			
			area_geografica = new Areas_Geograficas();
			request.setAttribute("areas_geograficas", area_geografica.listar());
			
			area_intervencion = new Areas_Intervencion();
			request.setAttribute("areas_intervencion", area_intervencion.listar());
			
			periodicidad = new Periodicidad();
			request.setAttribute("lista_periodicidad", periodicidad.listar());
			
			request.getRequestDispatcher("catalogo_variables_modificar.jsp").forward(request, response);	
		}
		else if (action.equalsIgnoreCase("create"))
		{
			variable = new Variable(); 
			
			int codigo_nuevo = Integer.parseInt(variable.getUltimo_codigo()) + 1;
			request.setAttribute("codigo", String.valueOf(codigo_nuevo));
			
			area_geografica = new Areas_Geograficas();
			request.setAttribute("areas_geograficas", area_geografica.listar());
			
			area_intervencion = new Areas_Intervencion();
			request.setAttribute("areas_intervencion", area_intervencion.listar());
			
			periodicidad = new Periodicidad();
			request.setAttribute("lista_periodicidad", periodicidad.listar());
			
			request.getRequestDispatcher("catalogo_variables_crear.jsp").forward(request, response);	
		}
		else
		{
			response.getWriter().append("Served at: " + action + " ").append(request.getContextPath());
		}
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: " + " doPost").append(request.getContextPath());
		String action = request.getParameter("command");
		
		if (action.equalsIgnoreCase("edit"))
		{
			String idString = request.getParameter("id");
			String nombre = request.getParameter("nombre");
		    String areaGeograficaString = request.getParameter("areas_geograficas");
		    String areaIntervencionString = request.getParameter("areas_intervencion");
		    String periodicidadString = request.getParameter("periodicidad");
		    String descripcion = request.getParameter("descripcion");
		    
		    try {
		    	
		    	int id = Integer.parseInt(idString);
		        int areaGeografica = Integer.parseInt(areaGeograficaString);
		        int areaIntervencion = Integer.parseInt(areaGeograficaString);
		        int periodicidad = Integer.parseInt(periodicidadString);
		        
		        Variable variable_aux = new Variable();
		        boolean variable_result = variable_aux.modificar(id, nombre, areaGeografica, areaIntervencion, periodicidad, descripcion);
		        
		        if (variable_result) {
		            // Redirect to a success page or display a success message
		        	request.setAttribute("variables", variable_aux.listar());
					request.getRequestDispatcher("catalogo_variables.jsp").forward(request, response);	
		            //response.sendRedirect("success.jsp"); // Replace with your actual success page
		        } else {
		            // Redirect to an error page or display an error message
					request.getRequestDispatcher("index.jsp").forward(request, response);	
		            //response.sendRedirect("error.jsp"); // Replace with your actual error page
		        }
		       
		    } catch (NumberFormatException e) {
		        // Handle invalid input (e.g., the selected value is not a valid integer)
		    }
		}
		else if (action.equalsIgnoreCase("create"))
		{
			String codigo = request.getParameter("codigo");
			String nombre = request.getParameter("nombre"); 
		    String areaGeograficaString = request.getParameter("areas_geograficas");
		    String areaIntervencionString = request.getParameter("areas_intervencion");
		    String periodicidadString = request.getParameter("lista_periodicidad");
		    String descripcion = request.getParameter("descripcion");
		    
		    try {
		    	
		        int areaGeografica = Integer.parseInt(areaGeograficaString); 
		        int areaIntervencion = Integer.parseInt(areaGeograficaString); 
		        int periodicidad = Integer.parseInt(periodicidadString); System.out.println(areaGeografica);
		        
		        Variable variable_aux = new Variable();
		        boolean variable_result = variable_aux.agregar(codigo, nombre, areaGeografica, areaIntervencion, periodicidad, descripcion);
		        
		        if (variable_result) {
		            // Redirect to a success page or display a success message
		        	request.setAttribute("variables", variable_aux.listar());
					request.getRequestDispatcher("catalogo_variables.jsp").forward(request, response);	
		            //response.sendRedirect("success.jsp"); // Replace with your actual success page
		        } else {
		            // Redirect to an error page or display an error message
					request.getRequestDispatcher("index.jsp").forward(request, response);	
		            //response.sendRedirect("error.jsp"); // Replace with your actual error page
		        }
		       
		    } catch (NumberFormatException e) {
		        // Handle invalid input (e.g., the selected value is not a valid integer)
		    	response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid ID format");
		    }
		}
		else if(action.equalsIgnoreCase("delete"))
		{
			String idString = request.getParameter("id");
			System.out.print("intentando eliminar: " + idString);
			try {
		    	
		    	int id = Integer.parseInt(idString);

		        Variable variable_aux = new Variable();
		        boolean variable_result = variable_aux.eliminar(id);
		        
		        if (variable_result) {
	                // Respond with success status (HTTP 200 OK)
	                response.setStatus(HttpServletResponse.SC_OK);
	            } else {
	                // Respond with an error status (HTTP 500 Internal Server Error)
	                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to delete variable");
	            }
		       
		    } catch (NumberFormatException e) {
		        // Handle invalid input (e.g., the selected value is not a valid integer)
		    	response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid ID format");
		    }
			
		}
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
}

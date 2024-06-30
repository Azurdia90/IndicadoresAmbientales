package Controlador;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelos.Unidad;

/**
 * Servlet implementation class unidad_controlador
 */
@WebServlet("/unidad_controlador")
public class unidad_controlador extends HttpServlet {

	Unidad unidad;
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public unidad_controlador() {
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
			unidad = new Unidad();
			request.setAttribute("unidades", unidad.listar());
			request.getRequestDispatcher("catalogo_unidades_academicas.jsp").forward(request, response);	
		}
		else if (action.equalsIgnoreCase("edit"))
		{
			
			unidad = new Unidad(); 
			int p_id = Integer.parseInt(request.getParameter("id")); 
			request.setAttribute("unidad", unidad.buscar_id(p_id));
			request.getRequestDispatcher("catalogo_unidad_academica_modificar.jsp").forward(request, response);	
		}
		else if (action.equalsIgnoreCase("create"))
		{
			unidad = new Unidad(); 
			
			int codigo_nuevo = Integer.parseInt(unidad.getUltimo_codigo()) + 1;
			request.setAttribute("id", String.valueOf(codigo_nuevo));
			
			request.getRequestDispatcher("catalogo_unidad_academica_crear.jsp").forward(request, response);	
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
			String tipoString = request.getParameter("tipo");
		    
		    try {
		    	
		    	int id = Integer.parseInt(idString);
		    	int tipo = Integer.parseInt(tipoString);
		        
		        Unidad unidad_aux = new Unidad();
		        boolean unidad_result = unidad_aux.modificar(id, nombre, tipo);
		        
		        if (unidad_result) {
		            // Redirect to a success page or display a success message
		        	request.setAttribute("unidades", unidad_aux.listar());
					request.getRequestDispatcher("catalogo_unidades_academicas.jsp").forward(request, response);	
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
			String idString = request.getParameter("id");
			String nombre = request.getParameter("nombre");
			String tipoString = request.getParameter("tipo");
		    
		    try {
		    	
		    	int id = Integer.parseInt(idString);
		    	int tipo = Integer.parseInt(tipoString);

		        Unidad unidad_aux = new Unidad();
		        boolean unidad_result = unidad_aux.agregar( id, nombre, tipo);
		        
		        if (unidad_result) {
		            // Redirect to a success page or display a success message
		        	request.setAttribute("unidades", unidad_aux.listar());
					request.getRequestDispatcher("catalogo_unidades_academicas.jsp").forward(request, response);	
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
		else
		{
			response.getWriter().append("Served at: " + action + " ").append(request.getContextPath());
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
		
		String idString = request.getParameter("id");
		try {
	    	
	    	int id = Integer.parseInt(idString);

	        Unidad unidad_aux = new Unidad();
	        boolean unidad_result = unidad_aux.eliminar(id);
	        
	        if (unidad_result) {
                // Respond with success status (HTTP 200 OK)
                response.setStatus(HttpServletResponse.SC_OK);
            } else {
                // Respond with an error status (HTTP 500 Internal Server Error)
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to delete unidad");
            }
	       
	    } catch (NumberFormatException e) {
	        // Handle invalid input (e.g., the selected value is not a valid integer)
	    	response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid ID format");
	    }
	}
	
}

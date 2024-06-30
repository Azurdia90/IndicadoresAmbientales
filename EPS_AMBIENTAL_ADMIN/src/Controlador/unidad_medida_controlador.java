package Controlador;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelos.Unidad_medida;

/**
 * Servlet implementation class unidad_controlador
 */
@WebServlet("/unidad_medida_controlador")
public class unidad_medida_controlador extends HttpServlet {

	Unidad_medida unidad;
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public unidad_medida_controlador() {
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
			unidad = new Unidad_medida();
			request.setAttribute("unidades_medida", unidad.listar());
			request.getRequestDispatcher("catalogo_unidades_medida.jsp").forward(request, response);	
		}
		else if (action.equalsIgnoreCase("edit"))
		{
			
			unidad = new Unidad_medida(); 
			int p_id = Integer.parseInt(request.getParameter("id")); 
			request.setAttribute("unidad", unidad.buscar_id(p_id));
			request.getRequestDispatcher("catalogo_unidades_medida_modificar.jsp").forward(request, response);	
		}
		else if (action.equalsIgnoreCase("create"))
		{
			unidad = new Unidad_medida(); 
			
			int codigo_nuevo = Integer.parseInt(unidad.getUltimo_codigo()) + 1;
			request.setAttribute("codigo", String.valueOf(codigo_nuevo));
			
			request.getRequestDispatcher("catalogo_unidades_medida_crear.jsp").forward(request, response);	
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
			String codigo = request.getParameter("codigo");
			String nombre = request.getParameter("nombre");
			String descripcion = request.getParameter("descripcion");
		    
		    try {
		    	
		    	int id = Integer.parseInt(idString);
		        
		        Unidad_medida aux_unidad_medida = new Unidad_medida();
		        boolean unidad_result = aux_unidad_medida.modificar(id, nombre, descripcion);
		        
		        if (unidad_result) {
		            // Redirect to a success page or display a success message
		        	request.setAttribute("unidades_medida", aux_unidad_medida.listar());
					request.getRequestDispatcher("catalogo_unidades_medida.jsp").forward(request, response);	
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
			String codigo = request.getParameter("codigo");
			String nombre = request.getParameter("nombre");
			String descripcion = request.getParameter("descripcion");
		    
		    try {		    	

		        Unidad_medida aux_unidad_medida = new Unidad_medida();
		        boolean unidad_result = aux_unidad_medida.agregar(codigo, nombre, descripcion);
		        
		        if (unidad_result) {
		            // Redirect to a success page or display a success message
		        	request.setAttribute("unidades_medida", aux_unidad_medida.listar());
					request.getRequestDispatcher("catalogo_unidades_medida.jsp").forward(request, response);	
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

	        Unidad_medida aux_unidad_medida = new Unidad_medida();
	        boolean unidad_result = aux_unidad_medida.eliminar(id);
	        
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

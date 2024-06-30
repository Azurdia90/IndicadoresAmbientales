
package Controlador;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelos.Areas_Geograficas;
import Modelos.Areas_Intervencion;

/**
 * Servlet implementation class areas_intervencion_controlador
 */
@WebServlet("/areas_intervencion_controlador")
public class areas_intervencion_controlador extends HttpServlet {

	Areas_Intervencion areas_intervencion;
	Areas_Geograficas area_geografica;
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public areas_intervencion_controlador() {
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
			areas_intervencion = new Areas_Intervencion();
			request.setAttribute("areas_intervencion", areas_intervencion.listar());
			request.getRequestDispatcher("catalogo_area_intervencion.jsp").forward(request, response);	
		}
		else if (action.equalsIgnoreCase("edit"))
		{
			areas_intervencion = new Areas_Intervencion(); 
			int p_id = Integer.parseInt(request.getParameter("id")); 
			request.setAttribute("area_intervencion", areas_intervencion.buscar_id(p_id));
			
			area_geografica = new Areas_Geograficas();
			request.setAttribute("areas_geograficas", area_geografica.listar());
			
			request.getRequestDispatcher("catalogo_area_intervencion_modificar.jsp").forward(request, response);	
		}
		else if (action.equalsIgnoreCase("create"))
		{
			areas_intervencion = new Areas_Intervencion(); 
			
			int codigo_nuevo = Integer.parseInt(areas_intervencion.getUltimo_codigo()) + 1;
			request.setAttribute("codigo", String.valueOf(codigo_nuevo));
			
			area_geografica = new Areas_Geograficas();
			request.setAttribute("areas_geograficas", area_geografica.listar());
			
			request.getRequestDispatcher("catalogo_area_intervencion_crear.jsp").forward(request, response);	
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
			String areaGeograficaString = request.getParameter("areas_geograficas");
			String descripcion = request.getParameter("descripcion");
		    
		    try {
		    	
		    	int id = Integer.parseInt(idString);;
		    	int areaGeografica = Integer.parseInt(areaGeograficaString);
		        
		        Areas_Intervencion areas_intervencion_aux = new Areas_Intervencion();
		        boolean areas_intervencion_result = areas_intervencion_aux.modificar(id, nombre, areaGeografica, descripcion);
		        
		        if (areas_intervencion_result) {
		            // Redirect to a success page or display a success message
		        	request.setAttribute("areas_intervencion", areas_intervencion_aux.listar());
					request.getRequestDispatcher("catalogo_area_intervencion.jsp").forward(request, response);	
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
			String descripcion = request.getParameter("descripcion");
		    System.out.print("descripcion:" + descripcion);
		    try {
		    	
		    	int areaGeografica = Integer.parseInt(areaGeograficaString);

		        Areas_Intervencion areas_intervencion_aux = new Areas_Intervencion();
		        boolean areas_intervencion_result = areas_intervencion_aux.agregar(codigo, nombre, areaGeografica, descripcion);
		        
		        if (areas_intervencion_result) {
		            // Redirect to a success page or display a success message
		        	request.setAttribute("areas_intervencion", areas_intervencion_aux.listar());
					request.getRequestDispatcher("catalogo_area_intervencion.jsp").forward(request, response);	
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

	        Areas_Intervencion areas_intervencion_aux = new Areas_Intervencion();
	        boolean areas_intervencion_result = areas_intervencion_aux.eliminar(id);
	        
	        if (areas_intervencion_result) {
                // Respond with success status (HTTP 200 OK)
                response.setStatus(HttpServletResponse.SC_OK);
            } else {
                // Respond with an error status (HTTP 500 Internal Server Error)
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to delete areas_intervencion");
            }
	       
	    } catch (NumberFormatException e) {
	        // Handle invalid input (e.g., the selected value is not a valid integer)
	    	response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid ID format");
	    }
	}
	
}

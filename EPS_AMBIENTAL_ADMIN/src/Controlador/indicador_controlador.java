package Controlador;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelos.Indicador;
import Modelos.Areas_Geograficas;
import Modelos.Areas_Intervencion;
import Modelos.Ejes_Politica_Ambiental;
import Modelos.Unidad_medida;
import Modelos.Periodicidad;
import Modelos.ODS;
import Modelos.Unidad;

/**
 * Servlet implementation class variable_controlador
 */
@WebServlet("/indicador_controlador")
public class indicador_controlador extends HttpServlet {

	Indicador indicador;
	Areas_Geograficas area_geografica;
	Unidad_medida unidad_medida;
	Periodicidad periodicidad;
	
	Ejes_Politica_Ambiental ejes_politica_ambiental;
	Areas_Intervencion  area_intervencion;
	ODS ods;
	Unidad unidad;
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public indicador_controlador() {
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
			indicador = new Indicador();
			request.setAttribute("indicadores", indicador.listar());
			request.getRequestDispatcher("catalogo_indicadores.jsp").forward(request, response);	
		}
		else if (action.equalsIgnoreCase("newId"))
		{
			int p_id = Integer.parseInt(request.getParameter("id")); 
			System.out.println(p_id);
		}
		else if (action.equalsIgnoreCase("edit"))
		{
			
			indicador = new Indicador(); 
			int p_id = Integer.parseInt(request.getParameter("id")); 
			request.setAttribute("indicador", indicador.buscar(p_id));
			
			area_geografica = new Areas_Geograficas();
			request.setAttribute("areas_geograficas", area_geografica.listar());
			
			unidad_medida = new Unidad_medida();
			request.setAttribute("unidades_medida", unidad_medida.listar());
			
			periodicidad = new Periodicidad();
			request.setAttribute("lista_periodicidad", periodicidad.listar());
			
			ejes_politica_ambiental = new Ejes_Politica_Ambiental();
			request.setAttribute("ejes_politicas_ambientales", ejes_politica_ambiental.listar());
			
			area_intervencion = new Areas_Intervencion();
			request.setAttribute("areas_intervencion", area_intervencion.listar());
			
			ods = new ODS();
			request.setAttribute("ods_s", ods.listar());
			
			unidad = new Unidad();
			request.setAttribute("unidades", unidad.listar());
			
			request.getRequestDispatcher("catalogo_indicadores_modificar.jsp").forward(request, response);	
		}
		else if (action.equalsIgnoreCase("create"))
		{
			indicador = new Indicador(); 
			
			String codigo_nuevo = (indicador.getUltimo_codigo());
			request.setAttribute("codigo", codigo_nuevo);
			
			area_geografica = new Areas_Geograficas();
			request.setAttribute("areas_geograficas", area_geografica.listar());
			
			unidad_medida = new Unidad_medida();
			request.setAttribute("unidades_medida", unidad_medida.listar());
			
			periodicidad = new Periodicidad();
			request.setAttribute("lista_periodicidad", periodicidad.listar());
			
			ejes_politica_ambiental = new Ejes_Politica_Ambiental();
			request.setAttribute("ejes_politicas_ambientales", ejes_politica_ambiental.listar());
			
			area_intervencion = new Areas_Intervencion();
			request.setAttribute("areas_intervencion", area_intervencion.listar());
			
			ods = new ODS();
			request.setAttribute("ods_s", ods.listar());
			
			unidad = new Unidad();
			request.setAttribute("unidades", unidad.listar());
			
			request.getRequestDispatcher("catalogo_indicadores_crear.jsp").forward(request, response);	
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
			String formula = request.getParameter("formula");
		    String areaGeograficaString = request.getParameter("area_geografica");
		    String unidadMedidaString = request.getParameter("unidades_medida");
		    String periodicidadString = request.getParameter("lista_periodicidad");
		    String descripcion = request.getParameter("descripcion");
		   
		    String[] ejes_politica_ambiental_seleccionadas = request.getParameterValues("ejes_politicas_ambientales");
		    String[] areas_intervencion_seleccionadas = request.getParameterValues("areas_intervencion");
		    String[] ods_seleccionadas = request.getParameterValues("ods_s");
		    String[] unidades_seleccionadas = request.getParameterValues("unidades");
		    
		    try {
		    	
		    	int id = Integer.parseInt(idString);
		        int areaGeografica = Integer.parseInt(areaGeograficaString);
		        int unidadMedida = Integer.parseInt(areaGeograficaString);
		        int periodicidad = Integer.parseInt(periodicidadString);
		        
		        Indicador indicador_aux = new Indicador();
		        
		        boolean variable_result = indicador_aux.modificar(id, nombre, formula, areaGeografica, unidadMedida, periodicidad, descripcion);
		        boolean variable_result2 = indicador_aux.modificarListaEje_politica_ambiental(id, ejes_politica_ambiental_seleccionadas);
		        boolean variable_result3 = indicador_aux.modificarListaAreas_intervencion(id, areas_intervencion_seleccionadas);
		        boolean variable_result4 = indicador_aux.modificarListaODS(id, ods_seleccionadas);
		        boolean variable_result5 = indicador_aux.modificarListaUnidades(id, unidades_seleccionadas);
		        
		        if (variable_result && variable_result2 && variable_result3 && variable_result4 && variable_result5) {
		            // Redirect to a success page or display a success message
		        	request.setAttribute("indicadores", indicador_aux.listar());
					request.getRequestDispatcher("catalogo_indicadores.jsp").forward(request, response);	
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
			String formula = request.getParameter("formula");
		    String areaGeograficaString = request.getParameter("area_geografica");
		    String unidadMedidaString = request.getParameter("unidades_medida");
		    String periodicidadString = request.getParameter("lista_periodicidad");
		    String descripcion = request.getParameter("descripcion");
		   
		    String[] ejes_politica_ambiental_seleccionadas = request.getParameterValues("ejes_politicas_ambientales");
		    String[] areas_intervencion_seleccionadas = request.getParameterValues("areas_intervencion");
		    String[] ods_seleccionadas = request.getParameterValues("ods_s");
		    String[] unidades_seleccionadas = request.getParameterValues("unidades");
		    
		    try {
		    	
		        int areaGeografica = Integer.parseInt(areaGeograficaString);
		        int unidadMedida = Integer.parseInt(areaGeograficaString);
		        int periodicidad = Integer.parseInt(periodicidadString);
		        
		        Indicador indicador_aux = new Indicador();
		        
		        boolean variable_result = indicador_aux.agregar(codigo, nombre, formula, areaGeografica, unidadMedida, periodicidad, descripcion);
		        
		        boolean variable_result2 = indicador_aux.modificarListaEje_politica_ambiental(indicador_aux.getId(), ejes_politica_ambiental_seleccionadas);
		        boolean variable_result3 = indicador_aux.modificarListaAreas_intervencion(indicador_aux.getId(), areas_intervencion_seleccionadas);
		        boolean variable_result4 = indicador_aux.modificarListaODS(indicador_aux.getId(), ods_seleccionadas);
		        boolean variable_result5 = indicador_aux.modificarListaUnidades(indicador_aux.getId(), unidades_seleccionadas);
		        
		        if (variable_result && variable_result2 && variable_result3 && variable_result4 && variable_result5) {
		            // Redirect to a success page or display a success message
		        	request.setAttribute("indicadores", indicador_aux.listar());
					request.getRequestDispatcher("catalogo_indicadores.jsp").forward(request, response);	
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

		        Indicador indicador_aux = new Indicador();
		        boolean variable_result = indicador_aux.eliminar(id);
		        
		        if (variable_result) {
	                // Respond with success status (HTTP 200 OK)
	                response.setStatus(HttpServletResponse.SC_OK);
	            } else {
	                // Respond with an error status (HTTP 500 Internal Server Error)
	                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to delete indicador");
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

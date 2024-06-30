package Controllers;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.json.JSONObject;

import com.itextpdf.text.DocumentException;

import Models.Pagina_ambiental;
import Models.Pagina_ambiental_carrete;
import Models.Pagina_ambiental_carrete_seccion;
import Models.Pagina_ambiental_carrete_tip;
import Models.Pagina_ambiental_menu;
import Models.Pagina_ambiental_menu_seccion;
import Models.Pagina_ambiental_seccion;
import Models.Pagina_ambiental_seccion_tipo;
import SQL.CustomExclusionStrategy;

/**
 * Servlet implementation class admin_controller
 */
@WebServlet("/admin_controller")
@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024, // 1MB
	    maxFileSize = 1024 * 1024 * 10, // 10MB
	    maxRequestSize = 1024 * 1024 * 50 // 50MB
	)
public class admin_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public admin_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("command");
		
		if (action.equalsIgnoreCase("showAll"))
		{
			Pagina_ambiental contenido = new Pagina_ambiental();
			try {
				request.setAttribute("menu_logo", components_web_controller.getInstance().menu_logo);
				request.setAttribute("paginas", contenido.listar());
				request.setAttribute("footer_logo1", components_web_controller.getInstance().footer_logo1);
			    request.setAttribute("footer_logo2", components_web_controller.getInstance().footer_logo2);
			    request.setAttribute("footer_logo3", components_web_controller.getInstance().footer_logo3);
			} 
			catch (Exception e) 
			{
				 System.out.println("Exception admin_controller - doGet:" + e.getMessage());
			}
			
			request.getRequestDispatcher("cgp_admin_principal.jsp").forward(request, response);
		}
		else if (action.equalsIgnoreCase("showSeccion"))
		{   
			String sectionIdString = request.getParameter("id");
			int sectionId = Integer.parseInt(sectionIdString);
			Pagina_ambiental_seccion seccion = new Pagina_ambiental_seccion(sectionId);
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("pagina_id", seccion.getId_pagina_ambiental());
			jsonObject.put("id", seccion.getId());
			jsonObject.put("codigo", seccion.getCodigo());
			jsonObject.put("tipo", seccion.getTipo());
			jsonObject.put("titulo", seccion.getTitulo());
			jsonObject.put("imagen", seccion.getPath_image());
			jsonObject.put("texto", seccion.getTexto());
			jsonObject.put("css", seccion.getClase_css());
			jsonObject.put("css", seccion.getClase_css());
			jsonObject.put("descripcion", seccion.getDescripcion());
			jsonObject.put("visible", seccion.getVisible() ==  1 ? true : false);
			
			// Set response content type
	        response.setContentType("application/json");
	        
	        // Write section data as JSON response
	        PrintWriter out = response.getWriter();
	        out.print(jsonObject); // Assuming Section class has a method toJSON() that returns JSON representation
	        out.flush();
			
		}
		else if (action.equalsIgnoreCase("showCarrete"))
		{
			String sectionIdString = request.getParameter("id");
			int sectionId = Integer.parseInt(sectionIdString);
			Pagina_ambiental_carrete seccion = new Pagina_ambiental_carrete(sectionId);
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("pagina_id", seccion.getId_pagina_ambiental());
			jsonObject.put("id", seccion.getId());
			jsonObject.put("codigo", seccion.getCodigo());
			jsonObject.put("titulo", seccion.getTitulo());
			jsonObject.put("css", seccion.getClase_css());
			jsonObject.put("descripcion", seccion.getDescripcion());
			jsonObject.put("carrete_secciones", seccion.getLista_seccion());
			jsonObject.put("visible", seccion.getVisible() ==  1 ? true : false);
			
			// Set response content type
	        response.setContentType("application/json");
	        
	        // Write section data as JSON response
	        PrintWriter out = response.getWriter();
	        out.print(jsonObject); // Assuming Section class has a method toJSON() that returns JSON representation
	        out.flush();
			
		}
		else if (action.equalsIgnoreCase("showCarreteSeccion"))
		{
			String carretesectionIdString = request.getParameter("id");
			int carretesectionId = Integer.parseInt(carretesectionIdString); 
			Pagina_ambiental_carrete_seccion seccion = new Pagina_ambiental_carrete_seccion(carretesectionId);
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("carrete_id", seccion.getCarrete_id());
			jsonObject.put("id", seccion.getId());
			jsonObject.put("tipo", seccion.getCarrete_type());
			jsonObject.put("codigo", seccion.getCodigo());
			jsonObject.put("titulo", seccion.getTittle());
			jsonObject.put("enlace", seccion.getEnlace());
			jsonObject.put("css", seccion.getClase_css());
			jsonObject.put("visible", seccion.getVisible() ==  1 ? true : false);
			jsonObject.put("subtitulo", seccion.getSubtittle());
			jsonObject.put("texto", seccion.getText());
			
			// Set response content type
	        response.setContentType("application/json");
	        
	        // Write section data as JSON response
	        PrintWriter out = response.getWriter();
	        out.print(jsonObject); // Assuming Section class has a method toJSON() that returns JSON representation
	        out.flush();
			
		}
		else if (action.equalsIgnoreCase("showMenu"))
		{
			String sectionIdString = request.getParameter("id");
			int sectionId = Integer.parseInt(sectionIdString);
			Pagina_ambiental_menu seccion = new Pagina_ambiental_menu(sectionId);
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("pagina_id", seccion.getId_pagina_ambiental());
			jsonObject.put("id", seccion.getId());
			jsonObject.put("codigo", seccion.getCodigo());
			jsonObject.put("titulo", seccion.getTitulo());
			jsonObject.put("css", seccion.getClase_css());
			jsonObject.put("descripcion", seccion.getDescripcion());
			jsonObject.put("menu_secciones", seccion.getLista_secciones());
			jsonObject.put("visible", seccion.getVisible() ==  1 ? true : false);
			
			// Set response content type
	        response.setContentType("application/json");
	        
	        // Write section data as JSON response
	        PrintWriter out = response.getWriter();
	        out.print(jsonObject); // Assuming Section class has a method toJSON() that returns JSON representation
	        out.flush();
			
		}
		else if (action.equalsIgnoreCase("showMenuSeccion"))
		{
			String menusectionIdString = request.getParameter("id");
			int menusectionId = Integer.parseInt(menusectionIdString); 
			Pagina_ambiental_menu_seccion seccion = new Pagina_ambiental_menu_seccion(menusectionId);
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("menu_id", seccion.getMenu_id());
			jsonObject.put("id", seccion.getId());
			jsonObject.put("codigo", seccion.getCodigo());
			jsonObject.put("texto", seccion.getTexto());
			jsonObject.put("enlace", seccion.getEnlace());
			jsonObject.put("css", seccion.getClase_css());
			jsonObject.put("visible", seccion.getVisible() ==  1 ? true : false);
			
			// Set response content type
	        response.setContentType("application/json");
	        
	        // Write section data as JSON response
	        PrintWriter out = response.getWriter();
	        out.print(jsonObject); // Assuming Section class has a method toJSON() that returns JSON representation
	        out.flush();
			
		}
		else if (action.equalsIgnoreCase("edit"))
		{
			int p_id = Integer.parseInt(request.getParameter("id")); 
			
			Pagina_ambiental contenido = new Pagina_ambiental(p_id);
			Pagina_ambiental_seccion_tipo tipo_seccion = new Pagina_ambiental_seccion_tipo();
			
			try {
				request.setAttribute("menu_logo", components_web_controller.getInstance().menu_logo);
				request.setAttribute("pagina", contenido);
				request.setAttribute("secciones", tipo_seccion.listar());
				request.setAttribute("footer_logo1", components_web_controller.getInstance().footer_logo1);
			    request.setAttribute("footer_logo2", components_web_controller.getInstance().footer_logo2);
			    request.setAttribute("footer_logo3", components_web_controller.getInstance().footer_logo3);
			} 
			catch (Exception e) 
			{
				 System.out.println("Exception admin_controller - doGet:" + e.getMessage());
			}
			
			request.getRequestDispatcher("cgp_admin_pagina.jsp").forward(request, response);
		}
		else if (action.equalsIgnoreCase("visible"))
		{
		}
		else
		{
			response.getWriter().append("Served at: " + action + " ").append(request.getContextPath());
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
		
		String action = request.getParameter("command");
		
		String context_hd = "";
		
		if (action.equalsIgnoreCase("editPage"))
		{
			String idPageString = request.getParameter("pagina_id");
			String codigo = request.getParameter("pagina_codigo");
			String nombre = request.getParameter("pagina_nombre");
			Part image = request.getPart("pagina_imagen");
			String descripcion = request.getParameter("pagina_descripcion");
			
			
			try {
				context_hd = components_web_controller.getProperty("ASSETS_HEADER_IMAGE");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
            String context_db = "assets" + File.separator + "Header_Images";
            String image_fileName = "";
			
			if (image != null) {
                for (String content : image.getHeader("content-disposition").split(";")) {
                    if (content.trim().startsWith("filename")) {
                        image_fileName = content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
                        break;
                    }
                }
            }

            try {
                if (!image_fileName.equalsIgnoreCase("")) {
                    
                    File directory = new File(context_hd);
                    if (!directory.exists()) {
                        directory.mkdirs();
                    }

                    String fullPath = context_hd + File.separator + image_fileName;
                    image.write(fullPath); 
                    image_fileName = context_db + File.separator + image_fileName;
                }
		    	
				int p_id = Integer.parseInt(idPageString);
				Pagina_ambiental pagina_aux = new Pagina_ambiental(p_id);
		        boolean pagina_result = pagina_aux.modificar(p_id, nombre, image_fileName, true, descripcion);
		      
		        if (pagina_result) {
		            // Redirect to a success page or display a success message
		        	try
					{
		        		request.setAttribute("menu_logo", components_web_controller.getInstance().menu_logo);
		        		request.setAttribute("pagina", pagina_aux);
						request.setAttribute("footer_logo1", components_web_controller.getInstance().footer_logo1);
					    request.setAttribute("footer_logo2", components_web_controller.getInstance().footer_logo2);
					    request.setAttribute("footer_logo3", components_web_controller.getInstance().footer_logo3);
					}
					catch(Exception e)
					{
						 System.out.println("Exception admin_controller - doPost - refresh Menu:" + e.getMessage());
					}
		        	
		        	request.getRequestDispatcher("cgp_admin_pagina.jsp").forward(request, response);	
		        	//response.sendRedirect("success.jsp"); // Replace with your actual success page
		        } else {
		            // Redirect to an error page or display an error message
					request.getRequestDispatcher("cgp_admin_principal?command=showAll").forward(request, response);	
		            //response.sendRedirect("error.jsp"); // Replace with your actual error page
		        }
		       
		    } catch (NumberFormatException e) {
		        // Handle invalid input (e.g., the selected value is not a valid integer)
		    }
			
		}
		else if (action.equalsIgnoreCase("sectionActions"))
		{
			if(request.getParameter("seccion_btnedit") != null)
			{
				String idPageString = request.getParameter("seccion_pagina_id");
				String idString = request.getParameter("seccion_id");
				String tipoString = request.getParameter("lista_seccion_tipo");
				String titulo = request.getParameter("seccion_titulo");
				String texto = request.getParameter("seccion_texto");
				Part image = request.getPart("seccion_imagen");
				String enlace = request.getParameter("seccion_enlace");
				String css = request.getParameter("seccion_css");
				String descripcion = request.getParameter("seccion_descripcion");
				
				try {
					context_hd = components_web_controller.getProperty("ASSETS_SECCION_IMAGE");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            String context_db = "assets" + File.separator + "Seccion_Images";
	            String image_fileName = "";

	            if (image != null) {
	                for (String content : image.getHeader("content-disposition").split(";")) {
	                    if (content.trim().startsWith("filename")) {
	                        image_fileName = content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
	                        break;
	                    }
	                }
	            }

	            try {
	                if (!image_fileName.equalsIgnoreCase("")) {
	                    
	                    File directory = new File(context_hd);
	                    if (!directory.exists()) {
	                        directory.mkdirs();
	                    }

	                    String fullPath = context_hd + File.separator + image_fileName;
	                    image.write(fullPath); 
	                    image_fileName = context_db + File.separator + image_fileName;
	                }
					
					int p_pageId = 0;
					int p_id = 0;
					int p_tipo = 1;
				
					if(!idPageString.equalsIgnoreCase("") && !idString.equalsIgnoreCase("") && !tipoString.equalsIgnoreCase(""))
					{
						p_pageId = Integer.parseInt(idPageString);
						p_id = Integer.parseInt(idString);
						p_tipo = Integer.parseInt(tipoString);
					}
				
					Pagina_ambiental pagina_aux = new Pagina_ambiental(p_pageId);
					Pagina_ambiental_seccion seccion_aux = new Pagina_ambiental_seccion(p_id);
					//System.out.println("1." + p_id + "2. " + p_tipo + "3. " + titulo + "4. " + texto);
			        boolean seccion_result = seccion_aux.modificar(p_id, p_tipo, titulo, texto, image_fileName, enlace, css, true, descripcion);
			        
			        JSONObject jsonResponse = new JSONObject();
			        if (seccion_result) {
			            jsonResponse.put("success", true);
			        } else {
			            jsonResponse.put("success", false);
			            jsonResponse.put("message", "There was an error modifing the section.");
			        }

			        response.setContentType("application/json");
			        try (PrintWriter out = response.getWriter()) {
			            out.print(jsonResponse);
			        }
			       
			    } catch (NumberFormatException e) {
			    	// Handle invalid input (e.g., the selected value is not a valid integer)
			    	JSONObject jsonResponse = new JSONObject();
		            jsonResponse.put("success", false);
		            jsonResponse.put("message", "Invalid input.");
		            
		            response.setContentType("application/json");
			        try (PrintWriter out = response.getWriter()) {
			            out.print(jsonResponse);
			        }
			    }
			}
			else if(request.getParameter("seccion_btnadd") != null) 
			{	
				String idPageString = request.getParameter("seccion_pagina_id");
				String codigo = request.getParameter("seccion_codigo");
				String tipoString = request.getParameter("lista_seccion_tipo");
				String titulo = request.getParameter("seccion_titulo");
				String texto = request.getParameter("seccion_texto");
				Part image = request.getPart("seccion_imagen");
				String enlace = request.getParameter("seccion_enlace");
				String css = request.getParameter("seccion_css");
				String descripcion = request.getParameter("seccion_descripcion");
				
				try {
					context_hd = components_web_controller.getProperty("ASSETS_SECCION_IMAGE");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            String context_db = "assets" + File.separator + "Seccion_Images";
	            String image_fileName = "";

	            if (image != null) {
	                for (String content : image.getHeader("content-disposition").split(";")) {
	                    if (content.trim().startsWith("filename")) {
	                        image_fileName = content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
	                        break;
	                    }
	                }
	            }

	            try {
	                if (!image_fileName.equalsIgnoreCase("")) {
	                    
	                    File directory = new File(context_hd);
	                    if (!directory.exists()) {
	                        directory.mkdirs();
	                    }

	                    String fullPath = context_hd + File.separator + image_fileName;
	                    image.write(fullPath); 
	                    image_fileName = context_db + File.separator + image_fileName;
	                }
					
					int p_pageId = 0;
					int p_tipo = 1;
					
					if(!idPageString.equalsIgnoreCase("") && !tipoString.equalsIgnoreCase(""))
					{
						p_pageId = Integer.parseInt(idPageString);
						p_tipo = Integer.parseInt(tipoString);
					}
				
					Pagina_ambiental_seccion seccion_aux = new Pagina_ambiental_seccion();
					//System.out.println("1." + p_id + "2. " + p_tipo + "3. " + titulo + "4. " + texto);
			        boolean seccion_result = seccion_aux.agregar( p_pageId, codigo, p_tipo, titulo, texto, image_fileName, enlace, css, true, descripcion);
			        
			        JSONObject jsonResponse = new JSONObject();
			        if (seccion_result) {
			            jsonResponse.put("success", true);
			        } else {
			            jsonResponse.put("success", false);
			            jsonResponse.put("message", "There was an error adding the section.");
			        }

			        response.setContentType("application/json");
			        try (PrintWriter out = response.getWriter()) {
			            out.print(jsonResponse);
			        }
			       
			    } catch (NumberFormatException e) {
			        // Handle invalid input (e.g., the selected value is not a valid integer)
			    	JSONObject jsonResponse = new JSONObject();
		            jsonResponse.put("success", false);
		            jsonResponse.put("message", "Invalid input.");
		            
		            response.setContentType("application/json");
			        try (PrintWriter out = response.getWriter()) {
			            out.print(jsonResponse);
			        }
			    }		
	        } 
			else if (request.getParameter("seccion_btndelete") != null) 
	        {
	        	
				String idString = request.getParameter("seccion_id");	
				
				int p_Id = 0;
			
				if(!idString.equalsIgnoreCase(""))
				{
					p_Id = Integer.parseInt(idString);
				}
				
				Pagina_ambiental_seccion seccion_aux = new Pagina_ambiental_seccion();
				//System.out.println("1." + p_id + "2. " + p_tipo + "3. " + titulo + "4. " + texto);
		        boolean seccion_result = seccion_aux.eliminar( p_Id );
		        
		        JSONObject jsonResponse = new JSONObject();
		        if (seccion_result) {
		            jsonResponse.put("success", true);
		        } else {
		            jsonResponse.put("success", false);
		            jsonResponse.put("message", "There was an error delete the section.");
		        }

		        response.setContentType("application/json");
		        try (PrintWriter out = response.getWriter()) {
		            out.print(jsonResponse);
		        }
				
	        }
	        else
	        {
	        	request.getRequestDispatcher("cgp_admin_principal?command=showAll").forward(request, response);	
	        }
		}
		else if (action.equalsIgnoreCase("carreteActions"))
		{
			if(request.getParameter("carrete_btnedit") != null)
			{
				String idPageString = request.getParameter("carrete_pagina_id");
				String idString = request.getParameter("carrete_id");
				String titulo = request.getParameter("carrete_titulo");
				String css = request.getParameter("carrete_css");
				String descripcion = request.getParameter("carrete_descripcion");
				
	            try 
	            {
					
					int p_pageId = 0;
					int p_id = 0;
				
					if(!idPageString.equalsIgnoreCase("") && !idString.equalsIgnoreCase(""))
					{
						p_pageId = Integer.parseInt(idPageString);
						p_id = Integer.parseInt(idString);
					}
				
					Pagina_ambiental pagina_aux = new Pagina_ambiental(p_pageId);
					Pagina_ambiental_carrete carrete_aux = new Pagina_ambiental_carrete(p_id);
					//System.out.println("1." + p_id + "2. " + p_tipo + "3. " + titulo + "4. " + texto);
			        boolean menu_result = carrete_aux.modificar(p_id, titulo, css, true, descripcion);
			        
			        JSONObject jsonResponse = new JSONObject();
			        if (menu_result) {
			            jsonResponse.put("success", true);
			        } else {
			            jsonResponse.put("success", false);
			            jsonResponse.put("message", "There was an error modifing the carrete.");
			        }

			        response.setContentType("application/json");
			        try (PrintWriter out = response.getWriter()) {
			            out.print(jsonResponse);
			        }
			       
			    } catch (NumberFormatException e) {
			    	// Handle invalid input (e.g., the selected value is not a valid integer)
			    	JSONObject jsonResponse = new JSONObject();
		            jsonResponse.put("success", false);
		            jsonResponse.put("message", "Invalid input.");
		            
		            response.setContentType("application/json");
			        try (PrintWriter out = response.getWriter()) {
			            out.print(jsonResponse);
			        }
			    }
			}
			else if(request.getParameter("carrete_btnadd") != null) 
			{	
				String idPageString = request.getParameter("carrete_pagina_id");
				String codigo = request.getParameter("carrete_codigo");
				String titulo = request.getParameter("carrete_titulo");
				String css = request.getParameter("carrete_css");
				String descripcion = request.getParameter("carrete_descripcion");
				
				try {
				
					int p_pageId = 0;
				
					if(!idPageString.equalsIgnoreCase("") )
					{
						p_pageId = Integer.parseInt(idPageString);
					}
				
					Pagina_ambiental_carrete carrete_aux = new Pagina_ambiental_carrete();
					//System.out.println("1." + p_id + "2. " + p_tipo + "3. " + titulo + "4. " + texto);
			        boolean carrete_result = carrete_aux.agregar( p_pageId, codigo, titulo, css, true, descripcion);
			        
			        JSONObject jsonResponse = new JSONObject();
			        if (carrete_result) {
			            jsonResponse.put("success", true);
			        } else {
			            jsonResponse.put("success", false);
			            jsonResponse.put("message", "There was an error adding the carrete.");
			        }

			        response.setContentType("application/json");
			        try (PrintWriter out = response.getWriter()) {
			            out.print(jsonResponse);
			        }
			       
			    } catch (NumberFormatException e) {
			        // Handle invalid input (e.g., the selected value is not a valid integer)
			    	JSONObject jsonResponse = new JSONObject();
		            jsonResponse.put("success", false);
		            jsonResponse.put("message", "Invalid input.");
		            
		            response.setContentType("application/json");
			        try (PrintWriter out = response.getWriter()) {
			            out.print(jsonResponse);
			        }
			    }
			}
            else if (request.getParameter("carrete_btndelete") != null) 
	        {
	        	
				String idString = request.getParameter("carrete_id");	
				
				int p_Id = 0;
			
				if(!idString.equalsIgnoreCase(""))
				{
					p_Id = Integer.parseInt(idString);
				}
				
				Pagina_ambiental_carrete carrete_aux = new Pagina_ambiental_carrete();
				//System.out.println("1." + p_id + "2. " + p_tipo + "3. " + titulo + "4. " + texto);
		        boolean carrete_result = carrete_aux.eliminar( p_Id );
		        
		        JSONObject jsonResponse = new JSONObject();
		        if (carrete_result) {
		            jsonResponse.put("success", true);
		        } else {
		            jsonResponse.put("success", false);
		            jsonResponse.put("message", "There was an error delete the carrete.");
		        }

		        response.setContentType("application/json");
		        try (PrintWriter out = response.getWriter()) {
		            out.print(jsonResponse);
		        }
				
	        }
	        else
	        {
	        	request.getRequestDispatcher("cgp_admin_principal?command=showAll").forward(request, response);	
	        }
		}
		else if(action.equalsIgnoreCase("carreteSectionActions"))
		{
			if(request.getParameter("carrete_seccion_btnedit") != null)
			{
				String idCarreteString = request.getParameter("carrete_seccion_carrete_id");
				String idString = request.getParameter("carrete_seccion_id");
				String typeString = request.getParameter("carrete_seccion_lista_tipo");
				String titulo = request.getParameter("carrete_seccion_titulo");
				Part image = request.getPart("carrete_seccion_imagen");
				String enlace = request.getParameter("carrete_seccion_enlace");
				String css = request.getParameter("carrete_seccion_css");
				String skinString = request.getParameter("carrete_seccion_lista_skin");
				String subtitulo = request.getParameter("carrete_seccion_subtitulo");
				String texto = request.getParameter("carrete_seccion_texto");
				//System.out.println("1. " + idCarreteString + " 2. " + idString + " 3. " + titulo + " 4. " + image + " 5. " + enlace + " 6. " + css + " 7. " + skinString + " 8. " + subtitulo + " 9." + texto);
				
				try {
					context_hd = components_web_controller.getProperty("ASSETS_CARRETE_IMAGE");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            String context_db = "assets" + File.separator + "Menu_Images";
	            String image_fileName = "";

	            if (image != null) {
	                for (String content : image.getHeader("content-disposition").split(";")) {
	                    if (content.trim().startsWith("filename")) {
	                        image_fileName = content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
	                        break;
	                    }
	                }
	            }

	            try {
	                if (!image_fileName.equalsIgnoreCase("")) {
	                    
	                    File directory = new File(context_hd);
	                    if (!directory.exists()) {
	                        directory.mkdirs();
	                    }

	                    String fullPath = context_hd + File.separator + image_fileName;
	                    image.write(fullPath); 
	                    image_fileName = context_db + File.separator + image_fileName;
	                }
					
					int p_carreteId = 0;
					int p_id = 0;
					int p_type = 0;
					int p_skin = 1;
					
					if(!idCarreteString.equalsIgnoreCase("") && !idString.equalsIgnoreCase("") && !typeString.equalsIgnoreCase("") && !skinString.equalsIgnoreCase(""))
					{
						p_carreteId = Integer.parseInt(idCarreteString);
						p_id = Integer.parseInt(idString);
						p_type = Integer.parseInt(typeString);
						p_skin = Integer.parseInt(skinString);
					}
				
					Pagina_ambiental_carrete carrete = new Pagina_ambiental_carrete(p_carreteId);
					Pagina_ambiental_carrete_seccion carrete_aux = new Pagina_ambiental_carrete_seccion(p_id);
					System.out.println("1. " + p_carreteId + "2. " + p_id + "3. " + texto + "4. " + image_fileName);
			        boolean carrete_result = carrete_aux.modificar(p_carreteId, p_id, titulo, image_fileName, enlace, css, true, p_skin, subtitulo, texto);
			        
			        JSONObject jsonResponse = new JSONObject();
			        if (carrete_result) {
			            jsonResponse.put("success", true);
			        } else {
			            jsonResponse.put("success", false);
			            jsonResponse.put("message", "There was an error modifing the carrete section.");
			        }

			        response.setContentType("application/json");
			        try (PrintWriter out = response.getWriter()) {
			            out.print(jsonResponse);
			        }
			       
			    } catch (NumberFormatException e) {
			    	// Handle invalid input (e.g., the selected value is not a valid integer)
			    	JSONObject jsonResponse = new JSONObject();
		            jsonResponse.put("success", false);
		            jsonResponse.put("message", "Invalid input.");
		            
		            response.setContentType("application/json");
			        try (PrintWriter out = response.getWriter()) {
			            out.print(jsonResponse);
			        }
			    }
			}
			else if(request.getParameter("carrete_seccion_btnadd") != null) 
			{	
				String idCarreteString = request.getParameter("carrete_seccion_carrete_id");
				String typeString = request.getParameter("carrete_seccion_lista_tipo");
				String codigo = request.getParameter("carrete_seccion_codigo");
				String titulo = request.getParameter("carrete_seccion_titulo");
				Part image = request.getPart("carrete_seccion_imagen");
				String enlace = request.getParameter("carrete_seccion_enlace");
				String css = request.getParameter("carrete_seccion_css");
				String skinString = request.getParameter("carrete_seccion_lista_tema");
				String subtitulo = request.getParameter("carrete_seccion_subtitulo");
				String texto = request.getParameter("carrete_seccion_texto");
				//System.out.println("1." + idCarreteString + " 2. " + typeString + " 3. " + codigo + " 4. " + titulo + " 5. " + image + " 6. " + enlace + " 7. " + css + " 8. " + skinString + " 9. " + subtitulo + " 10. " + texto);
				try {
					context_hd = components_web_controller.getProperty("ASSETS_CARRETE_IMAGE");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            String context_db = "assets" + File.separator + "Menu_Images";
	            String image_fileName = "";

	            if (image != null) {
	                for (String content : image.getHeader("content-disposition").split(";")) {
	                    if (content.trim().startsWith("filename")) {
	                        image_fileName = content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
	                        break;
	                    }
	                }
	            }

	            try {
	                if (!image_fileName.equalsIgnoreCase("")) {
	                    
	                    File directory = new File(context_hd);
	                    if (!directory.exists()) {
	                        directory.mkdirs();
	                    }

	                    String fullPath = context_hd + File.separator + image_fileName;
	                    image.write(fullPath); 
	                    image_fileName = context_db + File.separator + image_fileName;
	                }
					
					int p_carreteId = 0;
					int p_type = 0;
					int p_skin = 1;
				
					if(!idCarreteString.equalsIgnoreCase("") && !typeString.equalsIgnoreCase("") && !skinString.equalsIgnoreCase(""))
					{
						p_carreteId = Integer.parseInt(idCarreteString);
						p_type = Integer.parseInt(typeString);
						p_skin = Integer.parseInt(skinString);
					}
				
					Pagina_ambiental_carrete_seccion carrete_aux = new Pagina_ambiental_carrete_seccion();
					boolean carrete_result = false;
					//System.out.println("1." + p_carreteId + "2. " + codigo + "3. " + texto + "4. " + image_fileName);
					if(p_type == 1)
					{   
				        try {
				        	//System.out.println(" 1." + p_skin + " 2. " + titulo + " 3. " + subtitulo + " 4. " + texto + " 5." + enlace);
							Pagina_ambiental_carrete_tip new_tip = new Pagina_ambiental_carrete_tip(p_skin, titulo, subtitulo, texto, enlace);
							new_tip.generate_tip();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						//carrete_result = carrete_aux.agregar( p_carreteId, p_type, codigo, titulo, image_fileName, enlace, css, true, p_skin, subtitulo, texto);
					}
					else
					{
				        carrete_result = carrete_aux.agregar( p_carreteId, p_type, codigo, titulo, image_fileName, enlace, css, true, p_skin, subtitulo, texto);						
					}
					
			        JSONObject jsonResponse = new JSONObject();
			        if (carrete_result) {
			            jsonResponse.put("success", true);
			        } else {
			            jsonResponse.put("success", false);
			            jsonResponse.put("message", "There was an error adding the carrete section.");
			        }

			        response.setContentType("application/json");
			        try (PrintWriter out = response.getWriter()) {
			            out.print(jsonResponse);
			        }
			       
			    } catch (NumberFormatException e) {
			        // Handle invalid input (e.g., the selected value is not a valid integer)
			    	JSONObject jsonResponse = new JSONObject();
		            jsonResponse.put("success", false);
		            jsonResponse.put("message", "Invalid input.");
		            
		            response.setContentType("application/json");
			        try (PrintWriter out = response.getWriter()) {
			            out.print(jsonResponse);
			        }
			    } catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
	        }
			else if (request.getParameter("carrete_seccion_btndelete") != null) 
	        {
	        	
				String idString = request.getParameter("carrete_seccion_id");	
				
				int p_Id = 0;
			
				if(!idString.equalsIgnoreCase(""))
				{
					p_Id = Integer.parseInt(idString);
				}
				
				Pagina_ambiental_carrete_seccion carrete_aux = new Pagina_ambiental_carrete_seccion();
				//System.out.println("1." + p_id + "2. " + p_tipo + "3. " + titulo + "4. " + texto);
		        boolean seccion_result = carrete_aux.eliminar( p_Id );
		        
		        JSONObject jsonResponse = new JSONObject();
		        if (seccion_result) {
		            jsonResponse.put("success", true);
		        } else {
		            jsonResponse.put("success", false);
		            jsonResponse.put("message", "There was an error delete the carrete section.");
		        }

		        response.setContentType("application/json");
		        try (PrintWriter out = response.getWriter()) {
		            out.print(jsonResponse);
		        }
				
	        }
	        else
	        {
	        	request.getRequestDispatcher("cgp_admin_principal?command=showAll").forward(request, response);	
	        }
		}
		else if (action.equalsIgnoreCase("MenuActions"))
		{
			if(request.getParameter("menu_btnedit") != null)
			{
				String idPageString = request.getParameter("menu_pagina_id");
				String idString = request.getParameter("menu_id");
				String titulo = request.getParameter("menu_titulo");
				String css = request.getParameter("menu_css");
				String descripcion = request.getParameter("menu_descripcion");
				
	            try 
	            {
					
					int p_pageId = 0;
					int p_id = 0;
				
					if(!idPageString.equalsIgnoreCase("") && !idString.equalsIgnoreCase(""))
					{
						p_pageId = Integer.parseInt(idPageString);
						p_id = Integer.parseInt(idString);
					}
				
					Pagina_ambiental pagina_aux = new Pagina_ambiental(p_pageId);
					Pagina_ambiental_menu menu_aux = new Pagina_ambiental_menu(p_id);
					//System.out.println("1." + p_id + "2. " + p_tipo + "3. " + titulo + "4. " + texto);
			        boolean menu_result = menu_aux.modificar(p_id, titulo, css, true, descripcion);
			        
			        JSONObject jsonResponse = new JSONObject();
			        if (menu_result) {
			            jsonResponse.put("success", true);
			        } else {
			            jsonResponse.put("success", false);
			            jsonResponse.put("message", "There was an error modifing the section.");
			        }

			        response.setContentType("application/json");
			        try (PrintWriter out = response.getWriter()) {
			            out.print(jsonResponse);
			        }
			       
			    } catch (NumberFormatException e) {
			    	// Handle invalid input (e.g., the selected value is not a valid integer)
			    	JSONObject jsonResponse = new JSONObject();
		            jsonResponse.put("success", false);
		            jsonResponse.put("message", "Invalid input.");
		            
		            response.setContentType("application/json");
			        try (PrintWriter out = response.getWriter()) {
			            out.print(jsonResponse);
			        }
			    }
			}
			else if(request.getParameter("menu_btnadd") != null) 
			{	
				String idPageString = request.getParameter("menu_pagina_id");
				String codigo = request.getParameter("menu_codigo");
				String titulo = request.getParameter("menu_titulo");
				String css = request.getParameter("menu_css");
				String descripcion = request.getParameter("menu_descripcion");
				
				try {
				
					int p_pageId = 0;
				
					if(!idPageString.equalsIgnoreCase("") )
					{
						p_pageId = Integer.parseInt(idPageString);
					}
				
					Pagina_ambiental_menu menu_aux = new Pagina_ambiental_menu();
					//System.out.println("1." + p_id + "2. " + p_tipo + "3. " + titulo + "4. " + texto);
			        boolean menu_result = menu_aux.agregar( p_pageId, codigo, titulo, css, true, descripcion);
			        
			        JSONObject jsonResponse = new JSONObject();
			        if (menu_result) {
			            jsonResponse.put("success", true);
			        } else {
			            jsonResponse.put("success", false);
			            jsonResponse.put("message", "There was an error adding the section.");
			        }

			        response.setContentType("application/json");
			        try (PrintWriter out = response.getWriter()) {
			            out.print(jsonResponse);
			        }
			       
			    } catch (NumberFormatException e) {
			        // Handle invalid input (e.g., the selected value is not a valid integer)
			    	JSONObject jsonResponse = new JSONObject();
		            jsonResponse.put("success", false);
		            jsonResponse.put("message", "Invalid input.");
		            
		            response.setContentType("application/json");
			        try (PrintWriter out = response.getWriter()) {
			            out.print(jsonResponse);
			        }
			    }
			}
            else if (request.getParameter("menu_btndelete") != null) 
	        {
	        	
				String idString = request.getParameter("menu_id");	
				
				int p_Id = 0;
			
				if(!idString.equalsIgnoreCase(""))
				{
					p_Id = Integer.parseInt(idString);
				}
				
				Pagina_ambiental_menu menu_aux = new Pagina_ambiental_menu();
				//System.out.println("1." + p_id + "2. " + p_tipo + "3. " + titulo + "4. " + texto);
		        boolean menu_result = menu_aux.eliminar( p_Id );
		        
		        JSONObject jsonResponse = new JSONObject();
		        if (menu_result) {
		            jsonResponse.put("success", true);
		        } else {
		            jsonResponse.put("success", false);
		            jsonResponse.put("message", "There was an error delete the section.");
		        }

		        response.setContentType("application/json");
		        try (PrintWriter out = response.getWriter()) {
		            out.print(jsonResponse);
		        }
				
	        }
	        else
	        {
	        	request.getRequestDispatcher("cgp_admin_principal?command=showAll").forward(request, response);	
	        }
		}
		else if(action.equalsIgnoreCase("menuSectionActions"))
		{
			if(request.getParameter("menu_seccion_btnedit") != null)
			{
				String idMenuString = request.getParameter("menu_seccion_menu_id");
				String idString = request.getParameter("menu_seccion_id");
				String texto = request.getParameter("menu_seccion_texto");
				Part image = request.getPart("menu_seccion_imagen");
				String enlace = request.getParameter("menu_seccion_enlace");
				String css = request.getParameter("menu_seccion_css");
				
				try {
					context_hd = components_web_controller.getProperty("ASSETS_MENU_IMAGE");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            String context_db = "assets" + File.separator + "Menu_Images";
	            String image_fileName = "";

	            if (image != null) {
	                for (String content : image.getHeader("content-disposition").split(";")) {
	                    if (content.trim().startsWith("filename")) {
	                        image_fileName = content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
	                        break;
	                    }
	                }
	            }

	            try {
	                if (!image_fileName.equalsIgnoreCase("")) {
	                    
	                    File directory = new File(context_hd);
	                    if (!directory.exists()) {
	                        directory.mkdirs();
	                    }

	                    String fullPath = context_hd + File.separator + image_fileName;
	                    image.write(fullPath); 
	                    image_fileName = context_db + File.separator + image_fileName;
	                }
					
					int p_menuId = 0;
					int p_id = 0;
					
					if(!idMenuString.equalsIgnoreCase("") && !idString.equalsIgnoreCase(""))
					{
						p_menuId = Integer.parseInt(idMenuString);
						p_id = Integer.parseInt(idString);
					}
				
					Pagina_ambiental_menu menu_aux = new Pagina_ambiental_menu(p_menuId);
					Pagina_ambiental_menu_seccion seccion_aux = new Pagina_ambiental_menu_seccion(p_id);
					//System.out.println("1." + p_id + "2. " + p_tipo + "3. " + titulo + "4. " + texto);
			        boolean seccion_result = seccion_aux.modificar(p_menuId, p_id, texto, image_fileName, enlace, css, true);
			        
			        JSONObject jsonResponse = new JSONObject();
			        if (seccion_result) {
			            jsonResponse.put("success", true);
			        } else {
			            jsonResponse.put("success", false);
			            jsonResponse.put("message", "There was an error modifing the section.");
			        }

			        response.setContentType("application/json");
			        try (PrintWriter out = response.getWriter()) {
			            out.print(jsonResponse);
			        }
			       
			    } catch (NumberFormatException e) {
			    	// Handle invalid input (e.g., the selected value is not a valid integer)
			    	JSONObject jsonResponse = new JSONObject();
		            jsonResponse.put("success", false);
		            jsonResponse.put("message", "Invalid input.");
		            
		            response.setContentType("application/json");
			        try (PrintWriter out = response.getWriter()) {
			            out.print(jsonResponse);
			        }
			    }
			}
			else if(request.getParameter("menu_seccion_btnadd") != null) 
			{	
				String idMenuString = request.getParameter("menu_seccion_menu_id");
				String codigo = request.getParameter("menu_seccion_codigo");
				String texto = request.getParameter("menu_seccion_texto");
				Part image = request.getPart("menu_seccion_imagen");
				String enlace = request.getParameter("menu_seccion_enlace");
				String css = request.getParameter("menu_seccion_css");
				
				try {
					context_hd = components_web_controller.getProperty("ASSETS_MENU_IMAGE");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            String context_db = "assets" + File.separator + "Menu_Images";
	            String image_fileName = "";

	            if (image != null) {
	                for (String content : image.getHeader("content-disposition").split(";")) {
	                    if (content.trim().startsWith("filename")) {
	                        image_fileName = content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
	                        break;
	                    }
	                }
	            }

	            try {
	                if (!image_fileName.equalsIgnoreCase("")) {
	                    
	                    File directory = new File(context_hd);
	                    if (!directory.exists()) {
	                        directory.mkdirs();
	                    }

	                    String fullPath = context_hd + File.separator + image_fileName;
	                    image.write(fullPath); 
	                    image_fileName = context_db + File.separator + image_fileName;
	                }
					
					int p_menuId = 0;
				
					if(!idMenuString.equalsIgnoreCase("") )
					{
						p_menuId = Integer.parseInt(idMenuString);
					}
				
					Pagina_ambiental_menu_seccion seccion_aux = new Pagina_ambiental_menu_seccion();
					//System.out.println("1." + p_id + "2. " + p_tipo + "3. " + titulo + "4. " + texto);
			        boolean seccion_result = seccion_aux.agregar( p_menuId, codigo,texto, image_fileName, enlace, css, true);
			        
			        JSONObject jsonResponse = new JSONObject();
			        if (seccion_result) {
			            jsonResponse.put("success", true);
			        } else {
			            jsonResponse.put("success", false);
			            jsonResponse.put("message", "There was an error adding the section.");
			        }

			        response.setContentType("application/json");
			        try (PrintWriter out = response.getWriter()) {
			            out.print(jsonResponse);
			        }
			       
			    } catch (NumberFormatException e) {
			        // Handle invalid input (e.g., the selected value is not a valid integer)
			    	JSONObject jsonResponse = new JSONObject();
		            jsonResponse.put("success", false);
		            jsonResponse.put("message", "Invalid input.");
		            
		            response.setContentType("application/json");
			        try (PrintWriter out = response.getWriter()) {
			            out.print(jsonResponse);
			        }
			    }		
	        } 
			else if (request.getParameter("menu_seccion_btndelete") != null) 
	        {
	        	
				String idString = request.getParameter("menu_seccion_id");	
				
				int p_Id = 0;
			
				if(!idString.equalsIgnoreCase(""))
				{
					p_Id = Integer.parseInt(idString);
				}
				
				Pagina_ambiental_menu_seccion seccion_aux = new Pagina_ambiental_menu_seccion();
				//System.out.println("1." + p_id + "2. " + p_tipo + "3. " + titulo + "4. " + texto);
		        boolean seccion_result = seccion_aux.eliminar( p_Id );
		        
		        JSONObject jsonResponse = new JSONObject();
		        if (seccion_result) {
		            jsonResponse.put("success", true);
		        } else {
		            jsonResponse.put("success", false);
		            jsonResponse.put("message", "There was an error delete the section.");
		        }

		        response.setContentType("application/json");
		        try (PrintWriter out = response.getWriter()) {
		            out.print(jsonResponse);
		        }
				
	        }
	        else
	        {
	        	request.getRequestDispatcher("cgp_admin_principal?command=showAll").forward(request, response);	
	        }
		}
		else
		{
			response.getWriter().append("Served at: " + action + " ").append(request.getContextPath());
		}
	}

}

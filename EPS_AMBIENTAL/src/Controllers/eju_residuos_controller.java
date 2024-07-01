package Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Pagina_ambiental;

/**
 * Servlet implementation class eju_residuos_controller
 */
@WebServlet("/eju_residuos_controller")
public class eju_residuos_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public eju_residuos_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Pagina_ambiental contenido = new Pagina_ambiental(15);
		
		if(contenido.getVisible() == 1)
		{
			try
			{
				request.setAttribute("menu_logo", components_web_controller.getInstance().menu_logo);
				request.setAttribute("lista_menu", contenido.getLista_titulos());
				request.setAttribute("tittle", contenido.getNombre());
				request.setAttribute("header_image", contenido.getPath_header_image());
				request.setAttribute("secciones", contenido.getLista_secciones());
				request.setAttribute("carretes", contenido.getLista_carrete());
				request.setAttribute("footer_logo1", components_web_controller.getInstance().footer_logo1);
			    request.setAttribute("footer_logo2", components_web_controller.getInstance().footer_logo2);
			    request.setAttribute("footer_logo3", components_web_controller.getInstance().footer_logo3);
			    
			    request.getRequestDispatcher("eju-residuos.jsp").forward(request, response);
			}
			catch(Exception e)
			{
				System.out.println("Exception eju_residuos_controller - doGet:" + e.getMessage());
			}
		}
		else
		{
			request.getRequestDispatcher("inc.jsp").forward(request, response);
			System.out.println("Served at: " + request);
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

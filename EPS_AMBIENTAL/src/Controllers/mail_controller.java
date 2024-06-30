package Controllers;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Session;

import Models.Pagina_ambiental;

/**
 * Servlet implementation class mail_controller
 */
@WebServlet("/mail_controller")
public class mail_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mail_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
			Pagina_ambiental contenido = new Pagina_ambiental(12);
			request.setAttribute("menu_logo", components_web_controller.getInstance().menu_logo);
			request.setAttribute("lista_menu", contenido.getLista_titulos());
			request.setAttribute("footer_logo1", components_web_controller.getInstance().footer_logo1);
		    request.setAttribute("footer_logo2", components_web_controller.getInstance().footer_logo2);
		    request.setAttribute("footer_logo3", components_web_controller.getInstance().footer_logo3);
		}
		catch(Exception e)
		{
			System.out.println("Exception mail_controller - doGet:" + e.getMessage());
		}
	    
	    request.getRequestDispatcher("contact.jsp").forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("command");
		
		if (action.equalsIgnoreCase("send"))
		{	
			String name = request.getParameter("name_to");
			String email = request.getParameter("email_to");
			String subject = request.getParameter("select_subject");
			String message = request.getParameter("message_email");
			
			try
			{
				mail_cgp mail = new mail_cgp();
				mail.send_message(name, email, subject, message);
				request.getRequestDispatcher("contact.jsp").forward(request, response);
			}
			catch(Exception e)
			{
				System.out.println("Exception mail_controller - doPost:" + e.getMessage());
			}
			
		}
		else
		{
			response.getWriter().append("Served at: " + action + " ").append(request.getContextPath());
		}
		
	}

}

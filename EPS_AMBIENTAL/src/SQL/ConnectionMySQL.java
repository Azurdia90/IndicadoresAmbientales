package SQL;

import java.sql.Connection;
import java.sql.DriverManager;

import Controllers.components_web_controller;

public class ConnectionMySQL {

	
	private String port;
	private String bd;
	private String url;
	private String user;
	private String pass;

	private Connection conn = null;
	
	public ConnectionMySQL() throws Exception
	{
		try
		{	
			port = components_web_controller.getInstance().port;
			bd   = components_web_controller.getInstance().bd;
			user = components_web_controller.getInstance().user;
			pass = components_web_controller.getInstance().pass;
			url  = components_web_controller.getInstance().url 
					  + port + "/" 
		              +  bd + "?noAccessToProcedureBodies=true";
			
			//System.out.println("Vamos a empezar: " + url );
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = (Connection) DriverManager.getConnection(url, user, pass);
			
			if(conn == null)
			{
				System.out.println("Error conexion: Servidor no encontrado");
			}
		}
		catch(Throwable e)
		{
			System.out.println("Error SQL:" + e.getMessage());
		}
		
	}
	
	public Connection getConn() {
		return conn;
	}


	public void setConn(Connection conn) {
		this.conn = conn;
	}
	

}

package SQL;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionMySQL {

	private String port = "3306";
	private String bd = "sigusac-ambiental";
	private String url = "jdbc:mysql://localhost:" + port +
			              "/" +  bd + "?noAccessToProcedureBodies=true";
	private String user = "root";
	private String pass = "admin";
	//jdbc:mysql://localhost:3306/sigusac-ambiental?user=root
	private Connection conn = null;
	
	public ConnectionMySQL()
	{
		try
		{	//System.out.println("Vamos a empezar:" + url);
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = (Connection) DriverManager.getConnection(url, user, pass);
			
			if(conn == null)
			{
				//System.out.println("Conexión exitosa");
			//}
			//else
			//{
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

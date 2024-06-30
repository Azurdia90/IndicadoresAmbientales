package Controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Properties;

import Models.Pagina_ambiental;
import SQL.ConnectionMySQL;

public class components_web_controller {
	
	private static components_web_controller singleton;
	//variable para el manejo de variables de entorono
	private FileInputStream input;
	private static Properties properties;
	
	//Componentes del menú principal
	private String envMenu;
    public String menu_logo;
	
    //Componentes del footer
    private String envFooter;
    public String footer_logo1;
    public String footer_logo2;
    public String footer_logo3;
    
    public String port;
	public String bd;
	public String url;
	public String user;
	public String pass;
	
	private components_web_controller() throws Exception
	{
		properties = new Properties();
		String file_name = getEnvFilePath();
		input = new FileInputStream(file_name);
		properties.load(input);
		
		//configuración para base de datos
		this.port = properties.getProperty("DB_PORT");
		this.bd   = properties.getProperty("DB_DB");
		this.user = properties.getProperty("DB_USERNAME");
		this.pass = properties.getProperty("DB_PASSWORD");
		this.url  = properties.getProperty("DB_URL");
		
		//menu de la pagina
		this.envMenu = properties.getProperty("ASSETS_MENU");
		this.menu_logo = envMenu + properties.getProperty("ASSETS_MENU_LOGO");
		//System.out.println(menu_logo);
		
		//footer de la pagina
		this.envFooter = properties.getProperty("ASSETS_FOOTER");
		this.footer_logo1 = envFooter + properties.getProperty("ASSETS_FOOTER_LOGO1");
		this.footer_logo2 = envFooter + properties.getProperty("ASSETS_FOOTER_LOGO2");
		this.footer_logo3 = envFooter + properties.getProperty("ASSETS_FOOTER_LOGO3");
		//System.out.println(footer_logo3);
		
		input.close();
	
	}
	
	public static components_web_controller getInstance() throws Exception
	{
		if(singleton != null){
			return singleton;
		}
		else
		{
			singleton = new components_web_controller();
			return singleton;
		}
	}
	
	public static String getProperty(String p_variable) throws Exception
	{
		String value = "";
		if(singleton != null){
			value = properties.getProperty(p_variable); 
			return value;
		}
		else{
			singleton = new components_web_controller();
			value = properties.getProperty(p_variable); 
			return value;
		}
	}
	
	private static String getEnvFilePath() {
        String osName = System.getProperty("os.name").toLowerCase();
        String envFilePath;
        
        if (osName.contains("win")) {
            // Ruta específica para Windows
            envFilePath = "C:\\Users\\EPS\\Documents\\eps_ambiental\\EPS_AMBIENTAL\\.env";
        } else if (osName.contains("nix") || osName.contains("nux") || osName.contains("mac")) {
            // Ruta específica para Unix/Linux/Mac
            envFilePath = "/home/.env";
        } else {
            // Ruta por defecto o lanzar una excepción si el sistema operativo no es soportado
            envFilePath = ".env";
        }
        
        return envFilePath;
    }
}

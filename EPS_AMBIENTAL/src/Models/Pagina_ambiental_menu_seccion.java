package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import SQL.ConnectionMySQL;

public class Pagina_ambiental_menu_seccion {
	
	private int id;
	private int menu_id;
	private String codigo;
	private String path_image;
	private String texto;
	private String enlace;
	private String clase_css;
	private int visible;
	
	private ConnectionMySQL conmysql;
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public Pagina_ambiental_menu_seccion()
	{
		this.id = 0;
		this.menu_id = 0;
		this.codigo = "";
		this.texto = "";
		this.path_image = "";
		this.enlace = "";
		this.clase_css = "";
		this.visible = 0;
	}
	
	public Pagina_ambiental_menu_seccion(int p_id)
	{
		Pagina_ambiental_menu_seccion aux = this.buscar(p_id);
		
		this.id = aux.getId();
		this.menu_id = aux.getMenu_id();
		this.codigo = aux.getCodigo();
		this.texto = aux.getTexto();
		this.path_image = aux.getPath_image();
		this.enlace = aux.getEnlace();
		this.clase_css = aux.getClase_css();
		this.visible = aux.getVisible();
	}
	
	public Pagina_ambiental_menu_seccion(int p_id, int p_menu_id, String p_codigo, String p_path_image, String p_texto, String p_enlace, String p_clase_css, int p_visible)
	{
		this.id = p_id;
		this.menu_id = p_menu_id;
		this.codigo = p_codigo;
		this.path_image = p_path_image;
		this.texto = p_texto;
		this.enlace = p_enlace;
		this.clase_css = p_clase_css;
		this.visible = p_visible;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getPath_image() {
		return path_image;
	}

	public void setPath_image(String path_image) {
		this.path_image = path_image;
	}

	public String getEnlace() {
		return enlace;
	}

	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}

	public String getClase_css() {
		return clase_css;
	}

	public void setClase_css(String clase_css) {
		this.clase_css = clase_css;
	}

	public int getVisible() {
		return visible;
	}

	public void setVisible(int visible) {
		this.visible = visible;
	}
	
	public Pagina_ambiental_menu_seccion buscar(int p_id)
	{
		Pagina_ambiental_menu_seccion pagina_ambiental_menu_seccion = null;
		String sql_select = "select id, menu_id, codigo, path_image, texto, enlace, clase_css, visible from pagina_ambiental_menu_seccion where id = ? order by codigo ";
		
		try
		{   
			conmysql = new ConnectionMySQL();
			conn = conmysql.getConn();
			ps = conn.prepareStatement(sql_select);
			ps.setInt(1,p_id);
			rs = ps.executeQuery();
			rs.beforeFirst();
			while (rs.next())
			{
				int aux_id = rs.getInt(1);
				int aux_menu_id = rs.getInt(2);
				String aux_codigo = rs.getString(3);
				String aux_path_image = rs.getString(4);
				String aux_texto = rs.getString(5);
				String aux_enlace = rs.getString(6);
				String aux_clase_css = rs.getString(7);
				int aux_visible = rs.getInt(8);
				
				pagina_ambiental_menu_seccion = new Pagina_ambiental_menu_seccion(aux_id, aux_menu_id, aux_codigo, aux_path_image, aux_texto, aux_enlace, aux_clase_css, aux_visible);

			}
			//System.out.println("Pagina_ambiental_seccion buscar(int p_id)=:" + this.lista_secciones.size());
			rs.close();
			conn.close();
			
			return pagina_ambiental_menu_seccion;
		}
		catch(Exception e)
		{
			System.out.println("Pagina_ambiental_menu_seccion buscar(int p_id):" + e.getMessage());
			return pagina_ambiental_menu_seccion;
		}
	}
	
	public ArrayList<Pagina_ambiental_menu_seccion> listar(int p_id)
	{
		ArrayList<Pagina_ambiental_menu_seccion> lista_pagina_ambiental_menu_seccion = new ArrayList<>();
		String sql_select = "select id, menu_id, codigo, path_image, texto, enlace, clase_css, visible from pagina_ambiental_menu_seccion where menu_id = ? order by codigo ";
		
		try
		{   
			conmysql = new ConnectionMySQL();
			conn = conmysql.getConn();
			ps = conn.prepareStatement(sql_select);
			ps.setInt(1,p_id);
			rs = ps.executeQuery();
			rs.beforeFirst();
			while (rs.next())
			{
				int aux_id = rs.getInt(1);
				int aux_menu_id = rs.getInt(2);
				String aux_codigo = rs.getString(3);
				String aux_path_image = rs.getString(4);
				String aux_texto = rs.getString(5);
				String aux_enlace = rs.getString(6);
				String aux_clase_css = rs.getString(7);
				int aux_visible = rs.getInt(8);
				
				Pagina_ambiental_menu_seccion aux_pagina_ambiental_menu_seccion = new Pagina_ambiental_menu_seccion(aux_id, aux_menu_id, aux_codigo, aux_path_image, aux_texto, aux_enlace, aux_clase_css, aux_visible);
				lista_pagina_ambiental_menu_seccion.add(aux_pagina_ambiental_menu_seccion);
			}
			//System.out.println("ArrayList<Pagina_ambiental_menu_seccion> listar(int p_id)=:" + this.lista_secciones.size());
			rs.close();
			conn.close();
			
			return lista_pagina_ambiental_menu_seccion;
		}
		catch(Exception e)
		{
			System.out.println("ArrayList<Pagina_ambiental_menu_seccion> listar:" + e.getMessage());
			return lista_pagina_ambiental_menu_seccion;
		}
	}
	
	public boolean modificar(int p_menuid, int p_id, String p_texto, String p_path_image, String p_enlace, String p_css, boolean p_visible)
	{ 	
		Pagina_ambiental_menu_seccion pagina_ambiental_seccion = null;
		String sql_update = " update pagina_ambiental_menu_seccion set texto = ?, enlace = ?, clase_css = ?, visible = ? ";
		sql_update = sql_update.concat( !p_path_image.equalsIgnoreCase("") ? ", path_image = ?" : "" );
		sql_update = sql_update.concat(	" where id = ?");
		
		try
		{   
			conmysql = new ConnectionMySQL();
			conn = conmysql.getConn();
			ps = conn.prepareStatement(sql_update);
			ps.setString(1,p_texto);
			ps.setString(2,p_enlace);
			ps.setString(3,p_css);
			ps.setBoolean(4,p_visible);
			if( !p_path_image.equalsIgnoreCase(""))
			{
				ps.setString(5,p_path_image);
				ps.setInt(6,p_id);
			}
			else
			{
				ps.setInt(5,p_id);
			}
			
			int result_update = ps.executeUpdate();
			
			ps.close();
			conn.close();
			
			return true;
		}
		catch(Exception e)
		{
			System.out.println("boolean modificar(int p_menuid, int p_id, String p_texto, String p_path_image, String p_enlace, String p_css, boolean p_visible):" + e.getMessage());
			return false;
		}
	}
	
	public boolean agregar(int p_menu_id, String p_codigo, String p_texto, String p_path_image, String p_enlace, String p_css, boolean p_visible)
	{ 	
		Pagina_ambiental_menu_seccion pagina_ambiental_seccion = null;
		String sql_insert = " insert into pagina_ambiental_menu_seccion ( menu_id, codigo, texto, enlace, clase_css, visible";
		sql_insert = sql_insert.concat( !p_path_image.equalsIgnoreCase("") ? ", path_image)" : ")" );
		sql_insert = sql_insert.concat(	" values( ?, ?, ?, ?, ?, ?" + (!p_path_image.equalsIgnoreCase("") ? ", ?" : "")  + ")" );
		
		try
		{   
			conmysql = new ConnectionMySQL();
			conn = conmysql.getConn();
			
			ps = conn.prepareStatement(sql_insert);
			ps.setInt(1,p_menu_id);
			ps.setString(2,p_codigo);
			ps.setString(3,p_texto);
			ps.setString(4,p_enlace);
			ps.setString(5,p_css);
			ps.setBoolean(6,p_visible);
			if(!p_path_image.equalsIgnoreCase(""))
			{
				ps.setString(7,p_path_image);
				
				
			}

			int result_update = ps.executeUpdate();
			
			ps.close();
			conn.close();
			
			return true;
		}
		catch(Exception e)
		{
			System.out.println("boolean agregar(int p_menu_id, String p_codigo, String p_texto, String p_path_image, String p_enlace, String p_css, boolean p_visible):" + e.getMessage());
			return false;
		}
	}
	
	public boolean eliminar(int p_id)
	{
		Pagina_ambiental_seccion seccion_aux = null;
		String sql_delete = " delete from pagina_ambiental_menu_seccion"
						  + " where id = ?";
		
		try
		{   
			conmysql = new ConnectionMySQL();
			conn = conmysql.getConn();
			
			ps = conn.prepareStatement(sql_delete);
			ps.setInt(1,p_id);
			
			int result_update = ps.executeUpdate();
			
			ps.close();
			conn.close();
			
			return true;
		}
		catch(Exception e)
		{
			System.out.println("public boolean eliminar(int p_id):" + e.getMessage());
			return false;
		}
	}

}

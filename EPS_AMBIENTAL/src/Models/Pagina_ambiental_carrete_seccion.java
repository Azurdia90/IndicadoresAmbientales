package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import SQL.ConnectionMySQL;

public class Pagina_ambiental_carrete_seccion {
	
	private int id;
	private int carrete_id;
	private int carrete_type;
	private String codigo;
	private String tittle;
	private String path_image;
	private String enlace;
	private String clase_css;
	private int visible;
	private int skin;
	private String subtittle;
	private String text;
	
	private ConnectionMySQL conmysql;
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public Pagina_ambiental_carrete_seccion()
	{
		this.id = 0;
		this.carrete_id = 0;
		this.carrete_type = 0;
		this.codigo = "";
		this.tittle = "";
		this.path_image = "";
		this.enlace = "";
		this.clase_css = "";
		this.visible = 0;
		this.skin = 1;
		this.subtittle = "";
		this.text = "";
	}
	
	public Pagina_ambiental_carrete_seccion(int p_id)
	{
		Pagina_ambiental_carrete_seccion aux = this.buscar(p_id);
		
		this.id = aux.getId();
		this.carrete_id = aux.getCarrete_id();
		this.carrete_type = aux.getCarrete_type();
		this.codigo = aux.getCodigo();
		this.tittle = aux.getTitulo();
		this.path_image = aux.getPath_image();
		this.enlace = aux.getEnlace();
		this.clase_css = aux.getClase_css();
		this.visible = aux.getVisible();
		this.skin = aux.getSkin();
		this.subtittle = aux.getSubtittle();
		this.text = aux.getText();
	}
	
	public Pagina_ambiental_carrete_seccion(int p_id, int p_carrete_id, int p_carrete_type, String p_codigo, String p_path_image, String p_tittle, String p_enlace, String p_clase_css, int p_visible, int p_skin, String p_subtittle, String p_text)
	{
		this.id = p_id;
		this.carrete_id = p_carrete_id;
		this.carrete_type = p_carrete_type;
		this.codigo = p_codigo;
		this.path_image = p_path_image;
		this.tittle = p_tittle;
		this.enlace = p_enlace;
		this.clase_css = p_clase_css;
		this.visible = p_visible;
		this.skin = p_skin;
		this.subtittle = p_subtittle;
		this.text = p_text;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCarrete_id() {
		return carrete_id;
	}

	public void setCarrete_id(int carrete_id) {
		this.carrete_id = carrete_id;
	}

	public int getCarrete_type() {
		return carrete_type;
	}

	public void setCarrete_type(int carrete_type) {
		this.carrete_type = carrete_type;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return tittle;
	}

	public void setTitulo(String tittle) {
		this.tittle = tittle;
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
	
	public int getSkin() {
		return skin;
	}

	public void setSkin(int skin) {
		this.skin = skin;
	}

	public String getSubtittle() {
		return subtittle;
	}

	public void setSubtittle(String subtittle) {
		this.subtittle = subtittle;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Pagina_ambiental_carrete_seccion buscar(int p_id)
	{
		Pagina_ambiental_carrete_seccion pagina_ambiental_carrete_seccion = null;
		String sql_select = "select id, carrete_id, carrete_type, codigo, path_image, tittle, enlace, clase_css, visible, skin, subtittle, text from pagina_ambiental_carrete_seccion where id = ? order by codigo ";
		
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
				int aux_carrete_id = rs.getInt(2);
				int aux_carrete_type = rs.getInt(3);
				String aux_codigo = rs.getString(4);
				String aux_path_image = rs.getString(5);
				String aux_tittle = rs.getString(6);
				String aux_enlace = rs.getString(7);
				String aux_clase_css = rs.getString(8);
				int aux_visible = rs.getInt(9);
				int aux_skin = rs.getInt(10);
				String aux_subtittle = rs.getString(11);
				String aux_text = rs.getString(12);
				
				pagina_ambiental_carrete_seccion = new Pagina_ambiental_carrete_seccion(aux_id, aux_carrete_id, aux_carrete_type, aux_codigo, aux_path_image, aux_tittle, aux_enlace, aux_clase_css, aux_visible, aux_skin, aux_subtittle, aux_text);

			}
			//System.out.println("Pagina_ambiental_carrete_photo buscar(int p_id)=:" + this.lista_secciones.size());
			rs.close();
			
			
			return pagina_ambiental_carrete_seccion;
		}
		catch(Exception e)
		{
			System.out.println("Pagina_ambiental_carrete_photo buscar(int p_id):" + e.getMessage());
			return pagina_ambiental_carrete_seccion;
		}
	}
	
	public ArrayList<Pagina_ambiental_carrete_seccion> listar(int p_id)
	{
		ArrayList<Pagina_ambiental_carrete_seccion> lista_pagina_ambiental_carrete_seccion = new ArrayList<>();
		String sql_select = "select id, carrete_id, carrete_type, codigo, path_image, tittle, enlace, clase_css, visible, skin, subtittle, text from pagina_ambiental_carrete_seccion where carrete_id = ? order by codigo ";
		
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
				int aux_carrete_id = rs.getInt(2);
				int aux_carrete_type = rs.getInt(3);
				String aux_codigo = rs.getString(4);
				String aux_path_image = rs.getString(5);
				String aux_tittle = rs.getString(6);
				String aux_enlace = rs.getString(7);
				String aux_clase_css = rs.getString(8);
				int aux_visible = rs.getInt(9);
				int aux_skin = rs.getInt(10);
				String aux_subtittle = rs.getString(11);
				String aux_text = rs.getString(12);
				
				Pagina_ambiental_carrete_seccion aux_pagina_ambiental_carrete_seccion = new Pagina_ambiental_carrete_seccion(aux_id, aux_carrete_id, aux_carrete_type, aux_codigo, aux_path_image, aux_tittle, aux_enlace, aux_clase_css, aux_visible, aux_skin, aux_subtittle, aux_text);
				lista_pagina_ambiental_carrete_seccion.add(aux_pagina_ambiental_carrete_seccion);
			}
			//System.out.println("ArrayList<Pagina_ambiental_carrete_photo> listar(int p_id)=:" + this.lista_secciones.size());
			rs.close();
			
			return lista_pagina_ambiental_carrete_seccion;
		}
		catch(Exception e)
		{
			System.out.println("ArrayList<Pagina_ambiental_menu_seccion> listar:" + e.getMessage());
			return lista_pagina_ambiental_carrete_seccion;
		}
	}
	
	public boolean modificar(int p_menuid, int p_id, String p_tittle, String p_path_image, String p_enlace, String p_css, boolean p_visible, int p_skin, String p_subtittle, String p_text)
	{ 	
		Pagina_ambiental_carrete_seccion pagina_ambiental_seccion = null;
		String sql_update = " update pagina_ambiental_carrete_seccion set tittle = ?, enlace = ?, clase_css = ?, visible = ?, skin = ?, subtittle = ?, text = ?  ";
		sql_update = sql_update.concat( !p_path_image.equalsIgnoreCase("") ? ", path_image = ?" : "" );
		sql_update = sql_update.concat(	" where id = ?");
		
		try
		{   
			conmysql = new ConnectionMySQL();
			conn = conmysql.getConn();
			ps = conn.prepareStatement(sql_update);
			ps.setString(1,p_tittle);
			ps.setString(2,p_enlace);
			ps.setString(3,p_css);
			ps.setBoolean(4,p_visible);
			ps.setInt(5,p_skin);
			ps.setString(6,p_subtittle);
			ps.setString(7, p_text);
			if( !p_path_image.equalsIgnoreCase(""))
			{
				ps.setString(8,p_path_image);
				ps.setInt(9,p_id);
			}
			else
			{
				ps.setInt(8,p_id);
			}
			
			int result_update = ps.executeUpdate();
			
			ps.close();
			conn.close();
			
			return true;
		}
		catch(Exception e)
		{
			System.out.println("boolean modificar(int p_menuid, int p_id,  String p_tittle, String p_path_image, String p_enlace, String p_css, boolean p_visible, String p_subtittle, String p_text):" + e.getMessage());
			return false;
		}
	}
	
	public boolean agregar(int p_menu_id, int p_carrete_type, String p_codigo, String p_tittle, String p_path_image, String p_enlace, String p_css, boolean p_visible, int p_skin, String p_subtittle, String p_text)
	{ 	
		Pagina_ambiental_carrete_seccion pagina_ambiental_seccion = null;
		String sql_insert = " insert into pagina_ambiental_carrete_seccion ( carrete_id, carrete_type, codigo, tittle, enlace, clase_css, visible, skin, subtittle, text";
		sql_insert = sql_insert.concat( !p_path_image.equalsIgnoreCase("") ? ", path_image)" : ")" );
		sql_insert = sql_insert.concat(	" values( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?" + (!p_path_image.equalsIgnoreCase("") ? ", ?" : "")  + ")" );
		
		try
		{   
			conmysql = new ConnectionMySQL();
			conn = conmysql.getConn();
			
			ps = conn.prepareStatement(sql_insert);
			ps.setInt(1,p_menu_id);
			ps.setInt(2,p_carrete_type);
			ps.setString(3,p_codigo);
			ps.setString(4,p_tittle);
			ps.setString(5,p_enlace);
			ps.setString(6,p_css);
			ps.setBoolean(7,p_visible);
			ps.setInt(8,p_skin);
			ps.setString(9,p_subtittle);
			ps.setString(10,p_text);
			if(!p_path_image.equalsIgnoreCase(""))
			{
				ps.setString(11,p_path_image);
			}

			int result_update = ps.executeUpdate();
			
			ps.close();
			conn.close();
			
			return true;
		}
		catch(Exception e)
		{
			System.out.println("boolean agregar(int p_menu_id, int p_carrete_type, String p_codigo, String p_tittle, String p_path_image, String p_enlace, String p_css, boolean p_visible, String p_subtittle, String p_text):" + e.getMessage());
			return false;
		}
	}
	
	public boolean eliminar(int p_id)
	{
		Pagina_ambiental_carrete_seccion seccion_aux = null;
		String sql_delete = " delete from pagina_ambiental_carrete_seccion"
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

package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import SQL.ConnectionMySQL;

public class Pagina_ambiental_seccion {
	
	private int id;
	private int id_pagina_ambiental;
	private int tipo;
	private String codigo;
	private String titulo;
	private String texto;
	private String path_image;
	private String enlace;
	private String clase_css;
	private int visible;
	private String descripcion;
	
	private ConnectionMySQL conmysql;
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public int getId_pagina_ambiental() {
		return id_pagina_ambiental;
	}

	public void setId_pagina_ambiental(int id_pagina_ambiental) {
		this.id_pagina_ambiental = id_pagina_ambiental;
	}
	
	public int getTipo() {
		return tipo;
	}


	public void setTipo(int tipo) {
		this.tipo = id;
	}
	
	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
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


	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Pagina_ambiental_seccion()
	{
		this.id = 0;
		this.id_pagina_ambiental = 0;
		this.tipo = 1;
		this.codigo = "";
		this.titulo = "";
		this.texto = "";
		this.path_image = "";
		this.enlace = "" ;
		this.clase_css = "";
		this.visible = 0;
		this.descripcion = "";
	}
	
	public Pagina_ambiental_seccion(int p_id)
	{
		Pagina_ambiental_seccion aux = this.buscar(p_id);
		
		this.id = aux.id;
		this.id_pagina_ambiental = aux.id_pagina_ambiental;
		this.tipo = aux.tipo;
		this.codigo = aux.codigo;
		this.titulo = aux.titulo;
		this.texto = aux.texto;
		this.path_image = aux.path_image;
		this.enlace = aux.enlace;
		this.clase_css = aux.clase_css;
		this.visible = aux.visible;
		this.descripcion = aux.descripcion;
	}
	
	public Pagina_ambiental_seccion(int p_id, int p_id_pagina_ambiental, int tipo, String p_codigo, String p_titulo, String p_texto, String p_path_image, String p_enlace, String p_clase_css, int p_visible, String p_descripcion)
	{
		this.id = p_id;
		this.id_pagina_ambiental = p_id_pagina_ambiental;
		this.tipo = tipo;
		this.codigo = p_codigo;
		this.titulo = p_titulo;
		this.texto = p_texto;
		this.path_image = p_path_image;
		this.enlace = p_enlace;
		this.clase_css = p_clase_css;
		this.visible = p_visible;
		this.descripcion = p_descripcion;
	}
	
	
	public Pagina_ambiental_seccion buscar(int p_id)
	{
		Pagina_ambiental_seccion pagina_ambiental_seccion = null;
		String sql_select = "select id, pagina_ambiental_id, tipo, codigo, titulo, texto, path_image, enlace, clase_css, visible, descripcion from pagina_ambiental_seccion where id = ? order by codigo ";
		
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
				int aux_id_pagina_ambiental = rs.getInt(2);
				int aux_tipo = rs.getInt(3);
				String aux_codigo = rs.getString(4);
				String aux_titulo = rs.getString(5);
				String aux_texto = rs.getString(6);
				String aux_path_image = rs.getString(7);
				String aux_enlace = rs.getString(8);
				String aux_clase_css = rs.getString(9);
				int aux_visible = rs.getInt(10);
				String aux_descripcion = rs.getString(11);
				
				pagina_ambiental_seccion = new Pagina_ambiental_seccion(aux_id, aux_id_pagina_ambiental, aux_tipo, aux_codigo, aux_titulo, aux_texto, aux_path_image, aux_enlace, aux_clase_css, aux_visible, aux_descripcion);
				
			}
			//System.out.println("Pagina_ambiental_seccion buscar(int p_id)=:" + this.lista_secciones.size());
			rs.close();
			
			return pagina_ambiental_seccion;
		}
		catch(Exception e)
		{
			System.out.println("Pagina_ambiental_seccion buscar(int p_id):" + e.getMessage());
			return pagina_ambiental_seccion;
		}
	}
	
	public ArrayList<Pagina_ambiental_seccion> listar(int p_id)
	{
		ArrayList<Pagina_ambiental_seccion> lista_pagina_ambiental_seccion = new ArrayList<>();
		String sql_select = "select id, pagina_ambiental_id, tipo, codigo, titulo, texto, path_image, enlace, clase_css, visible, descripcion from pagina_ambiental_seccion where pagina_ambiental_id = ? order by codigo ";
		
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
				int aux_pagina_ambiental_id = rs.getInt(2);
				int aux_tipo = rs.getInt(3);
				String aux_codigo = rs.getString(4);
				String aux_titulo = rs.getString(5);
				String aux_texto = rs.getString(6);
				String aux_path_image = rs.getString(7);
				String aux_enlace = rs.getString(8);
				String aux_clase_css = rs.getString(9);
				int aux_visible = rs.getInt(10);
				String aux_descripcion = rs.getString(11);
				
				Pagina_ambiental_seccion aux_pagina_ambiental_seccion = new Pagina_ambiental_seccion(aux_id, aux_pagina_ambiental_id, aux_tipo, aux_codigo, aux_titulo, aux_texto, aux_path_image, aux_enlace, aux_clase_css, aux_visible, aux_descripcion);
				lista_pagina_ambiental_seccion.add(aux_pagina_ambiental_seccion);
			}
			//System.out.println("ArrayList<Pagina_ambiental_seccion> listar(int p_id)=:" + this.lista_secciones.size());
			rs.close();
			conn.close();
			
			return lista_pagina_ambiental_seccion;
		}
		catch(Exception e)
		{
			System.out.println("ArrayList<Pagina_ambiental_seccion> listar:" + e.getMessage());
			return lista_pagina_ambiental_seccion;
		}
	}
	
	public boolean modificar(int p_id, int p_tipo, String p_titulo, String p_texto, String p_path_image, String p_enlace, String p_css, boolean p_visible, String p_descripcion)
	{ 	
		Pagina_ambiental_seccion pagina_ambiental_seccion = null;
		String sql_update = " update pagina_ambiental_seccion set tipo = ?, titulo = ?, texto = ?, enlace = ?, clase_css = ?, visible = ?, descripcion = ? ";
		sql_update = sql_update.concat( !p_path_image.equalsIgnoreCase("") ? ", path_image = ?" : "" );
		sql_update = sql_update.concat(	" where id = ?");
		
		try
		{   
			conmysql = new ConnectionMySQL();
			conn = conmysql.getConn();
			ps = conn.prepareStatement(sql_update);
			ps.setInt(1,p_tipo);
			ps.setString(2,p_titulo);
			ps.setString(3,p_texto);
			ps.setString(4,p_enlace);
			ps.setString(5,p_css);
			ps.setBoolean(6,p_visible);
			ps.setString(7,p_descripcion);
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
			System.out.println("boolean modificar(int p_id, String p_titulo, String p_texto, String p_path_image, String p_enlace, String p_css, boolean p_visible, String p_descripcion):" + e.getMessage());
			return false;
		}
	}
	
	public boolean agregar(int p_pagina_ambiental_id, String p_codigo, int p_tipo, String p_titulo, String p_texto, String p_path_image, String p_enlace, String p_css, boolean p_visible, String p_descripcion)
	{ 	
		Pagina_ambiental_seccion pagina_ambiental_seccion = null;
		String sql_insert = " insert into pagina_ambiental_seccion ( pagina_ambiental_id, codigo, tipo, titulo, texto, enlace, clase_css, visible, descripcion";
		sql_insert = sql_insert.concat( !p_path_image.equalsIgnoreCase("") ? ", path_image)" : ")" );
		sql_insert = sql_insert.concat(	" values( ?, ?, ?, ?, ?, ?, ?, ?, ? "  + (!p_path_image.equalsIgnoreCase("") ? ", ?)" : ")") );
		
		try
		{   
			conmysql = new ConnectionMySQL();
			conn = conmysql.getConn();
			
			ps = conn.prepareStatement(sql_insert);
			ps.setInt(1,p_pagina_ambiental_id);
			ps.setString(2,p_codigo);
			ps.setInt(3,p_tipo);
			ps.setString(4,p_titulo);
			ps.setString(5,p_texto);
			ps.setString(6,p_enlace);
			ps.setString(7,p_css);
			ps.setBoolean(8,p_visible);
			ps.setString(9,p_descripcion);
			if(!p_path_image.equalsIgnoreCase(""))
			{
				ps.setString(10,p_path_image);
			}

			
			int result_update = ps.executeUpdate();
			
			ps.close();
			conn.close();
			
			return true;
		}
		catch(Exception e)
		{
			System.out.println("boolean modificar(int p_id, String p_titulo, String p_texto, String p_path_image, String p_enlace, String p_css, boolean p_visible, String p_descripcion):" + e.getMessage());
			return false;
		}
	}
	
	public boolean eliminar(int p_id)
	{
		Pagina_ambiental_seccion seccion_aux = null;
		String sql_delete = " delete from pagina_ambiental_seccion"
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

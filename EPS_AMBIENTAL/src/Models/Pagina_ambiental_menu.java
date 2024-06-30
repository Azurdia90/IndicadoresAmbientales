package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import SQL.ConnectionMySQL;

public class Pagina_ambiental_menu {
	
	private int id;
	private int id_pagina_ambiental;
	private String codigo;
	private String titulo;
	private String descripcion;
	private String clase_css;
	private int visible;
	
	private ArrayList<Pagina_ambiental_menu_seccion> lista_secciones;
	
	private ConnectionMySQL conmysql;
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public Pagina_ambiental_menu()
	{
		this.id = 0;
		this.id_pagina_ambiental = 0;
		this.codigo = "";
		this.titulo = "";
		this.descripcion = "";
		this.clase_css = "";
		this.visible = 0;
		
		this.lista_secciones = new ArrayList<>();
	}
	
	public Pagina_ambiental_menu(int p_id)
	{
		Pagina_ambiental_menu aux = this.buscar(p_id);
		
		this.id = aux.getId();
		this.id_pagina_ambiental = aux.getId_pagina_ambiental();
		this.codigo = aux.getCodigo();
		this.titulo = aux.getTitulo();
		this.descripcion = aux.getDescripcion();
		this.clase_css = aux.getClase_css();
		this.visible = aux.getVisible();
		
		this.setLista_secciones(this);
	}
	
	public Pagina_ambiental_menu(int p_id, int p_id_pagina_ambiental, String p_codigo, String p_titulo, String p_descripcion, String p_clase_css, int p_visible)
	{
		this.id = p_id;
		this.id_pagina_ambiental = p_id_pagina_ambiental;
		this.codigo = p_codigo;
		this.titulo = p_titulo;
		this.descripcion = p_descripcion;
		this.clase_css = p_clase_css;
		this.descripcion = p_descripcion;
		this.visible = p_visible;
		
		this.setLista_secciones(this);
	}

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public ArrayList<Pagina_ambiental_menu_seccion> getLista_secciones() {
		return lista_secciones;
	}

	public void setLista_secciones(ArrayList<Pagina_ambiental_menu_seccion> lista_secciones) {
		this.lista_secciones = lista_secciones;
	}
	
	public Pagina_ambiental_menu buscar(int p_id)
	{
		Pagina_ambiental_menu pagina_ambiental_menu = null;
		String sql_select = "select id, pagina_ambiental_id, codigo, titulo, descripcion, clase_css, visible from pagina_ambiental_menu where id = ? order by codigo ";
		
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
				String aux_codigo = rs.getString(3);
				String aux_titulo = rs.getString(4);
				String aux_descripcion = rs.getString(5);
				String aux_clase_css = rs.getString(6);
				int aux_visible = rs.getInt(7);
				
				pagina_ambiental_menu = new Pagina_ambiental_menu(aux_id, aux_pagina_ambiental_id, aux_codigo, aux_titulo, aux_descripcion, aux_clase_css, aux_visible);

			}
			//System.out.println("Pagina_ambiental buscar(int p_id)=:" + this.lista_secciones.size());
			rs.close();
			conn.close();
			
			return pagina_ambiental_menu;
		}
		catch(Exception e)
		{
			System.out.println("Pagina_ambiental_menu buscar(int p_id):" + e.getMessage());
			return pagina_ambiental_menu;
		}
	}
	
	public ArrayList<Pagina_ambiental_menu> listar(int p_id)
	{
		ArrayList<Pagina_ambiental_menu> lista_pagina_ambiental_menu = new ArrayList<>();
		String sql_select = "select id, pagina_ambiental_id, codigo, titulo, descripcion, clase_css, visible from pagina_ambiental_menu where pagina_ambiental_id = ? order by codigo ";
		
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
				String aux_codigo = rs.getString(3);
				String aux_titulo = rs.getString(4);
				String aux_descripcion = rs.getString(5);
				String aux_clase_css = rs.getString(6);
				int aux_visible = rs.getInt(7);
				
				Pagina_ambiental_menu aux_pagina_ambiental_menu = new Pagina_ambiental_menu(aux_id, aux_pagina_ambiental_id, aux_codigo, aux_titulo, aux_descripcion, aux_clase_css, aux_visible);
				lista_pagina_ambiental_menu.add(aux_pagina_ambiental_menu);
			}
			//System.out.println("ArrayList<Pagina_ambiental_menu> listar(int p_id)=:" + this.lista_secciones.size());
			rs.close();
			conn.close();
			
			return lista_pagina_ambiental_menu;
		}
		catch(Exception e)
		{
			System.out.println("ArrayList<Pagina_ambiental_menu> listar:" + e.getMessage());
			return lista_pagina_ambiental_menu;
		}
	}
	
	public void setLista_secciones(Pagina_ambiental_menu p_pagina_ambiental_menu)
	{
		ArrayList<Pagina_ambiental_menu_seccion> lista_secciones = null;
		Pagina_ambiental_menu_seccion seccion_aux = new Pagina_ambiental_menu_seccion();
		this.lista_secciones = seccion_aux.listar(this.id);
	}
	
	public boolean modificar(int p_id, String p_titulo, String p_css, boolean p_visible, String p_descripcion)
	{ 	
		Pagina_ambiental_menu pagina_ambiental_menu = null;
		String sql_update = " update pagina_ambiental_menu set titulo = ?, clase_css = ?, visible = ?, descripcion = ? ";
		sql_update = sql_update.concat(	" where id = ?");
		
		try
		{   
			conmysql = new ConnectionMySQL();
			conn = conmysql.getConn();
			ps = conn.prepareStatement(sql_update);
			ps.setString(1,p_titulo);
			ps.setString(2,p_css);
			ps.setBoolean(3,p_visible);
			ps.setString(4,p_descripcion);
			ps.setInt(5,p_id);
			
			int result_update = ps.executeUpdate();
			
			ps.close();
			conn.close();
			
			return true;
		}
		catch(Exception e)
		{
			System.out.println("boolean modificar((int p_id, String p_titulo, String p_css, boolean p_visible, String p_descripcion):" + e.getMessage());
			return false;
		}
	}
	
	public boolean agregar(int pagina_ambiental_id, String p_codigo, String p_titulo, String p_css, boolean p_visible, String p_descripcion)
	{ 	
		Pagina_ambiental_seccion pagina_ambiental_seccion = null;
		String sql_insert = " insert into pagina_ambiental_menu ( pagina_ambiental_id, codigo, titulo, clase_css, visible, descripcion)";
		sql_insert = sql_insert.concat(	" values( ?, ?, ?, ?, ?, ?)" );
		
		try
		{   
			conmysql = new ConnectionMySQL();
			conn = conmysql.getConn();
			
			ps = conn.prepareStatement(sql_insert);
			ps.setInt(1,pagina_ambiental_id);
			ps.setString(2,p_codigo);
			ps.setString(3,p_titulo);
			ps.setString(4,p_css);
			ps.setBoolean(5,p_visible);
			ps.setString(6,p_descripcion);
			
			int result_update = ps.executeUpdate();
			
			ps.close();
			conn.close();
			
			return true;
		}
		catch(Exception e)
		{
			System.out.println("boolean agregar(int pagina_ambiental_id, String p_codigo, String p_titulo, String p_css, boolean p_visible, String p_descripcion):" + e.getMessage());
			return false;
		}
	}
	
	public boolean eliminar(int p_id)
	{
		Pagina_ambiental_menu seccion_aux = null;
		String sql_delete = " delete from pagina_ambiental_menu"
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

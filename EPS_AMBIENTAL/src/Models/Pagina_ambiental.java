package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import SQL.ConnectionMySQL;

public class Pagina_ambiental {
	
	private int id;
	private int id_padre;
	private String codigo;
	private String nombre;
	private String path_header_image;
	private int visible;
	private String descripcion;
	
	private ArrayList<String> lista_titulos;
	
	private ArrayList<Pagina_ambiental_seccion> lista_secciones;
	
	private ArrayList<Pagina_ambiental_menu> lista_menu;
	
	private ArrayList<Pagina_ambiental_carrete> lista_carrete;
	
	private ConnectionMySQL conmysql;
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public Pagina_ambiental()
	{
		this.id = 0;
		this.id_padre = 0;
		this.codigo = "";
		this.nombre = "";
		this.path_header_image = "";
		this.visible = 0;
		this.descripcion = "";
		this.lista_titulos = new ArrayList<>();
		this.lista_secciones = new ArrayList<>();
		this.lista_carrete = new ArrayList<>();
		this.lista_menu = new ArrayList<>();
	}
	
	public Pagina_ambiental(int p_id)
	{
		Pagina_ambiental aux = buscar(p_id);
		
		this.id = aux.id;
		this.id_padre = aux.id_padre;
		this.codigo = aux.codigo;
		this.nombre = aux.nombre;
		this.path_header_image = aux.path_header_image;
		this.visible = aux.visible;
		this.descripcion = aux.descripcion;
		this.lista_titulos = listarTitulos();
		this.setLista_secciones(this);
		this.setLista_carrete(this);
		this.setLista_menu(this);
	}
	
	public Pagina_ambiental(int p_id, int p_id_padre, String p_codigo, String p_nombre, String p_path_header_image, int p_visible, String p_descripcion)
	{
		this.id = p_id;
		this.id_padre = p_id_padre;
		this.codigo = p_codigo;
		this.nombre = p_nombre;
		this.path_header_image = p_path_header_image;
		this.visible = p_visible;
		this.descripcion = p_descripcion;
		this.lista_titulos = listarTitulos();
		this.setLista_secciones(this);
		this.setLista_carrete(this);
		this.setLista_menu(this);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_padre() {
		return id_padre;
	}

	public void setId_padre(int id_padre) {
		this.id_padre = id_padre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPath_header_image() {
		return path_header_image;
	}

	public void setPath_header_image(String path_header_image) {
		this.path_header_image = path_header_image;
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

	public ArrayList<String> getLista_titulos() {
		return lista_titulos;
	}

	public void setLista_titulos(ArrayList<String> lista_titulos) {
		this.lista_titulos = lista_titulos;
	}
	
	public ArrayList<Pagina_ambiental_seccion> getLista_secciones() {
		return lista_secciones;
	}

	public void setLista_secciones(ArrayList<Pagina_ambiental_seccion> lista_secciones) {
		this.lista_secciones = lista_secciones;
	}
	
	public ArrayList<Pagina_ambiental_carrete> getLista_carrete() {
		return lista_carrete;
	}

	public void setLista_carrete(ArrayList<Pagina_ambiental_carrete> lista_carrete) {
		this.lista_carrete = lista_carrete;
	}

	public ArrayList<Pagina_ambiental_menu> getLista_menu() {
		return lista_menu;
	}

	public void setLista_menu(ArrayList<Pagina_ambiental_menu> lista_menu) {
		this.lista_menu = lista_menu;
	}

	public Pagina_ambiental buscar(int p_id)
	{
		Pagina_ambiental pagina_ambiental = null;
		String sql_select = "select id, id_pagina_padre, codigo, nombre, header_image, visible, descripcion from pagina_ambiental where id = ? order by codigo ";
		
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
				int aux_id_pagina_padre = rs.getInt(2);
				String aux_codigo = rs.getString(3);
				String aux_nombre = rs.getString(4);
				String aux_header_image = rs.getString(5);
				int aux_visible = rs.getInt(6);
				String aux_descripcion = rs.getString(7);
				
				pagina_ambiental = new Pagina_ambiental(aux_id, aux_id_pagina_padre, aux_codigo, aux_nombre, aux_header_image, aux_visible, aux_descripcion);

			}
			//System.out.println("Pagina_ambiental buscar(int p_id)=:" + this.lista_secciones.size());
			rs.close();
			conn.close();
			
			return pagina_ambiental;
		}
		catch(Exception e)
		{
			System.out.println("Pagina_ambiental buscar(int p_id):" + e.getMessage());
			return pagina_ambiental;
		}
	}
	
	public void setLista_secciones(Pagina_ambiental p_pagina_ambiental)
	{
		ArrayList<Pagina_ambiental_seccion> lista_secciones = null;
		Pagina_ambiental_seccion seccion_aux = new Pagina_ambiental_seccion();
		this.lista_secciones = seccion_aux.listar(this.id);
	}
	
	public void setLista_menu(Pagina_ambiental p_pagina_ambiental)
	{
		ArrayList<Pagina_ambiental_menu> lista_menu = null;
		Pagina_ambiental_menu menu_aux = new Pagina_ambiental_menu();
		this.lista_menu = menu_aux.listar(this.id);
	}
	
	public void setLista_carrete(Pagina_ambiental p_pagina_ambiental)
	{
		ArrayList<Pagina_ambiental_carrete> lista_carrete = null;
		Pagina_ambiental_carrete carrete_aux = new Pagina_ambiental_carrete();
		this.lista_carrete = carrete_aux.listar(this.id);
	}
	
	public ArrayList<Pagina_ambiental> listar()
	{
		ArrayList<Pagina_ambiental>  lista_pagina_ambiental = new ArrayList<>();
		String sql_select = "select id, id_pagina_padre, codigo, nombre, header_image, visible, descripcion from pagina_ambiental order by codigo ";
		
		try
		{   
			conmysql = new ConnectionMySQL();
			conn = conmysql.getConn();
			ps = conn.prepareStatement(sql_select);
			rs = ps.executeQuery();
			rs.beforeFirst();
			while (rs.next())
			{
				int aux_id = rs.getInt(1);
				int aux_id_pagina_padre = rs.getInt(2);
				String aux_codigo = rs.getString(3);
				String aux_nombre = rs.getString(4);
				String aux_header_image = rs.getString(5);
				int aux_visible = rs.getInt(6);
				String aux_descripcion = rs.getString(7);
				
				Pagina_ambiental aux_pagina_ambiental = new Pagina_ambiental(aux_id, aux_id_pagina_padre, aux_codigo, aux_nombre, aux_header_image, aux_visible, aux_descripcion);
				lista_pagina_ambiental.add(aux_pagina_ambiental);
			}
			//System.out.println("Pagina_ambiental listar()=:" + this.lista_secciones.size());
			rs.close();
			conn.close();
			
			return lista_pagina_ambiental;
		}
		catch(Exception e)
		{
			System.out.println("Pagina_ambiental listar():" + e.getMessage());
			return lista_pagina_ambiental;
		}
	}
	
	public ArrayList<String> listarTitulos()
	{
		ArrayList<String>  lista_titulos_pagina_ambiental = new ArrayList<>();
		String sql_select = "select id, nombre from pagina_ambiental order by codigo ";
		
		try
		{
			conmysql = new ConnectionMySQL();
			conn = conmysql.getConn();
			ps = conn.prepareStatement(sql_select);
			rs = ps.executeQuery();
			rs.beforeFirst();
			
			while (rs.next())
			{
				int aux_id = rs.getInt(1);
				String aux_nombre = rs.getString(2);
				
				lista_titulos_pagina_ambiental.add(aux_nombre);
			}
			//System.out.println("Pagina_ambiental listar()=:" + this.lista_secciones.size());
			rs.close();
			conn.close();
			
			return lista_titulos_pagina_ambiental;
		}
		catch(Exception e)
		{
			System.out.println("ArrayList<String> listarTitulos():" + e.getMessage());
			return lista_titulos_pagina_ambiental;
		}
	}
	
	public boolean modificar(int p_id, String p_nombre, String p_header_image, boolean p_visible, String p_descripcion)
	{
		Pagina_ambiental pagina_ambiental = null;
		String sql_update = " update pagina_ambiental set nombre = ?, visible = ?, descripcion = ?";
		sql_update = sql_update.concat( !p_header_image.equalsIgnoreCase("") ? " , header_image = ?" : "" );
		sql_update = sql_update.concat(	" where id = ?" );
		
		try
		{   
			conmysql = new ConnectionMySQL();
			conn = conmysql.getConn();
			
			ps = conn.prepareStatement(sql_update);
			ps.setString(1,p_nombre);
			ps.setBoolean(2,p_visible);
			ps.setString(3,p_descripcion);
			
			if(!p_header_image.equalsIgnoreCase(""))
			{
				ps.setString(4,p_header_image);
				ps.setInt(5,p_id);
			}
			else
			{
				ps.setInt(4,p_id);
			}
			
			int result_update = ps.executeUpdate();
			
			ps.close();
			conn.close();
			
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Pagina_ambiental modificar(int p_id, String p_nombre, String p_header_image, boolean p_visible, String p_descripcion):" + e.getMessage());
			return false;
		}
	}
}

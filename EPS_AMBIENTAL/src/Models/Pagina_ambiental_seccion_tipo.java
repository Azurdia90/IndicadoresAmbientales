package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import SQL.ConnectionMySQL;

public class Pagina_ambiental_seccion_tipo {
	
	private int id;
	private String codigo;
	private String nombre;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Pagina_ambiental_seccion_tipo()
	{
		this.id = 0;
		this.codigo = "";
		this.nombre = "";
		this.descripcion = "";
	}
	
	public Pagina_ambiental_seccion_tipo(int p_id)
	{
		Pagina_ambiental_seccion_tipo aux = this.buscar(p_id);
		
		this.id = aux.id;
		this.codigo = aux.codigo;
		this.nombre = aux.nombre;
		this.descripcion = aux.descripcion;
	}
	
	public Pagina_ambiental_seccion_tipo(int p_id, String p_codigo, String p_nombre, String p_descripcion)
	{
		this.id = p_id;
		this.codigo = p_codigo;
		this.nombre = p_nombre;
		this.descripcion = p_descripcion;
	}
	
	
	public Pagina_ambiental_seccion_tipo buscar(int p_id)
	{
		Pagina_ambiental_seccion_tipo pagina_ambiental_seccion_tipo = null;
		String sql_select = "select id, codigo, nombre, descripcion from pagina_ambiental_seccion_tipo where id = ? order by codigo ";
		
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
				String aux_codigo = rs.getString(2);
				String aux_nombre = rs.getString(3);
				String aux_descripcion = rs.getString(4);
				
				pagina_ambiental_seccion_tipo = new Pagina_ambiental_seccion_tipo(aux_id, aux_codigo, aux_nombre, aux_descripcion);
				
			}
			//System.out.println("Pagina_ambiental_seccion buscar(int p_id)=:" + this.lista_secciones.size());
			rs.close();
			conn.close();
			
			return pagina_ambiental_seccion_tipo;
		}
		catch(Exception e)
		{
			System.out.println("Pagina_ambiental_seccion buscar(int p_id):" + e.getMessage());
			return pagina_ambiental_seccion_tipo;
		}
	}
	
	public ArrayList<Pagina_ambiental_seccion_tipo> listar()
	{
		ArrayList<Pagina_ambiental_seccion_tipo> lista_pagina_ambiental_seccion_tipo = new ArrayList<>();
		String sql_select = "select id, codigo, nombre, descripcion from pagina_ambiental_seccion_tipo order by codigo ";
		
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
				String aux_codigo = rs.getString(2);
				String aux_nombre = rs.getString(3);
				String aux_descripcion = rs.getString(4);
				
				Pagina_ambiental_seccion_tipo aux_pagina_ambiental_seccion_tipo = new Pagina_ambiental_seccion_tipo(aux_id, aux_codigo, aux_nombre, aux_descripcion);
				lista_pagina_ambiental_seccion_tipo.add(aux_pagina_ambiental_seccion_tipo);
			}
			//System.out.println("ArrayList<Pagina_ambiental_seccion> listar(int p_id)=:" + this.lista_secciones.size());
			rs.close();
			conn.close();
			
			return lista_pagina_ambiental_seccion_tipo;
		}
		catch(Exception e)
		{
			System.out.println("ArrayList<Pagina_ambiental_seccion> listar:" + e.getMessage());
			return lista_pagina_ambiental_seccion_tipo;
		}
	}
	
	public boolean modificar(int p_id, String p_nombre, String p_descripcion)
	{ 	
		Pagina_ambiental_seccion_tipo pagina_ambiental_seccion = null;
		String sql_update = " update pagina_ambiental_seccion_tipo set nombre = ?, descripcion = ?  where id = ?";
		
		try
		{   
			conmysql = new ConnectionMySQL();
			conn = conmysql.getConn();
			ps = conn.prepareStatement(sql_update);
			ps.setString(1,p_nombre);
			ps.setString(2,p_descripcion);
			ps.setInt(3,p_id);
			
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

}

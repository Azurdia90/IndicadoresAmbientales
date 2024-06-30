package Modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import SQL.ConnectionMySQL;

public class Areas_Intervencion{
	
	private int id;
	private String codigo;
	private String nombre;
	private int area_geografica_id;
	private String area_geografica_nombre;
	private String descripcion;

	private ConnectionMySQL conmysql;
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public Areas_Intervencion()
	{
		this.id = 0;
		this.codigo = "null";
		this.nombre = "null";
	}
	
	public Areas_Intervencion(int p_id)
	{
		this.id = p_id;
		
		String sql_select = "select id, codigo, nombre, area_geografica_id, descripcion nombre from area_intervencion where id = ?";

		try
		{
			conmysql = new ConnectionMySQL();
			conn = conmysql.getConn();
			ps = conn.prepareStatement(sql_select);
			ps.setInt(1, this.id);
			rs = ps.executeQuery();
			
			while (rs.next())
			{
				this.codigo = rs.getString(2);
				this.nombre = rs.getString(3);
				this.area_geografica_id = rs.getInt(4);
				this.descripcion = rs.getString(5);
				this.setArea_Geografica_nombre(this.area_geografica_id);
			}
			
			conn.close();
		}
		catch(Exception e)
		{
			System.out.println("Areas_Intervención Areas_Intervencion(int p_id):" + e.getMessage());
			this.codigo = "error";
			this.nombre = "error";
			this.area_geografica_id = 0;
			this.area_geografica_nombre = "error";
			this.descripcion = "error";
		}
	}
	
	public Areas_Intervencion(int p_id, String p_codigo, 
							 String p_nombre, int p_area_geografica_id, String p_descripcion)
	{
		this.id = p_id;
		this.codigo = p_codigo;
		this.nombre = p_nombre;
		this.area_geografica_id = p_area_geografica_id;
		this.descripcion = p_descripcion;
		this.setArea_Geografica_nombre(this.area_geografica_id);
	}
	
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
	
	public int getArea_geografica_id() {
		return area_geografica_id;
	}

	public void setArea_geografica_id(int area_geografica_id) {
		this.area_geografica_id = area_geografica_id;
	}

	public String getArea_geografica_nombre() {
		return area_geografica_nombre;
	}

	public void setArea_geografica_nombre(String area_geografica_nombre) {
		this.area_geografica_nombre = area_geografica_nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Areas_Intervencion> listar()
	{
		List<Areas_Intervencion> lista_areas_intervencion = new ArrayList<>();
		String sql_select = "select id, codigo, nombre, area_geografica_id, descripcion from area_intervencion";

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
				int aux_area_geografica = rs.getInt(4);
				String aux_descripcion = rs.getString(5);
				
				Areas_Intervencion aux_area = new Areas_Intervencion(aux_id, aux_codigo, aux_nombre,aux_area_geografica,aux_descripcion);
				lista_areas_intervencion.add(aux_area);
			}
			//System.out.println("Variable listar().size)=:" + lista_variables.size());
			rs.close();
			
			return lista_areas_intervencion;
			
		}
		catch(Exception e)
		{
			System.out.println("Areas_Intervencion listar():" + e.getMessage());
			return null;
		}
	}
	
	public Areas_Intervencion buscar_id(int p_id)
	{
		Areas_Intervencion aux_areas_intervencion = null;
		String sql_select = "select id, codigo, nombre, area_geografica_id, descripcion from area_intervencion where id = ?";

		try
		{
			conmysql = new ConnectionMySQL();
			conn = conmysql.getConn();
			ps = conn.prepareStatement(sql_select);
			ps.setInt(1, p_id);
			rs = ps.executeQuery();
			rs.beforeFirst();
			
			while (rs.next())
			{
				int aux_id = rs.getInt(1);
				String aux_codigo = rs.getString(2);
				String aux_nombre = rs.getString(3);
				int aux_area_geografica = rs.getInt(4);
				String aux_descripcion = rs.getString(5);
				aux_areas_intervencion  = new Areas_Intervencion(aux_id, aux_codigo, aux_nombre, aux_area_geografica, aux_descripcion);
				return aux_areas_intervencion;
			}
			//System.out.println("ODS buscar_id(p_id))=:" + ods.getId());
			rs.close();
			
			return aux_areas_intervencion;
			
		}
		catch(Exception e)
		{
			System.out.println("Areas_Intervención buscar_id(int p_id):" + e.getMessage());
			return null;
		}
	}
	
	public String getUltimo_codigo()
	{
		String aux_codigo = "";
		String sql_select = "SELECT CODIGO FROM area_intervencion WHERE id = (select  MAX(id) from area_intervencion)";
		
		try
		{   
			conmysql = new ConnectionMySQL();
			conn = conmysql.getConn();
			ps = conn.prepareStatement(sql_select);
			rs = ps.executeQuery();
			rs.beforeFirst();
			
			while (rs.next())
			{	System.out.println(rs.getString(1));
				aux_codigo = rs.getString(1);
			}
			rs.close();
			
			return aux_codigo;
		}
		catch(Exception e)
		{
			System.out.println("Areas_intervencion ultimo_codigo():" + e.getMessage());
			return aux_codigo;
		}
	}

	public boolean agregar(String p_codigo, String p_nombre, int p_area_geografica_id, String p_descripcion)
	{
		Areas_Intervencion area_intervencion = null;
		String sql_create = " insert into area_intervencion(codigo,nombre,area_geografica_id,descripcion)"
						  + "  values(?,?,?,?)";
		
		try
		{   
			conmysql = new ConnectionMySQL();
			conn = conmysql.getConn();
			
			ps = conn.prepareStatement(sql_create);
			ps.setString(1,p_codigo);
			ps.setString(2,p_nombre);
			ps.setInt(3,p_area_geografica_id);
			ps.setString(4,p_descripcion);
	
			int result_create = ps.executeUpdate();
			
			ps.close();
			
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Areas_intervencion agregar(String p_codigo, String p_nombre, int p_area_geografica_id, String p_descripcion):" + e.getMessage());
			return false;
		}
	}
	
	public boolean modificar(int p_id, String p_nombre, int p_area_geografica_id, String p_descripcion)
	{
		Areas_Intervencion area_intervencion = null;
		String sql_update = " update area_intervencion set nombre = ?, area_geografica_id = ?, descripcion = ? "
						  + " where id = ?";
		
		try
		{   
			conmysql = new ConnectionMySQL();
			conn = conmysql.getConn();
			
			ps = conn.prepareStatement(sql_update);
			ps.setString(1,p_nombre);
			ps.setInt(2,p_area_geografica_id);
			ps.setString(3,p_descripcion);
			ps.setInt(4,p_id);
			
			int result_update = ps.executeUpdate();
			
			ps.close();
			
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Areas_intervencion modificar(int p_id, String p_nombre, int p_area_geografica_id, String p_descripcion):" + e.getMessage());
			return false;
		}
	}
	
	public boolean eliminar(int p_id)
	{
		Areas_Intervencion area_intervencion = null;
		String sql_delete = " delete from area_intervencion"
						  + " where id = ?";
		
		try
		{   
			conmysql = new ConnectionMySQL();
			conn = conmysql.getConn();
			
			ps = conn.prepareStatement(sql_delete);
			ps.setInt(1,p_id);
			
			int result_update = ps.executeUpdate();
			
			ps.close();
			
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Areas_intervencion eliminar(int p_id):" + e.getMessage());
			return false;
		}
	}
	
	private void setArea_Geografica_nombre(int p_id)
	{
		Areas_Geograficas area_geografica = new Areas_Geograficas(p_id);
		this.area_geografica_nombre = area_geografica.getNombre();
	}

}
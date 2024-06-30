package Modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import SQL.ConnectionMySQL;

public class Areas_Geograficas {
	
	private int id;
	private String codigo;
	private String nombre;
	private String descripcion;
	
	private ConnectionMySQL conmysql;
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	public Areas_Geograficas()
	{
		this.id = 0;
		this.codigo = "";
		this.nombre = "";
		this.descripcion = "";
	}
	
	public Areas_Geograficas(int p_id)
	{
		this.id = p_id;
		
		String sql_select = "select id, codigo, nombre, descripcion from area_geografica where id = ?";

		try
		{
			conmysql = new ConnectionMySQL();
			conn = conmysql.getConn();
			ps = conn.prepareStatement(sql_select);
			ps.setInt(1, this.id);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				this.codigo = rs.getString(2);
				this.nombre = rs.getString(3);
				this.descripcion = rs.getString(4);
			}
			
			conn.close();

		}
		catch(Exception e)
		{
			System.out.println("Areas_Geograficas Areas_Geograficas(int p_id):" + e.getMessage());
		}
	}
	
	public Areas_Geograficas(int p_id,
							 String p_codigo, 
							 String p_nombre,
							 String p_descripcion)
	{
		this.id = p_id;
		this.codigo = p_codigo;
		this.nombre = p_nombre;
		this.descripcion = p_descripcion;
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
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Areas_Geograficas> listar()
	{
		List<Areas_Geograficas> lista_areas_geograficas = new ArrayList<>();
		String sql_select = "select id, codigo, nombre, descripcion from area_geografica";

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
				
				Areas_Geograficas aux_area = new Areas_Geograficas(aux_id, aux_codigo, aux_nombre, aux_descripcion);
				lista_areas_geograficas.add(aux_area);
			}
			//System.out.println("Variable listar().size)=:" + lista_variables.size());
			rs.close();
			
			return lista_areas_geograficas;
			
		}
		catch(Exception e)
		{
			System.out.println("Areas_Geograficas listar():" + e.getMessage());
			return null;
		}
	}
	
	public Areas_Geograficas buscar_id(int p_id)
	{
		Areas_Geograficas aux_areas_geograficas = null;
		String sql_select = "select id, codigo, nombre, descripcion from area_geografica where id = ?";

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
				String aux_descripcion = rs.getString(4);
				aux_areas_geograficas  = new Areas_Geograficas(aux_id, aux_codigo, aux_nombre, aux_descripcion);
			}
			//System.out.println("ODS buscar_id(p_id))=:" + ods.getId());
			rs.close();
			
			return aux_areas_geograficas;
			
		}
		catch(Exception e)
		{
			System.out.println("Areas_Geograficas buscar_id(int p_id):" + e.getMessage());
			return null;
		}
	}

	public String getUltimo_codigo()
	{
		String aux_codigo = "";
		String sql_select = "SELECT CODIGO FROM area_geografica WHERE id = (select  MAX(id) from area_geografica)";
		
		try
		{   
			conmysql = new ConnectionMySQL();
			conn = conmysql.getConn();
			ps = conn.prepareStatement(sql_select);
			rs = ps.executeQuery();
			rs.beforeFirst();
			while (rs.next())
			{
				aux_codigo = rs.getString(1);

			}
			rs.close();
			
			return aux_codigo;
		}
		catch(Exception e)
		{
			System.out.println("Areas_Geograficas ultimo_codigo():" + e.getMessage());
			return aux_codigo;
		}
	}

	public boolean agregar(String p_codigo, String p_nombre, String p_descripcion)
	{
		Areas_Geograficas area_geografica = null;
		String sql_create = " insert into area_geografica(codigo,nombre,descripcion) "
						  + "  values(?,?,?)";
		
		try
		{   
			conmysql = new ConnectionMySQL();
			conn = conmysql.getConn();
			
			ps = conn.prepareStatement(sql_create);
			ps.setString(1,p_codigo);
			ps.setString(2,p_nombre);
			ps.setString(3,p_descripcion);
	
			int result_create = ps.executeUpdate();
			
			ps.close();
			
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Areas_Geograficas agregar(String p_codigo, String p_nombre, String p_descripcion):" + e.getMessage());
			return false;
		}
	}
	
	public boolean modificar(int p_id, String p_nombre, String p_descripcion)
	{
		Areas_Geograficas area_geografica = null;
		String sql_update = " update area_geografica set nombre = ?, descripcion = ? "
						  + " where id = ?";
		
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
			
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Areas_Geograficas modificar(int p_id, String p_nombre, String p_descripcion):" + e.getMessage());
			return false;
		}
	}
	
	
	public boolean eliminar(int p_id)
	{
		Areas_Geograficas area_geografica = null;
		String sql_delete = " delete from area_geografica"
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
			System.out.println("Areas_Geograficas eliminar(int p_id):" + e.getMessage());
			return false;
		}
	}
}

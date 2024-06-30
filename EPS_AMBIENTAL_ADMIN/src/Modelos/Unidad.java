package Modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import SQL.ConnectionMySQL;

public class Unidad {
	
	private int idUnidad;
	private String nombre;
	private int tipo;

	private ConnectionMySQL conmysql;
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public Unidad()
	{		
		this.idUnidad = 0;
		this.nombre = "";
		this.tipo = 0;
	}
	
	public Unidad(int p_id)
	{
		this.idUnidad = p_id;
		
		String sql_select = "select idUNIDAD, NOMBRE, TIPO from unidad where idUNIDAD = ?";

		try
		{
			conmysql = new ConnectionMySQL();
			conn = conmysql.getConn();
			ps = conn.prepareStatement(sql_select);
			ps.setInt(1, p_id);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				this.idUnidad = rs.getInt(1);
				this.nombre = rs.getString(2);
				this.tipo = rs.getInt(3);
			}
			
			conn.close();

		}
		catch(Exception e)
		{
			System.out.println("Unidad Unidad(int p_id): " + e.getMessage());
		}
	}
	
	public Unidad(String p_nombre, 
				  int p_tipo)
	{		
		this.nombre = p_nombre;
		this.tipo = p_tipo;
	}
	
	public Unidad(int p_idUnidad,
				  String p_nombre, 
				  int p_tipo)
{	
	this.idUnidad = p_idUnidad;
	this.nombre = p_nombre;
	this.tipo = p_tipo;
}
	
	public int getIdUnidad() {
		return idUnidad;
	}

	public void setIdUnidad(int idUnidad) {
		this.idUnidad = idUnidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public List<Unidad> listar()
	{
		List<Unidad> lista_unidades = new ArrayList<>();
		String sql_select = "select idUNIDAD, NOMBRE, TIPO from unidad order by idUNIDAD ";
		
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
				int aux_tipo_id = rs.getInt(3);
				
				Unidad aux_unidad = new Unidad(aux_id, aux_nombre, aux_tipo_id);
				lista_unidades.add(aux_unidad);
			}
			//System.out.println("Variable listar().size)=:" + lista_variables.size());
			rs.close();
			
			return lista_unidades;
		}
		catch(Exception e)
		{
			System.out.println("Unidad listar():" + e.getMessage());
			return lista_unidades;
		}
	}

	public Unidad buscar_id(int p_id)
	{
		Unidad unidad = null;
		String sql_select = "select idUNIDAD, NOMBRE, TIPO from unidad where idUNIDAD = ? order by idUnidad ";
		
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
				String aux_nombre = rs.getString(2);
				int aux_tipo_id = rs.getInt(3);
				
				unidad= new Unidad(aux_id, aux_nombre, aux_tipo_id);

			}
			//System.out.println("Variable buscar())=:" + lista_variables.size());
			rs.close();
			
			return unidad;
		}
		catch(Exception e)
		{
			System.out.println("Unidad buscar(int p_id):" + e.getMessage());
			return unidad;
		}
	}
	
	public String getUltimo_codigo()
	{
		String aux_codigo = "";
		String sql_select = "select MAX(idUnidad) from unidad ";
		
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
			System.out.println("Unidad ultimo_codigo():" + e.getMessage());
			return aux_codigo;
		}
	}
	
	public boolean agregar(int p_id, String p_nombre, int p_tipo)
	{
		Unidad unidad = null;
		String sql_create = " insert into unidad(idUnidad,NOMBRE,TIPO) "
						  + "  values(?,?,?)";
		
		try
		{   
			conmysql = new ConnectionMySQL();
			conn = conmysql.getConn();
			
			ps = conn.prepareStatement(sql_create);
			ps.setInt(1,p_id);
			ps.setString(2,p_nombre);
			ps.setInt(3,p_tipo);
	
			int result_create = ps.executeUpdate();
			
			ps.close();
			
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Unidad agregar(int p_id, String p_nombre, int p_tipo):" + e.getMessage());
			return false;
		}
	}
	
	public boolean modificar(int p_id, String p_nombre, int p_tipo)
	{
		Unidad unidad = null;
		String sql_update = " update unidad set nombre = ?, tipo = ? "
						  + " where idUnidad = ?";
		
		try
		{   
			conmysql = new ConnectionMySQL();
			conn = conmysql.getConn();
			
			ps = conn.prepareStatement(sql_update);
			ps.setString(1,p_nombre);
			ps.setInt(2,p_tipo);
			ps.setInt(3,p_id);
			
			int result_update = ps.executeUpdate();
			
			ps.close();
			
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Unidad modificar(int p_id, String p_nombre, int p_tipo):" + e.getMessage());
			return false;
		}
	}
	
	public boolean eliminar(int p_id)
	{
		Unidad unidad = null;
		String sql_delete = " delete from unidad"
						  + " where idUNIDAD = ?";
		
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
			System.out.println("Unidad eliminar(int p_id):" + e.getMessage());
			return false;
		}
	}

}

package Modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import SQL.ConnectionMySQL;

public class Variable {
	
	private int id;
	private String codigo;
	private String nombre;
	private int area_geografica_id;
	private String area_geografica_nombre;
	private int area_intervencion_id;
	private String area_intervencion_nombre;
	private int periodicidad_id;
	private String periodicidad_nombre;
	private String fuente;
	private String descripcion;
	
	private ConnectionMySQL conmysql;
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public Variable()
	{
		this.id = 0;
		this.codigo = "null";
		this.nombre = "null";
		this.area_geografica_id = 0;
		this.area_intervencion_id =0;
		this.periodicidad_id = 0;
		this.fuente =  "null";
		this.descripcion = "null";
		
		this.area_geografica_nombre = "null";
		this.area_intervencion_nombre = "null";
		this.periodicidad_nombre = "null";
		
	}
	
	public Variable(int   p_id,
					String p_codigo, 
					String p_nombre, 
					int p_area_geografica, 
					int p_area_intervencion, 
					int p_periocidad,  
					String p_fuente, 
					String p_descripcion)
	{
		this.id = p_id;
		this.codigo = p_codigo;
		this.nombre = p_nombre;
		this.area_geografica_id = p_area_geografica;
		this.area_intervencion_id = p_area_intervencion;
		this.periodicidad_id = p_periocidad;
		this.fuente = p_fuente;
		this.descripcion = p_descripcion;
		
		this.setArea_Geografica_nombre(this.area_geografica_id);
		this.setArea_Intervencion_nombre(this.area_intervencion_id);
		this.setPeriodicidad_nombre(this.id);
	}
	
	public Variable(String p_codigo, 
					String p_nombre, 
					String p_area_geografica, 
					String p_area_intervencion, 
					String p_periocidad,  
					String p_fuente, 
					String p_descripcion)
	{
		this.codigo = p_codigo;
		this.nombre = p_nombre;
		this.area_geografica_nombre = p_area_geografica;
		this.area_intervencion_nombre = p_area_intervencion;
		this.periodicidad_nombre = p_periocidad;
		this.fuente = p_fuente;
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

	public int getArea_geografica_id() {
		return area_geografica_id;
	}
	
	public String getArea_geografica_nombre() {
		return area_geografica_nombre;
	}

	public void setArea_geografica_id(int area_geografica) {
		this.area_geografica_id = area_geografica;
	}

	public int getArea_intervencion_id() {
		return area_intervencion_id;
	}
	
	public String getArea_intervencion_nombre() {
		return area_intervencion_nombre;
	}

	public void setArea_intervencion_id(int area_intervencion) {
		this.area_intervencion_id = area_intervencion;
	}

	public int getPeriocidad_id() {
		return periodicidad_id;
	}
	
	public String getPeriocidad_nombre() {
		return periodicidad_nombre;
	}

	public void setPeriocidad(int periodicidad) {
		this.periodicidad_id = periodicidad;
	}

	public String getFuente() {
		return fuente;
	}

	public void setFuente(String fuente) {
		this.fuente = fuente;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public List<Variable> listar()
	{
		List<Variable> lista_variables = new ArrayList<>();
		String sql_select = "select id, codigo, nombre, area_geografica_id, area_intervencion_id, periodicidad_id, descripcion from variable order by codigo ";
		
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
				int aux_area_geografica_id = rs.getInt(4);
				int aux_area_intervencion_id = rs.getInt(5);
				int aux_periodicidad_id = rs.getInt(6);
				String aux_descripcion = rs.getString(7);
				
				Variable aux_variable = new Variable(aux_id, aux_codigo, aux_nombre, aux_area_geografica_id, aux_area_intervencion_id, aux_periodicidad_id, aux_descripcion, "");
				lista_variables.add(aux_variable);
			}
			//System.out.println("Variable listar().size)=:" + lista_variables.size());
			rs.close();
			
			return lista_variables;
		}
		catch(Exception e)
		{
			System.out.println("Variable listar():" + e.getMessage());
			return lista_variables;
		}
	}
	
	public Variable buscar(int p_id)
	{
		Variable variable = null;
		String sql_select = "select id, codigo, nombre, area_geografica_id, area_intervencion_id, periodicidad_id, descripcion from variable where id = ? order by codigo ";
		
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
				int aux_area_geografica_id = rs.getInt(4);
				int aux_area_intervencion_id = rs.getInt(5);
				int aux_periodicidad_id = rs.getInt(6);
				String aux_descripcion = rs.getString(7);
				
				variable = new Variable(aux_id, aux_codigo, aux_nombre, aux_area_geografica_id, aux_area_intervencion_id, aux_periodicidad_id, aux_descripcion, "");

			}
			//System.out.println("Variable buscar())=:" + lista_variables.size());
			rs.close();
			
			return variable;
		}
		catch(Exception e)
		{
			System.out.println("Variable buscar(int p_id):" + e.getMessage());
			return variable;
		}
	}
	
	public String getUltimo_codigo()
	{
		String aux_codigo = "";
		String sql_select = "SELECT CODIGO FROM variable WHERE id = (select  MAX(id) from variable)";
		
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
			System.out.println("Variable ultimo_codigo():" + e.getMessage());
			return aux_codigo;
		}
	}
	
	public boolean agregar(String p_codigo, String p_nombre, int p_area_geografica, int p_area_intervencion, int p_periodicidad, String p_descripcion)
	{
		Variable variable = null;
		String sql_create = " insert into variable(codigo,nombre,area_geografica_id,area_intervencion_id,periodicidad_id,descripcion) "
						  + "  values(?,?,?,?,?,?)";
		
		try
		{   
			conmysql = new ConnectionMySQL();
			conn = conmysql.getConn();
			
			ps = conn.prepareStatement(sql_create);
			ps.setString(1,p_codigo);
			ps.setString(2,p_nombre);
			ps.setInt(3,p_area_geografica);
			ps.setInt(4,p_area_intervencion);
			ps.setInt(5,p_periodicidad);
			ps.setString(6,p_descripcion);
			
			int result_create = ps.executeUpdate();
			
			ps.close();
			
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Variable agregar(String p_codigo, "
							 + "				 String p_nombre, "
							 + " 				 int p_area_geografica, "
							 + "				 int p_area_intervencion, "
							 + "				 int p_periodicidad, "
							 + " 				 String p_descripcion):" + e.getMessage());
			return false;
		}
	}
	
	public boolean modificar(int p_id, String p_nombre, int p_area_geografica, int p_area_intervencion, int p_periodicidad, String p_descripcion )
	{
		Variable variable = null;
		String sql_update = " update variable set nombre = ?, "
						  + "                     area_geografica_id = ?, "
						  + "                     area_intervencion_id = ?, "
						  + "                     periodicidad_id = ? , "
						  + "                     descripcion  = ? "
						  + " where id = ?";
		
		try
		{   
			conmysql = new ConnectionMySQL();
			conn = conmysql.getConn();
			
			ps = conn.prepareStatement(sql_update);
			ps.setString(1,p_nombre);
			ps.setInt(2,p_area_geografica);
			ps.setInt(3,p_area_intervencion);
			ps.setInt(4,p_periodicidad);
			ps.setString(5,p_descripcion);
			ps.setInt(6,p_id);
			
			int result_update = ps.executeUpdate();
			
			ps.close();
			
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Variable modificar(int p_id, String p_nombre, int p_area_geografica, int p_area_intervencion, int p_periodicidad, String p_descripcion):" + e.getMessage());
			return false;
		}	
	}
	

	public boolean eliminar(int p_id)
	{
		Variable variable = null;
		String sql_delete = " delete from variable"
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
			System.out.println("Variable eliminar(int p_id):" + e.getMessage());
			return false;
		}
	}
	
	private void setArea_Geografica_nombre(int p_id)
	{
		Areas_Geograficas area_geografica = new Areas_Geograficas(p_id);
		this.area_geografica_nombre = area_geografica.getNombre();
	}
	
	private void setArea_Intervencion_nombre(int p_id)
	{
		Areas_Intervencion area_intervencion = new Areas_Intervencion(p_id);
		this.area_intervencion_nombre = area_intervencion.getNombre();
	}
	
	private void setPeriodicidad_nombre(int p_id)
	{
		Periodicidad periodicidad = new Periodicidad(p_id);
		this.periodicidad_nombre = periodicidad.getNombre();
	}

}

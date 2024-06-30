package Modelos;

import java.io.LineNumberInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import SQL.ConnectionMySQL;

public class Indicador {
	
	private int id;
	private String codigo;
	private String nombre;
	private String formula;
	private int area_geografica_id;
	private String area_geografica_nombre;
	private int unidad_medida_id;
	private String unidad_medida_nombre;
	private int periocidad_id;
	private String periodicidad_nombre;
	private String descripcion;
	
	//listado de propiedades
	private ArrayList<Ejes_Politica_Ambiental> lista_politica_ambiental;
	private ArrayList<ODS> lista_ods;
	private ArrayList<Areas_Intervencion> lista_areas_intervencion;
	private ArrayList<Unidad> lista_unidades;
	private ArrayList<Variable> lista_variables;
	
	private ConnectionMySQL conmysql;
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public Indicador()
	{
		this.id = 0;
		this.codigo = "null";
		this.nombre = "null";
		this.formula = "null";
		this.area_geografica_id = 0;
		this.unidad_medida_id =0;
		this.periocidad_id = 0;
		this.descripcion = "null";
		
		this.area_geografica_nombre = "null";
		this.unidad_medida_nombre = "null";
		this.periodicidad_nombre = "null";
		
	}
	
	public Indicador(int   p_id,
					String p_codigo, 
					String p_nombre, 
					String p_formula,
					int p_area_geografica, 
					int p_unidad_medida, 
					int p_periocidad,  
					String p_descripcion)
	{
		this.id = p_id;
		this.codigo = p_codigo;
		this.nombre = p_nombre;
		this.formula = p_formula;
		this.area_geografica_id = p_area_geografica;
		this.unidad_medida_id = p_unidad_medida;
		this.periocidad_id = p_periocidad;
		this.descripcion = p_descripcion;
		
		this.setArea_Geografica_nombre(this.area_geografica_id);
		this.setUnidad_medida_nombre(this.unidad_medida_id);
		this.setPeriodicidad_nombre(this.periocidad_id);
	}
	
	public Indicador(String p_codigo, 
					String p_nombre, 
					String p_formula,
					String p_area_geografica, 
					String p_unidad_medida, 
					String p_periocidad,  
					String p_descripcion)
	{
		this.codigo = p_codigo;
		this.nombre = p_nombre;
		this.formula = p_formula;
		this.area_geografica_nombre = p_area_geografica;
		this.unidad_medida_nombre = p_unidad_medida;
		this.periodicidad_nombre = p_periocidad;
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

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public int getUnidad_medida_id() {
		return unidad_medida_id;
	}

	public void setUnidad_medida_id(int unidad_medida_id) {
		this.unidad_medida_id = unidad_medida_id;
	}

	public String getUnidad_medida_nombre() {
		return unidad_medida_nombre;
	}

	public void setUnidad_medida_nombre(String unidad_medida_nombre) {
		this.unidad_medida_nombre = unidad_medida_nombre;
	}

	public String getPeriodicidad_nombre() {
		return periodicidad_nombre;
	}

	public void setPeriodicidad_nombre(String periodicidad_nombre) {
		this.periodicidad_nombre = periodicidad_nombre;
	}

	public void setArea_geografica_nombre(String area_geografica_nombre) {
		this.area_geografica_nombre = area_geografica_nombre;
	}

	public void setPeriocidad_id(int periocidad_id) {
		this.periocidad_id = periocidad_id;
	}

	public int getPeriocidad_id() {
		return periocidad_id;
	}
	
	public String getPeriocidad_nombre() {
		return periodicidad_nombre;
	}

	public void setPeriocidad(int periocidad) {
		this.periocidad_id = periocidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public ArrayList<Ejes_Politica_Ambiental> getLista_politica_ambiental() {
		return lista_politica_ambiental;
	}

	public void setLista_politica_ambiental(ArrayList<Ejes_Politica_Ambiental> lista_politica_ambiental) {
		this.lista_politica_ambiental = lista_politica_ambiental;
	}

	public ArrayList<ODS> getLista_ods() {
		return lista_ods;
	}

	public void setLista_ods(ArrayList<ODS> lista_ods) {
		this.lista_ods = lista_ods;
	}

	public ArrayList<Areas_Intervencion> getLista_areas_intervencion() {
		return lista_areas_intervencion;
	}

	public void setLista_areas_intervencion(ArrayList<Areas_Intervencion> lista_areas_intervencion) {
		this.lista_areas_intervencion = lista_areas_intervencion;
	}

	public ArrayList<Unidad> getLista_unidades() {
		return lista_unidades;
	}

	public void setLista_unidades(ArrayList<Unidad> lista_unidades) {
		this.lista_unidades = lista_unidades;
	}

	public ArrayList<Variable> getLista_variables() {
		return lista_variables;
	}

	public void setLista_variables(ArrayList<Variable> lista_variables) {
		this.lista_variables = lista_variables;
	}

	public List<Indicador> listar()
	{
		List<Indicador> lista_indicadores = new ArrayList<>();
		String sql_select = "select id, codigo, nombre, formula, area_geografica_id, unidad_medida_id, periodicidad_id, descripcion from indicador order by codigo ";
		
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
				String aux_formula = rs.getString(4);
				int aux_area_geografica_id = rs.getInt(5);
				int aux_unidad_medida_id = rs.getInt(6);
				int aux_periodicidad_id = rs.getInt(7);
				String aux_descripcion = rs.getString(8);
				
				Indicador aux_indicador = new Indicador(aux_id, aux_codigo, aux_nombre, aux_formula, aux_area_geografica_id, aux_unidad_medida_id, aux_periodicidad_id, aux_descripcion);
				lista_indicadores.add(aux_indicador);
			}
			//System.out.println("Indicador listar().size)=:" + lista_variables.size());
			rs.close();
			
			return lista_indicadores;
		}
		catch(Exception e)
		{
			System.out.println("Indicador listar():" + e.getMessage());
			return lista_indicadores;
		}
	}
	
	public Indicador buscar(int p_id)
	{
		Indicador indicador = null;
		String sql_select = "select id, codigo, nombre, formula, area_geografica_id, unidad_medida_id, periodicidad_id, descripcion from indicador where id = ? order by codigo ";
		
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
				String aux_formula = rs.getString(4);
				int aux_area_geografica_id = rs.getInt(5);
				int aux_unidad_medida_id = rs.getInt(6);
				int aux_periodicidad_id = rs.getInt(7);
				String aux_descripcion = rs.getString(8);
				
				indicador = new Indicador(aux_id, aux_codigo, aux_nombre, aux_formula, aux_area_geografica_id, aux_unidad_medida_id, aux_periodicidad_id, aux_descripcion);

			}
			//System.out.println("Indicador buscar())=:" + lista_variables.size());
			rs.close();
			
			setLista_Areas_geograficas(indicador);
			setLista_ODS(indicador);
			setLista_Areas_Intervencion(indicador);
			setLista_Unidades(indicador);
			
			return indicador;
		}
		catch(Exception e)
		{
			System.out.println("Indicador buscar(int p_id):" + e.getMessage());
			return indicador;
		}
	}
	
	public String getUltimo_codigo()
	{
		String aux_codigo = "";
		String sql_select = "SELECT CODIGO FROM indicador WHERE id = (select  MAX(id) from indicador)";
		
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
			System.out.println("Indicador ultimo_codigo():" + e.getMessage());
			return aux_codigo;
		}
	}
	
	public boolean agregar(String p_codigo, String p_nombre, String p_formula, int p_area_geografica, int p_area_intervencion, int p_periodicidad, String p_descripcion)
	{
		Indicador variable = null;
		String sql_create = " insert into variable(codigo,nombre,formula,area_geografica_id,area_intervencion_id,periocidad_id,descripcion) "
						  + "  values(?,?,?,?,?,?,?)";
		
		try
		{   
			conmysql = new ConnectionMySQL();
			conn = conmysql.getConn();
			
			ps = conn.prepareStatement(sql_create);
			ps.setString(1,p_codigo);
			ps.setString(2,p_nombre);
			ps.setString(3,p_formula);
			ps.setInt(4,p_area_geografica);
			ps.setInt(5,p_area_intervencion);
			ps.setInt(6,p_periodicidad);
			ps.setString(7,p_descripcion);
			
			int result_create = ps.executeUpdate();
			
			ps.close();
			
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Indicador agregar(String p_codigo, "
							 + "				 String p_nombre, "
							 + "				 String p_formula, "
							 + " 				 int p_area_geografica, "
							 + "				 int p_area_intervencion, "
							 + "				 int p_periodicidad, "
							 + " 				 String p_descripcion):" + e.getMessage());
			return false;
		}
	}
	
	public boolean modificar(int p_id, String p_nombre, String p_formula, int p_area_geografica, int p_unidad_medida, int p_periodicidad, String p_descripcion )
	{
		Indicador variable = null;
		String sql_update = " update indicador set nombre = ?, "
						  + "                     formula = ?, "
						  + "                     area_geografica_id = ?, "
						  + "                     unidad_medida_id = ?, "
						  + "                     periodicidad_id = ? , "
						  + "                     descripcion  = ? "
						  + " where id = ?";
		
		try
		{   
			conmysql = new ConnectionMySQL();
			conn = conmysql.getConn();
			
			ps = conn.prepareStatement(sql_update);
			ps.setString(1,p_nombre);
			ps.setString(2,p_formula);
			ps.setInt(3,p_area_geografica);
			ps.setInt(4,p_unidad_medida);
			ps.setInt(5,p_periodicidad);
			ps.setString(6,p_descripcion);
			ps.setInt(7,p_id);
			
			int result_update = ps.executeUpdate();
			
			ps.close();
			
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Indicador modificar(int p_id, String p_nombre, int p_area_geografica, int p_area_intervencion, int p_periodicidad, String p_descripcion):" + e.getMessage());
			return false;
		}	
	}
	
	
	public boolean eliminar(int p_id)
	{
		Indicador variable = null;
		String sql_delete = " delete from indicador"
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
			System.out.println("Indicador eliminar(int p_id):" + e.getMessage());
			return false;
		}
	}
	
	private void setArea_Geografica_nombre(int p_id)
	{
		Areas_Geograficas area_geografica = new Areas_Geograficas(p_id);
		this.area_geografica_nombre = area_geografica.getNombre();
	}
	
	private void setUnidad_medida_nombre(int p_id)
	{
		Unidad_medida unidad_medida = new Unidad_medida(p_id);
		this.unidad_medida_nombre = unidad_medida.getNombre();
	}
	
	private void setPeriodicidad_nombre(int p_id)
	{
		Periodicidad periodicidad = new Periodicidad(p_id);
		this.periodicidad_nombre = periodicidad.getNombre();
	}
	
	private void setLista_Areas_geograficas(Indicador p_indicador)
	{
		ArrayList<Ejes_Politica_Ambiental> lista_politica_ambiental = new ArrayList();
		Ejes_Politica_Ambiental eje_politica_ambiental_aux;
		p_indicador.setLista_politica_ambiental(lista_politica_ambiental);
		
		String sql_select = "select indicador_id, eje_politica_ambiental_id from indicador_eje_politica_ambiental where indicador_id = ? ";
		try
		{   
			conmysql = new ConnectionMySQL();
			conn = conmysql.getConn();
			ps = conn.prepareStatement(sql_select);
			ps.setInt(1,p_indicador.getId());
			rs = ps.executeQuery();
			rs.beforeFirst();
			while (rs.next())
			{
				int aux_id = rs.getInt(2);
				
				eje_politica_ambiental_aux = new Ejes_Politica_Ambiental(aux_id);
				p_indicador.getLista_politica_ambiental().add(eje_politica_ambiental_aux);

			}
			//System.out.println("Indicador setLista_Areas_geograficas(Indicador p_indicador):" + lista_variables.size());
			rs.close();
		}
		catch(Exception e)
		{
			System.out.println("Indicador setLista_Areas_geograficas(Indicador p_indicador):" + e.getMessage());
		}
	}
	
	public boolean modificarListaEje_politica_ambiental(int p_id, String[] p_lista_ejes_politica_ambiental)
	{
		boolean return_ = false;
		this.eliminarListaEjes_politica_ambiental(p_id);
		
		String sql_update = " insert into indicador_eje_politica_ambiental(indicador_id,eje_politica_ambiental_id) "
						  + " values (?,?) ";
		
		for(int i = 0; i < p_lista_ejes_politica_ambiental.length; i++)
		{
			try
			{   
				conmysql = new ConnectionMySQL();
				conn = conmysql.getConn();
				
				ps = conn.prepareStatement(sql_update);
				ps.setInt(1,p_id);
				ps.setInt(2,Integer.parseInt(p_lista_ejes_politica_ambiental[i]));
				
				int result_update = ps.executeUpdate();
				
				ps.close();
				
				return_ = true;
			}
			catch(Exception e)
			{
				System.out.println("Indicador modificar(int p_id, String p_nombre, int p_area_geografica, int p_area_intervencion, int p_periodicidad, String p_descripcion):" + e.getMessage());
				return false;
			}
			
		}	
		
		return return_;
	}
	
	public boolean eliminarListaEjes_politica_ambiental(int p_id)
	{
		Indicador variable = null;
		String sql_delete = " delete from indicador_eje_politica_ambiental"
						  + " where indicador_id = ?";
		
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
			System.out.println("Indicador eliminarListaEjes_politica_ambiental(int p_id):" + e.getMessage());
			return false;
		}
	}
	
	private void setLista_ODS(Indicador p_indicador)
	{
		ArrayList<ODS> lista_ods = new ArrayList();
		ODS ods_aux;
		p_indicador.setLista_ods(lista_ods);
		
		String sql_select = "select indicador_id, ods_id from indicador_ods where indicador_id = ? ";
		try
		{   
			conmysql = new ConnectionMySQL();
			conn = conmysql.getConn();
			ps = conn.prepareStatement(sql_select);
			ps.setInt(1,p_indicador.getId());
			rs = ps.executeQuery();
			rs.beforeFirst();
			while (rs.next())
			{
				int aux_id = rs.getInt(2);
				
				ods_aux = new ODS(aux_id);
				p_indicador.getLista_ods().add(ods_aux);
			}
			//System.out.println("Indicador setLista_ODS(Indicador p_indicador)" + lista_variables.size());
			rs.close();
		}
		catch(Exception e)
		{
			System.out.println("Indicador setLista_ODS(Indicador p_indicador):" + e.getMessage());
		}
	}
	
	public boolean modificarListaODS(int p_id, String[] p_lista_ods)
	{
		boolean return_ = false;
		this.eliminarListaODS(p_id);
		
		String sql_update = " insert into indicador_ods(indicador_id,ods_id) "
						  + " values (?,?) ";
		
		for(int i = 0; i < p_lista_ods.length; i++)
		{
			try
			{   
				conmysql = new ConnectionMySQL();
				conn = conmysql.getConn();
				
				ps = conn.prepareStatement(sql_update);
				ps.setInt(1,p_id);
				ps.setInt(2,Integer.parseInt(p_lista_ods[i]));
				
				int result_update = ps.executeUpdate();
				
				ps.close();
				
				return_ = true;
			}
			catch(Exception e)
			{
				System.out.println("Indicador modificarListaODS(int p_id, String[] p_lista_ods):" + e.getMessage());
				return false;
			}
			
		}	
		
		return return_;
	}
	
	public boolean eliminarListaODS(int p_id)
	{
		Indicador variable = null;
		String sql_delete = " delete from indicador_ods"
						  + " where indicador_id = ?";
		
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
			System.out.println("Indicador eliminarListaEjes_politica_ambiental(int p_id):" + e.getMessage());
			return false;
		}
	}
		
	private void setLista_Areas_Intervencion(Indicador p_indicador)
	{
		ArrayList<Areas_Intervencion> lista_areas_intervencion = new ArrayList();
		Areas_Intervencion area_intervencion_aux;
		p_indicador.setLista_areas_intervencion(lista_areas_intervencion);
		
		String sql_select = "select indicador_id, area_intervencion_id from indicador_politica_ambiental where indicador_id = ? ";
		try
		{   
			conmysql = new ConnectionMySQL();
			conn = conmysql.getConn();
			ps = conn.prepareStatement(sql_select);
			ps.setInt(1,p_indicador.getId());
			rs = ps.executeQuery();
			rs.beforeFirst();
			while (rs.next())
			{
				int aux_id = rs.getInt(2);
				area_intervencion_aux = new Areas_Intervencion(aux_id);
				p_indicador.getLista_areas_intervencion().add(area_intervencion_aux);
			}
			//System.out.println("Indicador setLista_Areas_Intervencion(Indicador p_indicador)" + lista_variables.size());
			rs.close();
		}
		catch(Exception e)
		{
			System.out.println("Indicador setLista_Areas_Intervencion(Indicador p_indicador):" + e.getMessage());
		}
	}
	
	public boolean modificarListaAreas_intervencion(int p_id, String[] p_lista_areas_intervencion)
	{
		boolean return_ = false;
		this.eliminarListaArea_intervencion(p_id);
		
		String sql_update = " insert into indicador_politica_ambiental(indicador_id,area_intervencion_id) "
						  + " values (?,?) ";
		
		for(int i = 0; i < p_lista_areas_intervencion.length; i++)
		{
			try
			{   
				conmysql = new ConnectionMySQL();
				conn = conmysql.getConn();
				
				ps = conn.prepareStatement(sql_update);
				ps.setInt(1,p_id);
				ps.setInt(2,Integer.parseInt(p_lista_areas_intervencion[i]));
				
				int result_update = ps.executeUpdate();
				
				ps.close();
				
				return_ = true;
			}
			catch(Exception e)
			{
				System.out.println("Indicador modificarListaODS(int p_id, String[] p_lista_ods):" + e.getMessage());
				return false;
			}
			
		}	
		
		return return_;
	}
	
	public boolean eliminarListaArea_intervencion(int p_id)
	{
		Indicador variable = null;
		String sql_delete = " delete from indicador_politica_ambiental"
						  + " where indicador_id = ?";
		
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
			System.out.println("Indicador eliminarListaEjes_politica_ambiental(int p_id):" + e.getMessage());
			return false;
		}
	}
	
	private void setLista_Unidades(Indicador p_indicador)
	{
		ArrayList<Unidad> lista_unidad = new ArrayList();
		Unidad unidad_aux;
		p_indicador.setLista_unidades(lista_unidad);
		
		String sql_select = "select indicador_id, unidad_id from indicador_responsable where indicador_id = ? ";
		try
		{   
			conmysql = new ConnectionMySQL();
			conn = conmysql.getConn();
			ps = conn.prepareStatement(sql_select);
			ps.setInt(1,p_indicador.getId());
			rs = ps.executeQuery();
			rs.beforeFirst();
			while (rs.next())
			{
				int aux_id = rs.getInt(2);
				
				unidad_aux = new Unidad(aux_id);
				p_indicador.getLista_unidades().add(unidad_aux);
			}
			//System.out.println("Indicadors setLista_Unidades(Indicador p_indicador)" + lista_variables.size());
			rs.close();
		}
		catch(Exception e)
		{
			System.out.println("Indicador setLista_Unidades(Indicador p_indicador):" + e.getMessage());
		}
	}
	
	public boolean modificarListaUnidades(int p_id, String[] p_lista_unidades)
	{
		boolean return_ = false;
		this.eliminarListaUnidades(p_id);
		
		String sql_update = " insert into indicador_responsable(indicador_id,unidad_id) "
						  + " values (?,?) ";
		
		for(int i = 0; i < p_lista_unidades.length; i++)
		{
			try
			{   
				conmysql = new ConnectionMySQL();
				conn = conmysql.getConn();
				
				ps = conn.prepareStatement(sql_update);
				ps.setInt(1,p_id);
				ps.setInt(2,Integer.parseInt(p_lista_unidades[i]));
				
				int result_update = ps.executeUpdate();
				
				ps.close();
				
				return_ = true;
			}
			catch(Exception e)
			{
				System.out.println("Indicador modificarListaODS(int p_id, String[] p_lista_ods):" + e.getMessage());
				return false;
			}
			
		}	
		
		return return_;
	}
	
	public boolean eliminarListaUnidades(int p_id)
	{
		Indicador variable = null;
		String sql_delete = " delete from indicador_responsable"
						  + " where indicador_id = ?";
		
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
			System.out.println("Indicador eliminarListaEjes_politica_ambiental(int p_id):" + e.getMessage());
			return false;
		}
	}
	
	public boolean isSeleccionarEjes_politica_ambiental(Ejes_Politica_Ambiental p_eje_politica_ambiental) {
	    
	    boolean isSelected = this.lista_politica_ambiental.stream().anyMatch(e -> e.getId() == p_eje_politica_ambiental.getId());
	
	    return isSelected;
	}
	
	public boolean isSeleccionarArea_intervencion(Areas_Intervencion p_area_intervencion) {
	    
	    boolean isSelected = this.lista_areas_intervencion.stream().anyMatch(e -> e.getId() == p_area_intervencion.getId());
	
	    return isSelected;
	}
	
	public boolean isSeleccionarODS(ODS p_ods) {
	    
	    boolean isSelected = this.lista_ods.stream().anyMatch(e -> e.getId() == p_ods.getId());
	
	    return isSelected;
	}
	
	public boolean isSeleccionarUnidad(Unidad p_unidad) {
	    
	    boolean isSelected = this.lista_unidades.stream().anyMatch(e -> e.getIdUnidad() == p_unidad.getIdUnidad());
	
	    return isSelected;
	}
	
}

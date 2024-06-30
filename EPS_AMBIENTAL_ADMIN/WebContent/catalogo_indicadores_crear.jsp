<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<jsp:include page="head.jsp" />
<body>
	<jsp:include page="maindiv.jsp"/>
	<jsp:include page="sidebar.jsp" />
	<div class="div-formulario">
		<h1>Crear Indicador</h1>
	 	<form action="indicador_controlador?command=create" method="post">
	 	<table>
	 		<tr>
	 			<td><label for="area_geografica">Área Geográfica:</label></td>
	 			<td><select id="areas_geograficas" name="areas_geograficas">
	 			<option value=""> -- Seleccione una opción -- </option>
	 			<c:forEach items="${areas_geograficas}" var="option">
                	<option value="${option.getId()}"><c:out value="${option.getId()} - ${option.getNombre()}"/></option>
            	</c:forEach>
	        	</select></td>
	 		</tr>
	 		<tr>
	 			<td><label for="codigo">Código:</label></td>
	        	<td><input type="text" id="codigo" name="codigo" value="${indicador.getCodigo()}"></td>
	 		</tr>
			<tr>
	 			<td><label for="codigo">Nombre:</label></td>
	        	<td><input type="text" id="nombre" name="nombre" value="${indicador.getNombre()}"></td>
	 		</tr>
	 		<tr>
	 			<td><label for="formula">Fórmula:</label></td>
	        	<td><textarea id="formula" name="formula" rows="4" cols="50">${indicador.getFormula()}</textarea></td>
	 		</tr>
	 		<tr>
	 			<td><label for="unidad_medida">Unidad de Medida:</label></td>
	 			<td><select id="unidades_medida" name="unidad_medida">
	 			<option value=""> -- Seleccione una opción -- </option>
	 			<c:forEach items="${unidades_medida}" var="option">
                	<option value="${option.getId()}"><c:out value="${option.getId()} - ${option.getNombre()}"/></option>
            	</c:forEach>
	        	</select></td>
	 		</tr>
	 		<tr>
	 			<td><label for="lista_periodicidad">Periodicidad:</label></td>
	 			<td><select id="lista_periocidad" name="periocidades">
	 			<option value=""> -- Seleccione una opción -- </option>
	 			<c:forEach items="${lista_periodicidad}" var="option">
                	<option value="${option.getId()}"><c:out value="${option.getId()} - ${option.getNombre()}"/></option>
            	</c:forEach>
	        	</select></td>
	 		</tr>
	 		<tr>
	 			<td><label for="ejes politicas ambientales">Eje de la Política Ambiental:</label></td>
	 			<td><select id="ejes_politicas_ambientales" name="ejes_politicas_ambientales" multiple>
	            <option value=""> -- Seleccione una opción -- </option>
	 			<c:forEach items="${ejes_politicas_ambientales}" var="option">
                	<option value="${option.getId()}"><c:out value="${option.getId()} - ${option.getNombre()}"/></option>
            	</c:forEach>
	        	</select></td>
	 		</tr>
	 		<tr>
	 			<td><label for="politica ambiental asociada">Politica Ambiental Asociada:</label></td>
	 			<td><select id="areas_intervencion" name="areas_intervencion" multiple>
	            <option value=""> -- Seleccione una opción -- </option>
	 			<c:forEach items="${areas_intervencion}" var="option">
                	<option value="${option.getId()}"><c:out value="${option.getId()} - ${option.getNombre()}"/></option>
            	</c:forEach>
	        	</select></td>
	 		</tr>
	 		<tr>
	 			<td><label for="ods">ODS Vinculado: </label></td>
	 			<td><select id="ods_s" name="ods_s" multiple>
	            <option value=""> -- Seleccione una opción -- </option>
	 			<c:forEach items="${ods_s}" var="option">
                	<option value="${option.getId()}"><c:out value="${option.getId()} - ${option.getNombre()}"/></option>
            	</c:forEach>
	        	</select></td>
	 		</tr>
	 		<tr>
	 			<td><label for="Unidades_responsable">Unidad Responsable: </label></td>
	 			<td><select id="unidades" name="unidades" multiple>
	            <option value=""> -- Seleccione una opción -- </option>
	 			<c:forEach items="${unidades}" var="option">
                	<option value="${option.getIdUnidad()}"><c:out value="${option.getIdUnidad()} - ${option.getNombre()}"/></option>
            	</c:forEach>
	        	</select></td>
	 		</tr>
	 		<tr>
	 			<td><label for="descripcion">Descripción:</label></td>
	 			<td><input type="text" id="descripcion" name="descripcion"><br><br></td>
	 		</tr>
	 		<tr>
	 			<td></td>
	 			<td><button class="button button4" type="submit" id="btncreate" name="btncreate">Ingresar</button></td>
	 		</tr>
	 	</table>
    	</form>
 	</div>
		<form action="variable_controlador" method="get">
 	 	<div class="div-return">
 			<button class="button button5" onclick="window.location.href='indicador_controlador?command=showAll'">Catalogo de Indicadores<i class="fa fa-arrow-circle-right" aria-hidden="true"></i>
 			</button>
 		</form>
 	</div>
 	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
 	<script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.13/js/select2.min.js"> </script>
 	<script>
	 	$(document).ready(function() {
	 	    $('#ejes_politicas_ambientales').select2({
	 	        placeholder: "Seleccione las opciones necesarias",
	 	        allowClear: true, // Optional: Add a clear button
	 	    });
	 	});
	 	
	 	$(document).ready(function() {
	 	    $('#areas_intervencion').select2({
	 	        placeholder: "Seleccione las opciones necesarias",
	 	        allowClear: true, // Optional: Add a clear button
	 	    });
	 	});
	 	
	 	$(document).ready(function() {
	 	    $('#ods_s').select2({
	 	        placeholder: "Seleccione las opciones necesarias",
	 	        allowClear: true, // Optional: Add a clear button
	 	    });
	 	});
	 	
	 	$(document).ready(function() {
	 	    $('#unidades').select2({
	 	        placeholder: "Seleccione las opciones necesarias",
	 	        allowClear: true, // Optional: Add a clear button
	 	    });
	 	});
	 	
	    // Use jQuery to listen for changes in the dropdown
	    $(document).ready(function() {
	        $('#areas_geograficas').change(function() {
	            // Get the selected value from the dropdown
	            var selectedValue = $(this).val();

	            // Make an asynchronous request to the servlet
	            $.ajax({
	                type: 'GET',
	                url: 'variable_controlador?command=newId&id=' + selectedValue, // Replace with the actual servlet URL
	                data: { areaGeograficaId: selectedValue },
	                success: function(response) {
	                    // Update the value in the codigo input field with the response
	                    $('#codigo').val(response);
	                },
	                error: function() {
	                    console.error('Error fetching data from the servlet');
	                }
	            });
	        });
	    });
 	</script>
</body>
</html>
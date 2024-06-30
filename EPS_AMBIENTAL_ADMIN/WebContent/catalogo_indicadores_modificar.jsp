<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<jsp:include page="head.jsp" />
<body>
	<jsp:include page="maindiv.jsp"/>
	<jsp:include page="sidebar.jsp" />
	<div class="div-formulario">
		<h1>Modificar Indicador</h1>
	 	<form action="indicador_controlador?command=edit" method="post">
	 	<table>
	 		<tr>
	 			<td><input type="hidden" id="id" name="id" value="${indicador.getId()}"></td>
	 		</tr>
	 		<tr>
	 			<td><input type="hidden" id="area_geografica" name="area_geografica" value="${indicador.getArea_geografica_id()}" readonly></td>
	 		</tr>
	 		<tr>
	 			<td><label for="areas_geografica">Área Geográfica:</label></td>
	 			<td><select id="areas_geograficas" name="areas_geograficas" disabled="true">
	 			<option value=""> -- Seleccione una opción -- </option>
	 			<c:forEach items="${areas_geograficas}" var="option">
                	<c:choose>
                    	<c:when test="${option.getId() == indicador.getArea_geografica_id()}">
                        	<option value="${option.getId()}" selected><c:out value="${option.getId()} - ${option.getNombre()}"/></option>
                    	</c:when>
                    	<c:otherwise>
                       		<option value="${option.getId()}"><c:out value="${option.getId()} - ${option.getNombre()}"/></option>
                    	</c:otherwise>
                	</c:choose>
            	</c:forEach>
	        	</select></td>
	 		</tr>
	 		<tr>
	 			<td><label for="codigo">Código:</label></td>
	        	<td><input type="text" id="codigo" name="codigo" value="${indicador.getCodigo()}" readonly></td>
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
	 			<td><select id="unidades_medida" name="unidades_medida">
	 			<option value=""> -- Seleccione una opción -- </option>
	 			<c:forEach items="${unidades_medida}" var="option">
                	<c:choose>
                    	<c:when test="${option.getId() == indicador.getUnidad_medida_id()}">
                        	<option value="${option.getId()}" selected><c:out value="${option.getId()} - ${option.getNombre()}"/></option>
                    	</c:when>
                    	<c:otherwise>
                       		<option value="${option.getId()}"><c:out value="${option.getId()} - ${option.getNombre()}"/></option>
                    	</c:otherwise>
                	</c:choose>
            	</c:forEach>
	        	</select></td>
	 		</tr>
	 		<tr>
	 			<td><label for="lista_periodicidad">Periodicidad:</label></td>
	 			<td><select id="lista_periodicidad" name="lista_periodicidad">
	 			<option value=""> -- Seleccione una opción -- </option>
	 			<c:forEach items="${lista_periodicidad}" var="option">
                	<c:choose>
                    	<c:when test="${option.getId() == indicador.getPeriocidad_id()}">
                        	<option value="${option.getId()}" selected><c:out value="${option.getId()} - ${option.getNombre()}"/></option>
                    	</c:when>
                    	<c:otherwise>
                       		<option value="${option.getId()}"><c:out value="${option.getId()} - ${option.getNombre()}"/></option>
                    	</c:otherwise>
                	</c:choose>
            	</c:forEach>
	        	</select></td>
	 		</tr>
	 		<tr>
	 			<td><label for="ejes politicas ambientales">Eje de la Política Ambiental:</label></td>
	 			<td><select id="ejes_politicas_ambientales" name="ejes_politicas_ambientales" multiple>
	            <option value=""> -- Seleccione una opción -- </option>
	 			<c:forEach items="${ejes_politicas_ambientales}" var="option">
                	<c:choose>
                    	<c:when test="${indicador.isSeleccionarEjes_politica_ambiental(option)}">
                        	<option value="${option.getId()}" selected><c:out value="${option.getId()} - ${option.getNombre()}"/></option>
                    	</c:when>
                    	<c:otherwise>
                       		<option value="${option.getId()}"><c:out value="${option.getId()} - ${option.getNombre()}"/></option>
                    	</c:otherwise>
                	</c:choose>
            	</c:forEach>
	        	</select></td>
	 		</tr>
	 		<tr>
	 			<td><label for="politica ambiental asociada">Politica Ambiental Asociada:</label></td>
	 			<td><select id="areas_intervencion" name="areas_intervencion" multiple>
	            <option value=""> -- Seleccione una opción -- </option>
	 			<c:forEach items="${areas_intervencion}" var="option">
                	<c:choose>
                    	<c:when test="${indicador.isSeleccionarArea_intervencion(option)}">
                        	<option value="${option.getId()}" selected><c:out value="${option.getId()} - ${option.getNombre()}"/></option>
                    	</c:when>
                    	<c:otherwise>
                       		<option value="${option.getId()}"><c:out value="${option.getId()} - ${option.getNombre()}"/></option>
                    	</c:otherwise>
                	</c:choose>
            	</c:forEach>
	        	</select></td>
	 		</tr>
	 		<tr>
	 			<td><label for="ods">ODS Vinculado: </label></td>
	 			<td><select id="ods_s" name="ods_s" multiple>
	            <option value=""> -- Seleccione una opción -- </option>
	 			<c:forEach items="${ods_s}" var="option">
                	<c:choose>
                    	<c:when test="${indicador.isSeleccionarODS(option)}">
	                        <option value="${option.getId()}" selected>
	                            <c:out value="${option.getId()} - ${option.getNombre()}"/>
	                        </option>
                    	</c:when>
                    	<c:otherwise>
                       		<option value="${option.getId()}"><c:out value="${option.getId()} - ${option.getNombre()}"/></option>
                    	</c:otherwise>
                	</c:choose>
            	</c:forEach>
	        	</select></td>
	 		</tr>
	 		<tr>
	 			<td><label for="Unidades_responsable">Unidad Responsable: </label></td>
	 			<td><select id="unidades" name="unidades" multiple>
	            <option value=""> -- Seleccione una opción -- </option>
	 			<c:forEach items="${unidades}" var="option">
                	<c:choose>
                    	<c:when test="${indicador.isSeleccionarUnidad(option)}">
                        	<option value="${option.getIdUnidad()}" selected><c:out value="${option.getIdUnidad()} - ${option.getNombre()}"/></option>
                    	</c:when>
                    	<c:otherwise>
                       		<option value="${option.getIdUnidad()}"><c:out value="${option.getIdUnidad()} - ${option.getNombre()}"/></option>
                    	</c:otherwise>
                	</c:choose>
            	</c:forEach>
	        	</select></td>
	 		</tr>
	 		<tr>
	 			<td><label for="descripcion">Descripción:</label></td>
	 			<td><input type="text" id="descripcion" name="descripcion" value="${indicador.getDescripcion()}"><br><br></td>
	 		</tr>
	 		<tr>
	 			<td></td>
	 				<td><button class="button button4" type="submit" id="btnedit" name="btnedit"">Modificar</button></td>
	 		</tr>
	 	</table>
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
 	</script>
</body>
</html>
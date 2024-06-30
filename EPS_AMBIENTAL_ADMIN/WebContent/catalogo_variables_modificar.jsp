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
		<h1>Modificar Variable</h1>
	 	<form action="variable_controlador?command=edit" method="post">
	 	<table>
	 		<tr>
	 			<td><input type="hidden" id="id" name="id" value="${variable.getId()}"></td>
	 		</tr>
	 		<tr>
	 			<td><label for="area_geografica">Área Geográfica:</label></td>
	 			<td><select id="areas_geograficas" name="areas_geograficas">
	 			<option value=""> -- Seleccione una opción -- </option>
	 			<c:forEach items="${areas_geograficas}" var="option">
                	<c:choose>
                    	<c:when test="${option.getId() == variable.getArea_geografica_id()}">
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
	 			<td><label for="areas_intervencion">Área de Intervención:</label></td>
	 			<td><select id="areas_intervencion" name="areas_intervencion">
	            <option value=""> -- Seleccione una opción -- </option>
	 			<c:forEach items="${areas_intervencion}" var="option">
	 				<c:choose>
                    	<c:when test="${option.getId() == variable.getArea_intervencion_id()}">
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
	 			<td><label for="periodicidad">Periodicidad:</label></td>
	 			<td><select id="periodicidad" name="periodicidad">
	            <option value=""> -- Seleccione una opción -- </option>
	 			<c:forEach items="${lista_periodicidad}" var="option">
	 				 <c:choose>
                    	<c:when test="${option.getId() == variable.getPeriocidad_id()}">
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
	        	<td><input type="text" id="codigo" name="codigo" value="${variable.getCodigo()}" readonly></td>
	 		</tr>
	 		<tr>
	 			<td><label for="codigo">Nombre:</label></td>
	        	<td><input type="text" id="nombre" name="nombre" value="${variable.getNombre()}"></td>
	 		</tr>
	 		<tr>
	 			<td><label for="descripcion">Descripción:</label></td>
	 			<td><input type="text" id="descripcion" name="descripcion" value="${variable.getDescripcion()}"><br><br></td>
	 		</tr>
	 		<tr>
	 			<td></td>
	 			<td><button class="button button4" type="submit" id="btnedit" name="btnedit">Modificar</button></td>
	 		</tr>
	 	</table>
    	</form>
 	</div>
</body>
</html>
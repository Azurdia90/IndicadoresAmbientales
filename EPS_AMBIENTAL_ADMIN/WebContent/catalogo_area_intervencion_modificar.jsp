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
		<h1>Modificar Área Intervención</h1>
	 	<form action="areas_intervencion_controlador?command=edit" method="post">
		 	<table>
		 		<tr>
		 			<td><input type="hidden" id="id" name="id" value="${area_intervencion.getId()}"></td>
		 		</tr>
		 		<tr>
		 			<td><label for="codigo">Código:</label></td>
		        	<td><input type="text" id="codigo" name="codigo" value="${area_intervencion.getCodigo()}" readonly></td>
		 		</tr>
		 		<tr>
		 			<td><label for="nombre">Nombre:</label></td>
		        	<td><input type="text" id="nombre" name="nombre" value="${area_intervencion.getNombre()}"></td>
		 		</tr>
		 		<tr>
		 			<td><label for="area_geografica">Área Geográfica:</label></td>
		 			<td><select id="areas_geograficas" name="areas_geograficas">
		 			<option value=""> -- Seleccione una opción -- </option>
		 			<c:forEach items="${areas_geograficas}" var="option">
	                	<c:choose>
	                    	<c:when test="${option.getId() == area_intervencion.getArea_geografica_id()}">
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
		 			<td><label for="descripcion">Descripcion:</label></td>
		        	<td><input type="text" id="descripcion" name="descripcion" value="${area_intervencion.getDescripcion()}"></td>
		 		</tr>	 
		 		<tr>
		 			<td></td>
					<td><button class="button button4" type="submit" id="btnedit" name="btnedit" value=>Modificar</button></td>
		 		</tr>
		 	</table>
    	</form>
 	</div>
</body>
</html>
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
		<h1>Crear Variable</h1>
	 	<form action="variable_controlador?command=create" method="post">
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
		 			<td><label for="area_intervencion">Área de Intervención:</label></td>
		 			<td><select id="areas_intervencion" name="areas_intervencion">
		 				<option value=""> -- Seleccione una opción -- </option>
						<c:forEach items="${areas_intervencion}" var="option">
                       		<option value="${option.getId()}"><c:out value="${option.getId()} - ${option.getNombre()}"/></option>
            			</c:forEach>
		        	</select></td>
		 		</tr>
		 		<tr>
		 			<td><label for="lista_periodicidad">Periodicidad:</label></td>
		 			<td><select id="lista_periodicidad" name="lista_periodicidad">
		 				<option value=""> -- Seleccione una opción -- </option>
						<c:forEach items="${lista_periodicidad}" var="option">
                       		<option value="${option.getId()}"><c:out value="${option.getId()} - ${option.getNombre()}"/></option>
            			</c:forEach>
		        	</select></td>
		 		</tr>
		 		<tr>
		 			<td><label for="codigo">Código:</label></td>
		        	<td><input type="text" id="codigo" name="codigo" value="${codigo}" readonly></td>
		 		</tr>
		 		<tr>
		 			<td><label for="codigo">Nombre:</label></td>
		        	<td><input type="text" id="nombre" name="nombre" value=""></td>
		 		</tr>
		 		
		 		<tr>
		 			<td><label for="descripcion">Descripción:</label></td>
		 			<td><input type="text" id="descripcion" name="descripcion"><br><br></td>
		 		</tr>
		 		<tr>
		 			<td></td>
		 			<td><button class="button button4" type="submit" id="btncreate" name="btncreate">Crear</button></td>
		 		</tr>
		 	</table>
    	</form>
 	</div>
 	<div class="div-return">
 		<button class="button button5" onclick="window.location.href='variable_controlador?command=showAll'">Catalogo de Variables<i class="fa fa-arrow-circle-right" aria-hidden="true"></i>
 	</button>
 	</div>
</body>
</html>
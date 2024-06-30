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
		<h1>Crear ODS</h1>
	 	<form action="ods_controlador?command=create" method="post">
	 	<table>
	 		<tr>
	 			<td><label for="codigo">Código:</label></td>
	        	<td><input type="text" id="codigo" name="codigo" value="${codigo}" readonly></td>
	 		</tr>
	 		<tr>
	 			<td><label for="nombre">Nombre:</label></td>
	        	<td><input type="text" id="nombre" name="nombre"></td>
	 		</tr>
	 		<tr>
	 			<td><label for="descripcion">Descripcion:</label></td>
	        	<td><input type="text" id="descripcion" name="descripcion"></td>
	 		</tr>
	 		<tr>
	 			<td></td>
	 			<td><button class="button button4" type="submit" id="btncreate" name="btncreate" value=>Ingresar</button></td>
	 		</tr>
	 	</table>
    	</form>
 	</div>
 	<div class="div-return">
		<button class="button button5" onclick="window.location.href='ods_controlador?command=showAll'">Catalogo de ODS<i class="fa fa-arrow-circle-right" aria-hidden="true"></i>
		</button>
	</div>
</body>
</html>
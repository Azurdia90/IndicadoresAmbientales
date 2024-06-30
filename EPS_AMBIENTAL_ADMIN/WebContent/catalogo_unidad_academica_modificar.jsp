<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<jsp:include page="head.jsp" />
<body>
	<jsp:include page="maindiv.jsp"/>
	<jsp:include page="sidebar.jsp" />
	<div class="div-formulario">
		<h1>Unidad Académica</h1>
		<form action="unidad_controlador?command=edit" method="post">
		 	<table>
		 		<tr>
		 			<td><label for="id">Id:</label></td>
		        	<td><input type="text" id="id" name="id" value="${unidad.getIdUnidad()}"></td>
		 		</tr>
		 		<tr>
		 			<td><label for="nombre">Nombre:</label></td>
		        	<td><input type="text" id="nombre" name="nombre" value="${unidad.getNombre()}"></td>
		 		</tr>
		 		<tr>
		 			<td><label for="tipo">Tipo:</label></td>
		        	<td><input type="text" id="tipo" name="tipo" value="${unidad.getTipo()}"></td>
		 		</tr>
		 		<tr>
		 			<td></td>
					<td><button class="button button4" type="submit" id="btnedit" name="btnedit" >Modificar</button></td>
		 		</tr>
		 	</table>
		 </form>
 	</div>
</body>
</html>
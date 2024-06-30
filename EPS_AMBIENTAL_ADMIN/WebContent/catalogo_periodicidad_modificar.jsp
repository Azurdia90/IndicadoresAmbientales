<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<jsp:include page="head.jsp" />
<body>
	<jsp:include page="maindiv.jsp"/>
	<jsp:include page="sidebar.jsp" />
	<div class="div-formulario">
		<h1>Modificar Periodicidad</h1>
		<form action="periodicidad_controlador?command=edit" method="post">
		 	<table>
		 		<tr>
		 			<td><input type="hidden" id="id" name="id" value="${periodicidad.getId()}"></td>
		 		</tr>
		 		<tr>
		 			<td><label for="codigo">Código:</label></td>
		        	<td><input type="text" id="codigo" name="codigo" value="${periodicidad.getCodigo()}" readonly></td>
		 		</tr>
		 		<tr>
		 			<td><label for="nombre">Nombre:</label></td>
		        	<td><input type="text" id="nombre" name="nombre" value="${periodicidad.getNombre()}"></td>
		 		</tr>
		 		<tr>
	 				<td><label for="descripcion">Descripcion:</label></td>
	        		<td><input type="text" id="descripcion" name="descripcion" value="${periodicidad.getDescripcion()}"></td>
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
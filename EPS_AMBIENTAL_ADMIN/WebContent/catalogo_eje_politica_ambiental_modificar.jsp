<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<jsp:include page="head.jsp" />
<body>
	<jsp:include page="maindiv.jsp"/>
	<jsp:include page="sidebar.jsp" />
	<div class="div-formulario">
		<h1>Modificar Eje de politica ambiental</h1>
		<form action="ejes_politica_ambiental_controlador?command=edit" method="post">
		 	<table>
		 		<tr>
		 			<td><input type="hidden" id="id" name="id" value="${eje_politica_ambiental.getId()}"></td>
		 		</tr>
		 		<tr>
		 			<td><label for="codigo">Código:</label></td>
		        	<td><input type="text" id="codigo" name="codigo" value="${eje_politica_ambiental.getCodigo()}" readonly></td>
		 		</tr>
		 		<tr>
		 			<td><label for="nombre">Nombre:</label></td>
		        	<td><input type="text" id="nombre" name="nombre" value="${eje_politica_ambiental.getNombre()}"></td>
		 		</tr>
		 		<tr>
	 				<td><label for="descripcion">Descripcion:</label></td>
	        		<td><input type="text" id="descripcion" name="descripcion" value="${eje_politica_ambiental.getDescripcion()}"></td>
	 			</tr>	
		 		<tr>
		 			<td></td>
					<td><button class="button button4" type="submit" id="btnedit" name="btnedit" >Modificar</button></td>
		 		</tr>
		 	</table>
		 </form>
 	</div>
 	<div class="div-return">
		<button class="button button5" onclick="window.location.href='ejes_politica_ambiental_controlador?command=showAll'">Eje de politica ambiental<i class="fa fa-arrow-circle-right" aria-hidden="true"></i>
		</button>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<jsp:include page="head.jsp" />
<body>
	<jsp:include page="maindiv.jsp"/>
	<jsp:include page="sidebar.jsp" />

	<div class = "div-menu-formulario">
		<form action="indicador_controlador" method="get">
		 	<label>Catalogo de Indicadores</label>
			<button class="button button1" type="submit" name="command" value="create">Crear Indicador</button>
		 	<button class="button button1">Ver catalago</button>
		 	<button class="button buttonback" onclick="history.back()">Regresar</button>
	 	</form>
 	</div>
 	<hr>
 	<div class ="div-buscar">
 		<form action="">
 			<label for="gsearch">Buscar:</label>
  			<input type="search" id="gsearch" name="gsearch">
		</form>
 	</div>
 	<br><br><br>
 	<div class="div-tabla-indicadores">	
		<%
		    // Datos de ejemplo
		    int totalRegistros = 100; // Número total de registros
		    int registrosPorPagina = 10; // Número de registros por página
		    int paginaActual = (request.getParameter("pagina") != null) ? Integer.parseInt(request.getParameter("pagina")) : 1;
		    int totalPaginas = (int) Math.ceil((double) totalRegistros / registrosPorPagina);
		
		    // Cálculos para la paginación
		    int primerRegistro = (paginaActual - 1) * registrosPorPagina;
		    int ultimoRegistro = Math.min(primerRegistro + registrosPorPagina, totalRegistros);
		%>
		
		<table border="1" class="tableindicadores">
		    <tr>
		        <th>Área Geografica</th>
		        <th>Código</th>
		        <th>Nombre</th>
		        <th>Unidad de médida</th>
		        <th>Periodicidad</th>
		        <th>Descripción</th>
		        <th>Acciones</th>
		    </tr>
		     <c:forEach items="${indicadores}" var="indicador" >
	            <tbody>
	            	<tr data-variable-id="${indicador.getId()}">
	            		<td><c:out value="${indicador.getArea_geografica_nombre()}"/></td>
		                <td><c:out value="${indicador.getCodigo()}"/></td>
		                <td><c:out value="${indicador.getNombre()}"/></td>
		                <td><c:out value="${indicador.getUnidad_medida_nombre()}"/></td>
		                <td><c:out value="${indicador.getPeriodicidad_nombre()}"/></td>
		                <td><c:out value="${indicador.getDescripcion()}"/></td>
		                <td align="center">
		                	<input class="button button2"  type="button" id="btnedit" name="btnedit" value="Modificar"></input>
		                	&nbsp;
		                	<input class="button button3"  type="button" id="btndelete" name="btndelete" value="Eliminar"></input>			
		                </td>
		            </tr>
	            </tbody>
			</c:forEach>
			
		</table>
		
		<div class="pagination">
		    <a href="#">Anterior</a>
		     <% for (int i = 1; i <= totalPaginas; i++) { %>
		     	<%if (paginaActual == i) { %>
					<a href="#" class="active"><%= paginaActual %></a>
			    <% } else {%>
		    	 	<a href="#"><%= i %></a>
		    	 <% } %>	
		     <% } %>
		   <a href="#">Siguiente</a>
		</div>
 	</div>
 	
<script>
    document.addEventListener("DOMContentLoaded", function () {
        var editbuttons = document.querySelectorAll("[name=btnedit]");
        var deletebuttons = document.querySelectorAll("[name=btndelete]");

        editbuttons.forEach(function (edit_button) {
            edit_button.addEventListener("click", function () {
                // Find the parent row of the clicked edit button
                var row = edit_button.closest("tr");

                // Get the data-variable-id attribute from the row
                var variableId = row.getAttribute("data-variable-id");

                window.location.href = "indicador_controlador?command=edit&id=" + variableId;
            });
        });

        deletebuttons.forEach(function (delete_button) {
            delete_button.addEventListener("click", function () {
                // Find the parent row of the clicked delete button
                var row = delete_button.closest("tr");

                // Get the data-variable-id attribute from the row
                var variableId = row.getAttribute("data-variable-id");

                // Send a POST request to delete the item
                fetch("indicador_controlador?command=delete&id=" + variableId, {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/x-www-form-urlencoded",
                    },
                    body: "command=delete&id=" + variableId,
                })
                .then(function(response) {
                    if (response.ok) {
                        // Handle success, e.g., remove the row from the table
                        row.remove();
                    } else {
                        // Handle errors
                        console.error("Failed to delete item.");
                    }
                })
                .catch(function(error) {
                    console.error("Error:", error);
                });
            });
        });
    });
</script> 	
 	
</body>
</html>
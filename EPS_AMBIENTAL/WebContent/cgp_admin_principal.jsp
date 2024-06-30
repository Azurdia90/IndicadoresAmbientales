<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="head.jsp" />
</head>
<body>
	<div class="scroll-container">
		<div class="navbar">
			<img src="${menu_logo}" alt="img"></img>
		</div>
		<div class="scroll-page" id="page-1">
			<div class="container">
				<div class="paginaPrincipal" id="paginaAdmin">
					<c:if test="${not empty paginas}">
						<table id="tableAdmin">
							<tr>
								<th>Código</th>
								<th>Título</th>
								<th>Acciones</th>
							</tr>
							<c:forEach items="${paginas}" var="pagina" varStatus="loop">
								<tbody>
									<tr data-variable-id="${pagina.getId()}">
										<td id="tdcodigo"><c:out value="${pagina.getCodigo()}" /></td>
										<td><c:out value="${pagina.getNombre()}" /></td>
										<td id="accionesTBAdmin"><input class="button1"
											type="button" id="btnedit" name="btnedit" value="Modificar"></input>
											&nbsp; <input class="button2" type="button" id="btnvisible"
											name="btnvisible" value="Visible"></input></td>
									</tr>
								</tbody>
							</c:forEach>
						</table>
					</c:if>
				</div>
			</div>
		</div>
	</div>
	<script>
	    document.addEventListener("DOMContentLoaded", function () {
	        var editbuttons = document.querySelectorAll("[name=btnedit]");
	        var deletebuttons = document.querySelectorAll("[name=btnvisible]");
	
	        editbuttons.forEach(function (edit_button) {
	            edit_button.addEventListener("click", function () {
	                // Find the parent row of the clicked edit button
	                var row = edit_button.closest("tr");
	
	                // Get the data-variable-id attribute from the row
	                var variableId = row.getAttribute("data-variable-id");
	
	                window.location.href = "admin_controller?command=edit&id=" + variableId;
	            });
	        });
	
	        deletebuttons.forEach(function (delete_button) {
	            delete_button.addEventListener("click", function () {
	                // Find the parent row of the clicked delete button
	                var row = delete_button.closest("tr");
	
	                // Get the data-variable-id attribute from the row
	                var variableId = row.getAttribute("data-variable-id");
	
	                // Send a POST request to delete the item
	                fetch("ods_controlador?command=delete&id=" + variableId, {
	                    method: "DELETE",
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="head.jsp" />
<body>
	<div class="scroll-container">
		<div class="scroll-page" id="page-1">
			<div class="container">
				<jsp:include page="main_menu.jsp" />
				<c:if test="${not empty header_image}">
					<jsp:include page="header_image.jsp" />
				</c:if>
			</div>
		</div>
		<c:if test="${not empty secciones}">
		<hr size="2vw" color="#0C6B3E" style="width: 90%; text-align: center;" />
		<div class="scroll-page" id="page-2">
			<div class="container">
				<c:forEach items="${secciones}" var="seccion" varStatus="loop">
				<c:if test="${seccion.getTipo() == 1}">
				<div class="${seccion.getClase_css()}">
					<img src="${seccion.getPath_image()}">
					<h1>${seccion.getTitulo()}</h1>
					<h3>${seccion.getTexto()}</h3>
				</div>
				</c:if>
				</c:forEach>
			</div>
		</div>
		</c:if>
		<jsp:include page="footer.jsp" />
	</div>
	<script src="js/menu.js"></script>
</body>
</html>
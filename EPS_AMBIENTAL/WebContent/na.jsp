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
		<hr size="2vw" color="#0C6B3E" style="width: 90%; text-align: center;" />
		<div class="scroll-page" id="page-2">
			<div class="container">
				<div class="section3">
					<c:if test="${secciones.size() > 0}">
						<div class="${secciones[0].getClase_css()}">
							<img src="${secciones[0].getPath_image()}">
							<h1>${secciones[0].getTitulo()}</h1>
							<h3>${secciones[0].getTexto()}</h3>
						</div>
					</c:if>
				</div>
			</div>
		</div>
		<hr size="2vw" color="#0C6B3E" style="width: 90%; text-align: center;" />
		<div class="scroll-page" id="page-3">
			<div class="container">
				<div class="section3">
					<c:if test="${not empty secciones}">
						<c:if test="${secciones.size() > 1}">
							<c:forEach items="${secciones}" var="seccion" begin="1"
								varStatus="loop">
								<div class="${seccion.getClase_css()}">
									<img src="${seccion.getPath_image()}">
									<h1>${seccion.getTitulo()}</h1>
									<h3>${seccion.getTexto()}</h3>
									<a href="${seccion.getEnlace()}" download><button>
											<i class="fa fa-download"> DESCARGAR</i>
										</button></a>
								</div>
							</c:forEach>
						</c:if>
					</c:if>
				</div>
			</div>
		</div>
		<hr size="2vw" color="#0C6B3E" style="width: 90%; text-align: center;" />
		<div class="scroll-page" id="page-2">
			<div class="container">
				<div class="section3">
					<c:if test="${not empty secciones.size()}">
						<div class="${secciones[0].getClase_css()}">
							<img src="${secciones[0].getPath_image()}">
							<h1>${secciones[0].getTitulo()}</h1>
							<h3>${secciones[0].getTexto()}</h3>
						</div>
					</c:if>
				</div>
			</div>
		</div>
		<hr size="2vw" color="#0C6B3E" style="width: 90%; text-align: center;" />
		<div class="scroll-page" id="page-3">
			<div class="container">
				<c:if test="${secciones.size() > 1}">
					<div class="${secciones[1].getClase_css()}">
						<table>
							<tr>
								<c:forEach items="${secciones}" var="seccion" begin="1"
									varStatus="loop">
									<td><img src="${seccion.getPath_image()}" id="img7"></td>
								</c:forEach>
							</tr>
							<tr>
								<c:forEach items="${secciones}" var="seccion" begin="1"
									varStatus="loop">
									<td style="height: 0.5vw;"><h2>${seccion.getTitulo()}</h2></td>
								</c:forEach>
							</tr>
							<tr>
								<c:forEach items="${secciones}" var="seccion" begin="1"
									varStatus="loop">
									<td style="height: 1vw;"><h2>${seccion.getTexto()}</h2></td>
								</c:forEach>
							</tr>
						</table>
					</div>
				</c:if>
			</div>
		</div>
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>
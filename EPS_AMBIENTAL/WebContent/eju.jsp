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
				<c:if test="${not empty menus}">
					<div class="${menus[0].getClase_css()}">
						<h1>${menus[0].getTitulo()}</h1>
						<table>
							<tbody>
								<c:forEach items="${menus[0].getLista_secciones()}"
									var="seccion" varStatus="loop">
									<c:if test="${loop.index % 4 == 0}">
										<tr>
									</c:if>
									<td><a
										href="${empty seccion.getEnlace() ? '#' : seccion.getEnlace()}"">
											<img src="${seccion.getPath_image()}"
											alt="${seccion.getTexto()}" />
									</a>
										<div class="text-below">${seccion.getTexto()}</div></td>
									<c:if test="${loop.index % 4 == 3 or loop.last}">
										</tr>
									</c:if>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</c:if>
			</div>
		</div>

		<div class="scroll-page" id="page-3">
			<div class="container">
				<div>
					<img class="header_image" src="assets/images/DJI_0035.JPG"></img>
					<div class="header_text">OBJETIVOS DE DESARROLLO SOSTENIBLE</div>
				</div>
			</div>
		</div>
		<hr size="2vw" color="#0C6B3E" style="width: 90%; text-align: center;" />
		<div class="scroll-page" id="page-4">
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
		<div class="scroll-page" id="page-5">
			<div class="container">
				<c:if test="${not empty menus}">
					<div class="${menus[1].getClase_css()}">
						<h1>${menus[1].getTitulo()}</h1>
						<table>
							<tbody>
								<c:forEach items="${menus[1].getLista_secciones()}"
									var="seccion" varStatus="loop">
									<c:if test="${loop.index % 4 == 0}">
										<tr>
									</c:if>
									<td><a
										href="${empty seccion.getEnlace() ? '#' : seccion.getEnlace()}"">
											<img src="${seccion.getPath_image()}"
											alt="${seccion.getTexto()}" />
									</a>
										<div class="text-below">${seccion.getTexto()}</div></td>
									<c:if test="${loop.index % 4 == 3 or loop.last}">
										</tr>
									</c:if>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</c:if>
			</div>
		</div>
		<jsp:include page="footer.jsp" />
	</div>
	<script src="js/menu.js"></script>
</body>
</html>
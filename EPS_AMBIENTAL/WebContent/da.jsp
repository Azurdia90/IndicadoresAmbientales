<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
				<div class="section3">
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
		</div>
		</c:if>
		<c:if test="${not empty secciones}">
		<hr size="2vw" color="#0C6B3E" style="width: 90%; text-align: center;" />
		<div class="scroll-page" id="page-3">
			<div class="container">
					<div class="section10">
						<table>
							<tr>
								<c:forEach items="${secciones}" var="seccion" varStatus="loop">
								<c:if test="${seccion.getTipo() == 5}">
                       				<td><img src="${seccion.getPath_image()}" id="img10"></td>
                       			</c:if>
								</c:forEach>
							</tr>
							<tr>
								<c:forEach items="${secciones}" var="seccion" varStatus="loop">
								<c:if test="${seccion.getTipo() == 5}">
									<td style="height: 0.5vw;"><h2>${seccion.getTitulo()}</h2></td>
								</c:if>
								</c:forEach>
							</tr>
							<tr>
								<c:forEach items="${secciones}" var="seccion" varStatus="loop">
								<c:if test="${seccion.getTipo() == 5}">
									<td style="height: 1vw;"><h3>${seccion.getTexto()}</h3></td>
								</c:if>
								</c:forEach>
							</tr>
						</table>
					</div>
				</c:if>
			</div>
		</div>
		<hr size="2vw" color="#0C6B3E" style="width: 90%; text-align: center;" />
		<div class="scroll-page" id="page-4">
			<div class="container">
				<c:if test="${not empty menus}">
					<div class="${menus[0].getClase_css()}">
						<h1>${menus[0].getTitulo()}</h1>
						<table>
							<tbody>
								<c:forEach items="${menus[0].getLista_secciones()}"
									var="seccion" varStatus="loop">
									<c:if test="${loop.index % 3 == 0}">
										<tr>
									</c:if>
									<td><a
										href="${empty seccion.getEnlace() ? '#' : seccion.getEnlace()}">
											<img src="${seccion.getPath_image()}"
											alt="${seccion.getTexto()}" />
									</a>
										<div class="text-below">${seccion.getTexto()}</div></td>
									<c:if test="${loop.index % 3 == 2 or loop.last}">
										</tr>
									</c:if>
								</c:forEach>
							</tbody>
						</table>
						<!-- <table>
							<tbody>
								<tr>
									<td><img src="assets/png/Elementos_celeste/4-06.png"></img></td>
									<td><img src="assets/png/Elementos_celeste/4-08.png"></img></td>
									<td><img src="assets/png/Elementos_celeste/4-10.png"></img></td>
								</tr>
								<tr>
									<td>Manejo de áreas y gestión de riesgo</td>
									<td>Prácticas administrativas, docencia, investigación y extensión en el territorio</td>
									<td>Energía</td>
								</tr>
								<tr>
									<td><img src="assets/png/Elementos_celeste/4-01.png"></img></td>
									<td><img src="assets/png/Elementos_celeste/4-02.png"></img></td>
									<td><img src="assets/png/Elementos_celeste/4-03.png"></img></td>
								</tr>
								<tr>
									<td>Agua</td>
									<td>Consumo Responsable</td>
									<td>Residuos</td>
								</tr>
							</tbody>
						</table> -->
					</div>
				</c:if>
			</div>
		</div>
		<c:if test="${not empty secciones}">
		<hr size="2vw" color="#0C6B3E" style="width: 90%; text-align: center;" />
		<div class="scroll-page" id="page5">
			<div class="container">
				<c:forEach items="${secciones}" var="seccion" varStatus="loop">
				<c:if test="${seccion.getTipo() == 3}">
					<div class="${seccion.getClase_css()}">
						<img src="${seccion.getPath_image()}">
						<h1>${seccion.getTitulo()}</h1>
						<h3>${seccion.getTexto()}</h3>
						<button onclick="${seccion.getEnlace()}" download>IR
							AL ENLACE</button>
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
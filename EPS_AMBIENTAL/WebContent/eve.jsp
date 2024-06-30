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
		<div class="scroll-page" id="page-2">
			<div class="container">
				<c:if test="${ not empty carretes }">
					<c:forEach items="${carretes}" var="carrete" varStatus="loop">
						<div class="${ carrete.getClase_css() }">
							<h1>CALENDARIO DE ACTIVIDADES AMBIENTALES</h1>
							<h5>${ carrete.getTitulo() }</h5>
							<div id="carrusel">
								<a href="#" class="left-arrow"><i class="fa fa-caret-left"></i></a>
								<a href="#" class="right-arrow"><i class="fa fa-caret-right"></i></a>
								<div class="carrusel">
									<c:forEach items="${carrete.getLista_photos()}" var="photo"
										varStatus="loop">
										<div class="${ photo.getClase_css() }" id="product_0">
											<img src="${ photo.getPath_image() }" />
											<c:if test="${ not empty photo.getTexto() }">
												<div class="eventotag">
													<h5>${ photo.getTexto() }</h5>
												</div>
											</c:if>
										</div>
									</c:forEach>
								</div>
							</div>
						</div>
					</c:forEach>
				</c:if>
			</div>
		</div>
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>
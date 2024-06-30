<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				<c:if test="${ not empty carretes }">
					<c:forEach items="${carretes}" var="carrete" varStatus="loop">
						<div class="${ carrete.getClase_css() }">
							<h1>${ carrete.getTitulo() }</h1>
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


				<!-- 				<div id="carrusel">
				    <a href="#" class="left-arrow"><i class="fa fa-caret-left"></i></a>
				    <a href="#" class="right-arrow"><i class="fa fa-caret-right"></i></a>
					<div class="carrusel">
				    	<div class="product" id="product_0">
				            <img src="assets/png/Elementos_celeste/4-01.png"/>
				            <div class="eventotag">
				            	<h5>Evento 1</h5>
				            </div>
				        </div>
				        <div class="product" id="product_1">
				            <img src="assets/png/Elementos_celeste/4-02.png"/>
				            <div class="eventotag">
				            	<h5>Evento 2</h5>
				            </div>
				        </div>
				        <div class="product" id="product_2">
				            <img src="assets/png/Elementos_celeste/4-03.png"/>
				            <div class="eventotag">
				            	<h5>Evento 3</h5>
				            </div>
				        </div>
				        <div class="product" id="product_3">
				            <img src="assets/png/Elementos_celeste/4-04.png"/>
				            <div class="eventotag">
				            	<h5>Evento 4</h5>
				            </div>
				        </div>
					</div>
					</div> -->
			</div>
		</div>
		<c:if test="${not empty secciones}">
		<hr size="2vw" color="#0C6B3E" style="width: 90%; text-align: center;" />
		<div class="scroll-page" id="page-3">
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
		<div class="scroll-page" id="page-4">
			<div class="container">
				<div class="section_color_table">
					<c:set var="index1" value="0"/>
       				<c:set var="index2" value="0"/>
       				<c:set var="index3" value="0"/>
					<table>
						<tr>
						<c:forEach items="${secciones}" var="seccion" varStatus="loop">
						<c:if test="${seccion.getTipo() == 5}">
                       		<c:set var="index1" value="${index1 + 1}"/>
							<th id="th${index1}">${seccion.getTitulo()}</th>
						</c:if>
						</c:forEach>
						</tr>
						<tr>
						<c:forEach items="${secciones}" var="seccion" varStatus="loop">
						<c:if test="${seccion.getTipo() == 5}">
                       		<c:set var="index2" value="${index2 + 1}"/>
							<th id="td${index2}">${seccion.getTexto()}</th>
						</c:if>
						</c:forEach>
						</tr>
						<tr>
						<c:forEach items="${secciones}" var="seccion" varStatus="loop">
						<c:if test="${seccion.getTipo() == 5}">
                       		<c:set var="index3" value="${index3 + 1}"/>
                  			<td id="imgtd${index3}"><img src="${seccion.getPath_image()}"
							id="imgth${index3}"></td>
						</c:if>
						</c:forEach>
						</tr>
					</table>
				</div>
			</div>
		</div>
		</c:if>
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>
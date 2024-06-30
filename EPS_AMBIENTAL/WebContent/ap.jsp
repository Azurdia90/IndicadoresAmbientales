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
				<c:if test="${secciones.size() > 1}">
					<div class="${secciones[1].getClase_css()}">
						<div id="map" style="width: 300px; height: 300px;"></div>
						<h1>${secciones[1].getTitulo()}</h1>
						<h3>${secciones[1].getTexto()}</h3>
					</div>
				</c:if>
			</div>
		</div>
		<hr size="2vw" color="#0C6B3E" style="width: 90%; text-align: center;" />
		<div class="scroll-page" id="page-4">
			<div class="container">
				<c:if test="${secciones.size() > 2}">
					<div class="${secciones[2].getClase_css()}">
						<div id="map2" style="width: 300px; height: 300px;"></div>
						<h1>${secciones[2].getTitulo()}</h1>
						<h3>${secciones[2].getTexto()}</h3>
					</div>
				</c:if>
			</div>
		</div>
		<jsp:include page="footer.jsp" />
	</div>
	<script src="http://cdn.leafletjs.com/leaflet-0.7.3/leaflet.js"></script>
	<script>
		// Creating map options 
		var mapOptions = {
		 	center: [14.61489,-90.51299],
		 	zoom: 17
		}
		 
		var mapOptions2 = {
		 	center: [15.701,-90.290],
		 	zoom: 6
		}
		 
		// Creating a map object
		var map = new L.map('map', mapOptions);
		var map2 = new L.map('map2', mapOptions2);
		 
		// Creating a Layer object
		var layer = new     L.TileLayer('http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png');
		var layer2 = new     L.TileLayer('http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png');
		
		// Adding layer to the map
		map.addLayer(layer);
		map2.addLayer(layer2);
		 
		// Adding maker to the map
		let marker_map_cecon = new L.Marker([14.61489,-90.51299]).bindPopup('Avenida La Reforma 0-63, Zona 10');
		marker_map_cecon.addTo(map);
		 
		let marker_map_ap1 = new L.marker([17.0032,-89.7176]).bindPopup('Biotopo Protegido Cerro Cahuí');
		marker_map_ap1.addTo(map2);
		
		let marker_map_ap2 = new L.marker([17.461,-90.659]).bindPopup('Parque Nacional Laguna del Tigre');
		marker_map_ap2.addTo(map2);
		
		let marker_map_ap3 = new L.marker([17.2342,-89.8144]).bindPopup('Biotopo Protegido San Miguel La Palotada El Zotz');
		marker_map_ap3.addTo(map2);
		
		let marker_map_ap4 = new L.marker([17.7432,-89.6334]).bindPopup('Biotopo Protegido Naachtun - Dos Lagunas');
		marker_map_ap4.addTo(map2);
		
		let marker_map_ap5 = new L.marker([13.88999,-90.47811]).bindPopup('CECON - Monterrico');
		marker_map_ap5.addTo(map2);
		
		let marker_map_ap6 = new L.marker([15.7023,-88.9635]).bindPopup('Biotopo protegido Chocón Machacas');
		marker_map_ap6.addTo(map2);
		
		//let aps_alls = L.layerGroup([marker_map_ap1,marker_map_ap2,marker_map_ap3,marker_map_ap4,marker_map_ap5,marker_map_ap6]);
		 
		//map2.addOverlay(aps_alls, "Areas Protegidas");
		
	 </script>
</body>
</html>
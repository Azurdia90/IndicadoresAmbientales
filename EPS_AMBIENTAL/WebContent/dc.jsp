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
		<div class="container">
			<jsp:include page="main_menu.jsp" />
			<c:if test="${not empty header_image}">
				<jsp:include page="header_image.jsp" />
			</c:if>
		</div>
		<div class="scroll-page" id="page-1">
			<div class="container">
				<span class="brmedium"></span> <label id="tituloSugere">DENUNCIA
					CIUDADANA</label> <span class="brlarge"></span>
				<form action="mail_controller?command=send&type=1" method="post">
					<div id="fomsug">
						<label id="labelsub">Nombre:</label> <input type="name" id="name"
							name="name"> <span class="brmedium"></span> <label
							id="labelsub">Correo electrónico:</label> <input type="email"
							id="email" name="email"> <span class="brmedium"></span>
						<label id="labelsub">Mensaje:</label>
						<textarea id="message" name="message" rows="8"></textarea>
						<span class="brmedium"></span>
						<button id="bttnsug" type="submit">Enviar</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div>
		<span class="brlarge"></span>
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>
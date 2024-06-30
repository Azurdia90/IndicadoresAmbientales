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
				<span class="brmedium"></span> <label id="tituloSugere">CONTACTANOS</label>
				<span class="brlarge"></span>
				<div id="fomsug">
					<form action="mail_controller?command=send" method="post">
						<span class="brlarge"></span> <label id="labelsub">Nombre:</label>
						<input type="text" id="name_to" name="name_to"> <span
							class="brmedium"></span> <label id="labelsub">Correo
							electrónico:</label> <input type="email" id="email_to" name="email_to">
						<span class="brmedium"></span> <label id="labelsub">Asunto:</label>
						<select id="select_subject" name="select_subject">
							<option value="Denuncia Ciudadana" selected>Denuncia
								Ciudadana</option>
							<option value="Sugerencia">Sugerencia</option>
							<option value="Otros">Otros</option>
						</select> <span class="brmedium"></span> <label id="labelsub">Mensaje:</label>
						<textarea id="message_email" name="message_email" rows="8"></textarea>
						<span class="brmedium"></span>
						<button id="bttnsug" type="submit">Enviar</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div>
		<span class="brlarge"></span>
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>
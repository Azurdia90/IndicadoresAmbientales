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
	</div>
</body>
</html>
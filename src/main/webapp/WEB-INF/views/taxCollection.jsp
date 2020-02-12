<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tax Collection</title>
<link href="<c:url value="resources/styles.css" />" rel="stylesheet">
<script>
	window.contextRoot = '${contextRoot}'
</script>
</head>
<body>
<a id="en" href="taxCollection?lang=en">English</a> | <a id="fr" href="taxCollection?lang=fr">French</a>
	<div class="container">
		<%@ include file="header.jsp"%>
		<div class="row">
			<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
				<div class="jumbotron">
					<h1 class="display-6" id='zonalHeading'><spring:message code="ptm.reporttitle"/></h1>
					<%@include file="taxCollectionTable.jsp"%>
					<script src='<c:url value="resources/scripts.js" />'></script>
				</div>
			</div>
		</div>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>
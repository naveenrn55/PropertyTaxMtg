<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><spring:message code="ptm.applicationtitle"/></title>
<link href="<c:url value="resources/styles.css" />" rel="stylesheet">
</head>
<body>
<a id="en" href="home?lang=en">English</a> | <a id="fr" href="home?lang=fr">French</a>
	<div class="container">
		<%@ include file="header.jsp"%>
		<div class="row">
			<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
				<div class="jumbotron">
				
					<h1 class="display-6" id='greeting'><spring:message code="ptm.applicationtitle"/></h1>
					<div class="center">
						<br /> <br /> <a href="taxEvaluation"
							class="btn btn-lg btn-success"><spring:message code="ptm.formbutton"/></a> <br /> <br />
						<a href="taxCollection" class="btn btn-lg btn-success"><spring:message code="ptm.reportbutton"/></a>
					</div>
				</div>
			</div>
		</div>
		<div>
		<input value="${submit}" type="hidden" id="submit">
		<script src='<c:url value="resources/homePageScript.js" />'></script>
		</div>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tax Evaluation</title>
<link href="<c:url value="resources/styles.css" />" rel="stylesheet">
<script src='<c:url value="resources/taxScript.js" />'></script>
<script>
	window.contextRoot = '${contextRoot}'
</script>

</head>
<body>
<a id="en" href="taxEvaluation?lang=en">English</a> | <a id="fr" href="taxEvaluation?lang=fr">French</a>
	<div class="container">
		<%@ include file="header.jsp"%>
		<div class="row">
			<div class="col-xl-12 col-Lg-12 col-md-12 col-sm-12 col-12">
				<h2 align="center"><spring:message code="ptm.formtitle"/></h2>
			</div>
		</div>

		<div class="row">
			<div class="col-6">
				<form:form action="submitTax" modelAttribute="taxEvaluation"
					method="POST" id="taxForm" cssClass="form-horizontal" role="form">

					<div class="form-group row">
						<label for="yearOfAssessment" class="col-6 col-form-label"><spring:message code="ptm.year"/></label>
						<div class="col-6">
							<form:input type="number" path="yearOfAssessment" size="4"
								id="yearOfAssessment" cssClass="form-control" />
							<form:errors path="yearOfAssessment" cssClass="alert-danger" />
						</div>
					</div>


					<div class="form-group row">
						<label for="nameOfOwner" class="col-6 col-form-label"><spring:message code="ptm.name"/></label>
						<div class="col-6">
							<form:input path="nameOfOwner" type="text"
								onkeypress="return alphaOnly(event)" id="nameOfOwner"
								cssClass="form-control" />
							<form:errors path="nameOfOwner" cssClass="alert-danger" />
						</div>
					</div>

					<div class="form-group row">
						<label for="email" class="col-6 col-form-label"><spring:message code="ptm.email"/></label>
						<div class="col-6">
							<form:input path="email" id="email" cssClass="form-control" />
							<form:errors path="email" cssClass="alert-danger" />
						</div>
					</div>


					<div class="form-group row">
						<label for="adressOfProperty" class="col-6 col-form-label"><spring:message code="ptm.adress"/></label>
						<div class="col-6">
							<form:input path="adressOfProperty" id="adressOfProperty"
								cssClass="form-control" />
							<form:errors path="adressOfProperty" cssClass="alert-danger" />
						</div>
					</div>


					<div class="form-group row">
						<label for="zone" class="col-6 col-form-label"><spring:message code="ptm.zone"/></label>
						<div class="col-6">
							<form:select path="zone" onchange="calculateTax()" id="zonesId"
								cssClass="form-control">
								<form:options items="${formData.getZones()}"></form:options>
							</form:select>
						</div>
					</div>


					<div class="form-group row">
						<label for="property" class="col-6 col-form-label"><spring:message code="ptm.property"/></label>
						<div class="col-6">
							<form:select path="property" onchange="calculateTax()"
								id="propertyId" cssClass="form-control">
								<form:options items="${formData.getProperties()}"></form:options>
							</form:select>
						</div>
					</div>


					<div class="form-group row">
						<label for="status" class="col-6 col-form-label"><spring:message code="ptm.residentialstatus"/></label>
						<div class="col-6">
							<form:select path="status" onchange="calculateTax()"
								id="residentId" cssClass="form-control">
								<form:options items="${formData.getResidentialStatuses()}"></form:options>
							</form:select>
						</div>
					</div>


					<div class="form-group row">
						<label for="constructionYear" class="col-6 col-form-label"><spring:message code="ptm.constructionyear"/></label>
						<div class="col-6">
							<form:input path="constructionYear" type="number" size="4"
								onchange="calculateTax()" id="constructionYear"
								cssClass="form-control" />
							<form:errors path="constructionYear" cssClass="alert-danger" />
						</div>
					</div>

					<div class="form-group row">
						<label for="buildArea" class="col-6 col-form-label"><spring:message code="ptm.area"/></label>
						<div class="col-6">
							<form:input path="buildArea" type="number" min="0" step=".01"
								onchange="calculateTax()" id="area" cssClass="form-control" />
							<form:errors path="buildArea" cssClass="alert-danger" />
						</div>
					</div>


					<div class="form-group row">
						<label for="payableTax" class="col-6 col-form-label"><spring:message code="ptm.totaltax"/></label>
						<div class="col-6">
							<form:input path="payableTax" type="number" min="0" step=".01"
								id="taxPayable" cssClass="form-control" />
							<form:errors path="payableTax" cssClass="alert-danger" />
						</div>
					</div>

					<div class="form-group row">
					
							<a href="home"
							class="btn btn-lg btn-success"  style="margin-right: 16px"><spring:message code="ptm.cancel"/></a>      
							      <input type="submit" value="<spring:message code="ptm.paytaxbutton"/>" name="btnSubmit"
								class="btn btn-primary" style="margin-right: 200px">
						
						
							
						
					</div>

				</form:form>
			</div>
		</div>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>
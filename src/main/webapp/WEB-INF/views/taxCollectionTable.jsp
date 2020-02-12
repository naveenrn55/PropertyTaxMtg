<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<link href="<c:url value="resources/styles.css" />" rel="stylesheet">

<table id="table" class="table table-hover table-striped">
	<thead>
		<tr>
			<th><spring:message code="ptm.tablearea"/></th>
			<th><spring:message code="ptm.tablestatus"/></th>
			<th><spring:message code="ptm.tabletotaltax"/></th>
		</tr>
	</thead>
	<tbody>
	</tbody>
</table>

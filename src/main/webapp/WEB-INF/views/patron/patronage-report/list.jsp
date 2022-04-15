<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="patron.patronage-report.list.label.sNumber"
		path="sNumber" />
	<acme:list-column
		code="patron.patronage-report.list.label.creationMoment"
		path="creationMoment" />
	<acme:list-column code="patron.patronage-report.list.label.furtherInfo"
		path="furtherInfo" />
</acme:list>

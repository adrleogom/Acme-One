<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<acme:message code="patron.patron-dashboard.form.label.avg-title" />
<table class="table table-sm">
	<jstl:forEach items="${totalNumberOfPatronages}" var="entry">
		<tr>
			<th><acme:print value="${entry.value}" /></th>
			<td><acme:print value="${entry.value}" /></td>
		</tr>
	</jstl:forEach>
</table>

<acme:message
	code="patron.patron-dashboard.form.label.budgetOfPatronages" />
<table class="table table-sm">
	<jstl:forEach items="${budgetOfPatronages}" var="entry">
		<tr>
			<th><acme:message
					code="patron.patron-dashboard.form.label.deviation-sentence" /> <jstl:set
					var="string1" value="${entry.key}" /> <jstl:set var="string2"
					value="${fn:split(string1, '->')}" /> <acme:print
					value="${string2[0]}" /> <acme:message
					code="patron.patron-dashboard.form.label.status" /> <acme:print
					value="${string2[1]}" /> <acme:message
					code="patron.patron-dashboard.form.label.budget" /></th>
			<td><acme:print value="${entry.value}" /></td>
		</tr>
	</jstl:forEach>
</table>
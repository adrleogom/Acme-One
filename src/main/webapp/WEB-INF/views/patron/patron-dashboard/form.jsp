<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<h2> <acme:message code="patron.patron-dashboard.form.label.totalNumberOfPatronages" /> </h2>

<table class="table table-sm" aria-describedby="totalNumberOfPatronagesTable">
	<jstl:if test="${empty totalNumberOfPatronages}">
		<acme:message code="patron.patron-dashboard.form.label.noPatronages" />
		<br>
		<br>
	</jstl:if>
	<tr> 
		<th id="status"><acme:message code="patron.patron-dashboard.form.label.status" /> </th>
		<th id="number"><acme:message code="patron.patron-dashboard.form.label.number" /> </th>
	</tr>
	<jstl:forEach items="${totalNumberOfPatronages}"
		var="totalNumberOfPatronages">
		<tr>
			<td> <acme:print value="${totalNumberOfPatronages.key}" /></td>
			<td> <acme:print value="${totalNumberOfPatronages.value}" /></td>
		</tr>
	</jstl:forEach>
</table>

<h2> <acme:message code="patron.patron-dashboard.form.label.budgetOfPatronages" /> </h2>

<table class="table table-sm" aria-describedby="budgetOfPatronagesTable"> 


	<jstl:if test="${empty budgetOfPatronages}">
		<acme:message code="patron.patron-dashboard.form.label.nohayPatrocinios" />
		<br>
		<br>
	</jstl:if>
	<tr>
		<th id="status"><acme:message code="patron.patron-dashboard.form.label.status" /></th>
		<th id="currency"><acme:message code="patron.patron-dashboard.form.label.currency" /></th>
		<th id="average"><acme:message code="patron.patron-dashboard.form.label.average" /></th>
		<th id="deviation"><acme:message code="patron.patron-dashboard.form.label.deviation" /></th>
		<th id="minimum"><acme:message code="patron.patron-dashboard.form.label.minimum" /></th>
		<th id="maximum"><acme:message code="patron.patron-dashboard.form.label.maximum" /></th>
	</tr>
	<jstl:forEach items="${budgetOfPatronages}" var="budgetOfPatronages">
		<tr>
			<td><jstl:set var="par" value="${budgetOfPatronages.key}" /> <jstl:set
					var="split" value="${fn:split(par, '->')}" /> <acme:print
					value="${split[0]}" /></td>
			<td> <acme:print value="${split[1]}"/> </td>
			<td> <acme:print value="${budgetOfPatronages.value.getAverage()}" /></td>
			<td> <acme:print value="${budgetOfPatronages.value.getDeviation()}" /></td>
			<td> <acme:print value="${budgetOfPatronages.value.getMinimum()}" /></td>
			<td> <acme:print value="${budgetOfPatronages.value.getMaximum()}" /></td>
		</tr>
	</jstl:forEach>
</table>

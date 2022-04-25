<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<h2> <acme:message code="administrator.administrator-dashboard.form.label.totalNumberOfComponents" /> </h2>

<table class="table table-sm">
	<jstl:if test="${empty totalNumberOfComponents}">
		<acme:message code="administrator.administrator-dashboard.form.label.noComponents" />
		<br>
		<br>
	</jstl:if>
	<tr>
		<td>
			<acme:print value="${totalNumberOfComponents}"/>
		</td>
	</tr>
</table>


<h2> <acme:message code="administrator.administrator-dashboard.form.label.totalNumberOfTools" /> </h2>

<table class="table table-sm">
	<jstl:if test="${empty totalNumberOfTools}">
		<acme:message code="administrator.administrator-dashboard.form.label.noTools" />
		<br>
		<br>
	</jstl:if>
	<tr>
		<td>
			<acme:print value="${totalNumberOfTools}"/>
		</td>
	</tr>
</table>


<h2> <acme:message code="administrator.administrator-dashboard.form.label.totalNumberOfPatronages" /> </h2>

<table class="table table-sm">
	<jstl:if test="${empty totalNumberOfPatronages}">
		<acme:message code="administrator.administrator-dashboard.form.label.noPatronages" />
		<br>
		<br>
	</jstl:if>
	<tr> 
		<th><acme:message code="administrator.administrator-dashboard.form.label.status" /> </th>
		<th><acme:message code="administrator.administrator-dashboard.form.label.number" /> </th>
	</tr>
	<jstl:forEach items="${totalNumberOfPatronages}"
		var="totalNumberOfPatronages">
		<tr>
			<td> <acme:print value="${totalNumberOfPatronages.key}" /></td>
			<td> <acme:print value="${totalNumberOfPatronages.value}" /></td>
		</tr>
	</jstl:forEach>
</table>

<h2> <acme:message code="administrator.administrator-dashboard.form.label.budgetOfPatronages" /> </h2>

<table class="table table-sm">


	<jstl:if test="${empty budgetOfPatronages}">
		<acme:message code="administrator.administrator-dashboard.form.label.nohayPatrocinios" />
		<br>
		<br>
	</jstl:if>
	<tr>
		<th><acme:message code="administrator.administrator-dashboard.form.label.status" /></th>
		<th><acme:message code="administrator.administrator-dashboard.form.label.currency" /></th>
		<th><acme:message code="administrator.administrator-dashboard.form.label.average" /></th>
		<th><acme:message code="administrator.administrator-dashboard.form.label.deviation" /></th>
		<th><acme:message code="administrator.administrator-dashboard.form.label.minimum" /></th>
		<th><acme:message code="administrator.administrator-dashboard.form.label.maximum" /></th>
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

<h2> <acme:message code="administrator.administrator-dashboard.form.label.retailPriceOfTools" /> </h2>
<table class="table table-sm">


	<jstl:if test="${empty retailPriceOfTools}">
		<acme:message code="administrator.administrator-dashboard.form.label.noTools" />
		<br>
		<br>
	</jstl:if>
	<tr>
		<th><acme:message code="administrator.administrator-dashboard.form.label.currency" /></th>
		<th><acme:message code="administrator.administrator-dashboard.form.label.average" /></th>
		<th><acme:message code="administrator.administrator-dashboard.form.label.deviation" /></th>
		<th><acme:message code="administrator.administrator-dashboard.form.label.minimum" /></th>
		<th><acme:message code="administrator.administrator-dashboard.form.label.maximum" /></th>
	</tr>
	<jstl:forEach items="${retailPriceOfTools}" var="retailPriceOfTools">
		<tr>
			<td> <acme:print value="${retailPriceOfTools.key.getCurrency()}" /></td>
			<td> <acme:print value="${retailPriceOfTools.value.getAverage()}" /></td>
			<td> <acme:print value="${retailPriceOfTools.value.getDeviation()}" /></td>
			<td> <acme:print value="${retailPriceOfTools.value.getMinimum()}" /></td>
			<td> <acme:print value="${retailPriceOfTools.value.getMaximum()}" /></td>
		</tr>
	</jstl:forEach>
</table>


<h2> <acme:message code="administrator.administrator-dashboard.form.label.retailPriceOfComponents" /> </h2>
<table class="table table-sm">


	<jstl:if test="${empty retailPriceOfComponents}">
		<acme:message code="administrator.administrator-dashboard.form.label.noComponents" />
		<br>
		<br>
	</jstl:if>
	<tr>
		<th><acme:message code="administrator.administrator-dashboard.form.label.currency" /></th>
		<th><acme:message code="administrator.administrator-dashboard.form.label.technology" /></th>
		<th><acme:message code="administrator.administrator-dashboard.form.label.average" /></th>
		<th><acme:message code="administrator.administrator-dashboard.form.label.deviation" /></th>
		<th><acme:message code="administrator.administrator-dashboard.form.label.minimum" /></th>
		<th><acme:message code="administrator.administrator-dashboard.form.label.maximum" /></th>
	</tr>
	<jstl:forEach items="${retailPriceOfComponents}" var="retailPriceOfComponents">
		<tr>
			<td> <acme:print value="${retailPriceOfComponents.key.getFirst()}" /></td>
			<td> <acme:print value="${retailPriceOfComponents.key.getSecond()}" /></td>
			<td> <acme:print value="${retailPriceOfComponents.value.getAverage()}" /></td>
			<td> <acme:print value="${retailPriceOfComponents.value.getDeviation()}" /></td>
			<td> <acme:print value="${retailPriceOfComponents.value.getMinimum()}" /></td>
			<td> <acme:print value="${retailPriceOfComponents.value.getMaximum()}" /></td>
		</tr>
	</jstl:forEach>
</table>
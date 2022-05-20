<%--
- form.jsp
-
- Copyright (C) 2012-2022 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-textbox code="patron.patronage.form.label.code" path="code"/>	
	<acme:input-money code="patron.patronage.form.label.budget" path="budget" readonly="false"/>	
	<acme:input-moment code="patron.patronage.form.label.initialDate" path="initialDate" readonly="false"/>
	<acme:input-moment code="patron.patronage.form.label.finalDate" path="finalDate" readonly="false"/>
	<acme:input-url code="patron.patronage.form.label.furtherInfo" path="furtherInfo" readonly="false"/>
	<acme:input-textarea code="patron.patronage.form.label.legalStuff" path="legalStuff" readonly="false"/>
	<acme:input-select code="patron.patronage.form.label.inventor" path="inventorId">
	   			<jstl:forEach items="${inventors}" var="inventor">
					<acme:input-option code="${inventor.getUserAccount().getUsername()}" value="${inventor.getId()}" selected="${ inventor.getId() == inventorId }"/>
				</jstl:forEach>
	</acme:input-select>
	<acme:submit test="${command == 'create'}" code="patron.patronage.form.button.create" action="/patron/patronage/create"/>
	
	<jstl:choose> 
		<jstl:when test="${acme:anyOf(command, 'update, delete, publish') || command == 'show' && published == 'false'}">
			<acme:submit code="patron.patronage.form.button.update" action="/patron/patronage/update"/>
			<acme:submit code="patron.patronage.form.button.delete" action="/patron/patronage/delete"/>
			<acme:submit code="patron.patronage.form.button.publish" action="/patron/patronage/publish"/>
		</jstl:when>
		<jstl:when test="${command == 'show'}">
			<acme:input-textbox code="patron.patronage.form.label.status" path="status"/>	
			<acme:input-textbox code="patron.patronage.form.label.inventor.company" path="inventor.company"/>	
			<acme:input-textarea code="patron.patronage.form.label.inventor.statement" path="inventor.statement"/>
			<acme:input-url code="patron.patronage.form.label.inventor.furtherInfo" path="inventor.furtherInfo"/>	
			<acme:input-textbox code="patron.patronage.form.label.inventor.name" path="inventor.identity.name"/>	
			<acme:input-textbox code="patron.patronage.form.label.inventor.surname" path="inventor.identity.surname"/>
			<acme:button code="patron.patronage.form.button.patronage-report" action="/patron/patronage-report/list?masterId=${id}"/>
		</jstl:when>
	
	</jstl:choose> 
</acme:form>

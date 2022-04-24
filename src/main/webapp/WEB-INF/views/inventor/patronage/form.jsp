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

<acme:form readonly="${readonly}">
	<acme:input-textbox code="inventor.patronage.form.label.code" path="code"/>	
	<acme:input-textbox code="inventor.patronage.form.label.status" path="status"/>	
	<acme:input-textarea code="inventor.patronage.form.label.legalStuff" path="legalStuff"/>	
	<acme:input-textbox code="inventor.patronage.form.label.budget" path="budget"/>	
	<acme:input-url code="inventor.patronage.form.label.furtherInfo" path="furtherInfo"/>
	<acme:input-textbox code="inventor.patronage.form.label.patron.company" path="patron.company"/>	
	<acme:input-textarea code="inventor.patronage.form.label.patron.statement" path="patron.statement"/>
	<acme:input-url code="inventor.patronage.form.label.patron.furtherInfo" path="patron.furtherInfo"/>	
 	<acme:input-textbox code="inventor.patronage.form.label.patron.name" path="patron.identity.name"/>	
	<acme:input-textbox code="inventor.patronage.form.label.patron.surname" path="patron.identity.surname"/>	 
</acme:form>

<acme:button code="inventor.patronage.form.button.patronage-report" action="/inventor/patronage-report/list?masterId=${id}"/>


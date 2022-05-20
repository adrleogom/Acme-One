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

	<jstl:if test="${status!='PROPOSED'}">
		<acme:input-textbox code="inventor.patronage.form.label.status" path="status" readonly="true"/>
	</jstl:if>
	
	<jstl:if test="${status='PROPOSED'}">
		<acme:input-select path="status" code="inventor.patronage.form.label.status">
			<acme:input-option code="PROPOSED" value="PROPOSED" selected="true"/>
			<acme:input-option code="ACCEPTED" value="ACCEPTED"/>
			<acme:input-option code="DENIED" value="DENIED"/>
		</acme:input-select>
	</jstl:if>

	<acme:input-textbox code="inventor.patronage.form.label.code" path="code" readonly="true"/>	
	<acme:input-textbox code="inventor.patronage.form.label.status" path="status"/>	
	<acme:input-textarea code="inventor.patronage.form.label.legalStuff" path="legalStuff" readonly="true"/>	
	<acme:input-textbox code="inventor.patronage.form.label.budget" path="budget" readonly="true"/>	
	<acme:input-url code="inventor.patronage.form.label.furtherInfo" path="furtherInfo" readonly="true"/>
	<acme:input-textbox code="inventor.patronage.form.label.patron.company" path="patron.company" readonly="true"/>	
	<acme:input-textarea code="inventor.patronage.form.label.patron.statement" path="patron.statement" readonly="true"/>
	<acme:input-url code="inventor.patronage.form.label.patron.furtherInfo" path="patron.furtherInfo" readonly="true"/>	
 	<acme:input-textbox code="inventor.patronage.form.label.patron.name" path="patron.identity.name" readonly="true"/>
	<acme:input-textbox code="inventor.patronage.form.label.patron.surname" path="patron.identity.surname" readonly="true"/>
	
	<acme:submit test="${command == 'show' && status == 'PROPOSED'}" code="inventor.patronage.form.button.update" action="/inventor/patronage/update"/>
	<br></br>

</acme:form>

<acme:button code="inventor.patronage.form.button.create.patronage-report" action="/inventor/patronage-report/create?masterId=${id}"/>	

<acme:button code="inventor.patronage.form.button.patronage-report" action="/inventor/patronage-report/list?masterId=${id}"/>


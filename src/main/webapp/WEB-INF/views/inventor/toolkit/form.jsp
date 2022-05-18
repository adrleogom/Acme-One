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
	<acme:input-textbox code="inventor.toolkit.form.label.code" path="code"/>
	<acme:input-textbox code="inventor.toolkit.form.label.title" path="title"/>
	<acme:input-textarea code="inventor.toolkit.form.label.description" path="description"/>
	<acme:input-textarea code="inventor.toolkit.form.label.assemblyNotes" path="assemblyNotes"/>
	<acme:input-url code="inventor.toolkit.form.label.furtherInfo" path="furtherInfo"/>

	<acme:submit test="${command == 'create'}" code="inventor.toolkit.form.buttton.create" action="/inventor/toolkit/create"/>
		
	<jstl:choose> 
		<jstl:when test="${acme:anyOf(command, 'update, delete, publish') || command == 'show' && published == 'false'}">
			<acme:submit code="inventor.toolkit.form.buttton.update" action="/inventor/toolkit/update"/>
			<acme:submit code="inventor.toolkit.form.buttton.delete" action="/inventor/toolkit/delete"/>
			<acme:submit code="inventor.toolkit.form.buttton.publish" action="/inventor/toolkit/publish"/>
		</jstl:when>
		<jstl:when test="${command == 'show'}">
			<acme:input-select code="inventor.toolkit.form.label.published" path="published" readonly="true">
				<acme:input-option code="false" value="false" selected="${published == 'false'}"/>
				<acme:input-option code="true" value="true" selected="${published == 'true'}"/>
			</acme:input-select>
			<acme:input-money code="inventor.toolkit.form.label.retailPrice" path="retailPrice" readonly="true"/>
			<acme:button code="inventor.toolkit.form.button.items" action="/inventor/item/list?masterId=${id}"/>			
		</jstl:when>
	</jstl:choose> 
</acme:form>

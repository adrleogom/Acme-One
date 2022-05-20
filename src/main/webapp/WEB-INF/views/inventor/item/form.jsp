<%--
- list.jsp
-
- Copyright (C) 2012-2022 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<%@ page language="java"%>

<acme:form>
	<acme:input-select code="inventor.item.form.label.itemType" path="itemType">
		<acme:input-option code="COMPONENT" value="COMPONENT" selected="${itemType == 'COMPONENT'}" />
		<acme:input-option code="TOOL" value="TOOL" selected="${itemType == 'TOOL'}"/>
	</acme:input-select> 
	<acme:input-textbox code="inventor.item.form.label.code" path="code"/>
	<acme:input-textbox code="inventor.item.form.label.name" path="name"/>
	<acme:input-textbox code="inventor.item.form.label.technology" path ="technology"/>
	<acme:input-textarea code="inventor.item.form.label.description" path ="description"/>
	<acme:input-money code="inventor.item.form.label.retailPrice" path ="retailPrice"/>
	<acme:input-url code="inventor.item.form.label.furtherInfo" path ="furtherInfo"/>
	
	<acme:submit  test="${command == 'create'}" code="inventor.item.form.button.create" action="/inventor/item/create"/>  
	
	<jstl:choose>
		
		<jstl:when test="${acme:anyOf(command, 'show, update, delete, publish') && published == false }">
			<acme:input-textbox code="inventor.item.form.label.published" path ="published" readonly="true"/>
			<acme:submit code="inventor.item.form.button.delete" action="/inventor/item/delete"/>
			<acme:submit code="inventor.item.form.button.publish" action="/inventor/item/publish"/>
			<acme:submit code="inventor.item.form.button.update" action="/inventor/item/update"/>	
		</jstl:when>

 		<jstl:when test="${command == 'show'}">
			<acme:input-textbox code="inventor.item.form.label.code" path="code" readonly="true"/>
			<acme:input-select code="inventor.item.form.label.published" path="published" readonly="true">
				<acme:input-option code="false" value="false" selected="${published == 'false'}"/>
				<acme:input-option code="true" value="true" selected="${published == 'true'}"/>
			</acme:input-select>
		</jstl:when>
	</jstl:choose>	
</acme:form>


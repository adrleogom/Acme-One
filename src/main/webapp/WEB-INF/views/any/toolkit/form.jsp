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
	<acme:input-textbox code="any.toolkit.form.label.code" path="code"/>
	<acme:input-textbox code="any.toolkit.form.label.title" path="title"/>
	<acme:input-textarea code="any.toolkit.form.label.description" path="description"/>
	<acme:input-textarea code="any.toolkit.form.label.assemblyNotes" path="assemblyNotes"/>
	<acme:input-textbox code="any.toolkit.form.label.furtherInfo" path="furtherInfo"/>
	<acme:input-money code="inventor.toolkit.form.label.retailPrice" path="retailPrice"/>
	<acme:input-textbox code="any.toolkit.form.label.inventor" path="inventor"/>
	
	<jstl:if test="${differentCurrency == true}">
		<acme:input-money code="inventor.item.form.label.conversion"
		 path="conversion" readonly="true"/>
	</jstl:if>
	
	<acme:button code="any.toolkit.form.button.items" action="/any/item/list-published?masterId=${id}"/>
</acme:form>
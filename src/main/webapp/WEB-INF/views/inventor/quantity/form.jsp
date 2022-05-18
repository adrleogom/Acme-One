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
	<acme:input-integer code="inventor.quantity.form.label.number" path="number"/>
	<acme:input-select code="inventor.quantity.form.label.item" path="item">
		<jstl:forEach items="${items}" var = "i">
			<acme:input-option code="${i.getName()}" value="${i.getId()}" selected="${ i.getId() == item }"/>
		</jstl:forEach>
	</acme:input-select>

	<acme:submit test="${command == 'create'}" code="inventor.quantity.form.button.create" action="/inventor/quantity/create?masterId=${masterId}"/>
		
</acme:form>

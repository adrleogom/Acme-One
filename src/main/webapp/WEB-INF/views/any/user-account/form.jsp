<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form readonly="${readonly}">
	<acme:input-textbox code="any.user-account.list.label.username" path="username"/>
	<acme:input-textbox code="any.user-account.list.label.name" path="identity.name"/>
	<acme:input-textbox code="any.user-account.list.label.surname" path="identity.surname"/>	
	<acme:input-email code="any.user-account.list.label.email" path="identity.email"/>			
</acme:form>


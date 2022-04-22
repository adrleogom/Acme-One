<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="any.item.list.label.itemType" path="itemType" width="40%"/>	
	<acme:list-column code="any.item.list.label.name" path="name" width="30%"/>
	<acme:list-column code="any.item.list.label.code" path="code" width="30%"/>
</acme:list> 
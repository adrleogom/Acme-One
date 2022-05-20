<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>


<acme:form>
	<acme:input-textarea code="administrator.announcement.form.label.title" path="title"/>
	<acme:input-textarea code="administrator.announcement.form.label.body" path="body"/>
	<acme:hidden-data path="moment"/>
	<acme:input-textarea code="administrator.announcement.form.label.furtherInfo" path="furtherInfo"/>
	<acme:input-textarea code="administrator.announcement.form.label.flag" path="flag"/>	
	
	<jstl:if test="${command == 'create'}">
		<acme:input-checkbox code="administrator.announcement.form.label.confirmation" path="confirmation"/>
	</jstl:if>
	<acme:submit test="${command == 'create'}" code="administrator.announcement.form.button.create" action="/administrator/announcement/create"/>
	
</acme:form>
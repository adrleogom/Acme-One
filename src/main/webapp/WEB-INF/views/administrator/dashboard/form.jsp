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
	<acme:input-textbox code="administrator.dashboard.form.label.totalNumberOfComponents" path="totalNumberOfComponents"/>	
	<acme:input-textbox code="administrator.dashboard.form.label.totalNumberOfTools" path="totalNumberOfTools"/>
	<acme:input-textbox code="administrator.dashboard.form.label.totalNumberOfPatronages" path="totalNumberOfPatronages"/>
	<acme:input-double code="administrator.dashboard.form.label.retailPriceOfComponents" path="retailPriceOfComponents"/>
	<acme:input-textbox code="administrator.dashboard.form.label.retailPriceOfTools" path="retailPriceOfTools"/>
	<acme:input-double code="administrator.dashboard.form.label.budgetOfPatronages" path="budgetOfPatronages"/>
</acme:form> 

<%--
- menu.jsp
-
- Copyright (C) 2012-2022 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"
	import="acme.framework.helpers.PrincipalHelper"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:menu-bar code="master.menu.home">
	<acme:menu-left>
	
		<%--ANONIMO--%>
		<acme:menu-option code="master.menu.anonymous" access="isAnonymous()">
			<acme:menu-suboption code="master.menu.any.toolkits" action="/any/toolkit/list"/>	
			<acme:menu-suboption code="master.menu.any.items" action="/any/item/list"/>	
      		<acme:menu-suboption code="master.menu.any.recent-chirps" action="/any/chirp/list"/>
			<acme:menu-suboption code="master.menu.any.all-users" action="/any/user-account/list"/>
			<acme:menu-suboption code="master.menu.anonymous.carmen" action="https://github.com/carmengl00"/>
			<acme:menu-suboption code="master.menu.anonymous.alvaro" action="https://twitter.com/makeamate_es"/>
			<acme:menu-suboption code="master.menu.anonymous.abraham" action="https://www.wuolah.com/"/>
			<acme:menu-suboption code="master.menu.anonymous.beatriz" action="https://ev.us.es/"/>
			<acme:menu-suboption code="master.menu.anonymous.paula" action="https://www.twitch.tv/alexelcapo"/>
			<acme:menu-suboption code="master.menu.anonymous.adriana" action="https://makeamatelpmaster.gatsbyjs.io"/>
		</acme:menu-option>

		
		<%--ADMINISTRADOR--%>
		<acme:menu-option code="master.menu.administrator" access="hasRole('Administrator')">
			<acme:menu-suboption code="master.menu.any.toolkits" action="/any/toolkit/list"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.administrator-dashboard" action="/administrator/administrator-dashboard/show"/>
			<acme:menu-suboption code="master.menu.administrator.system-configuration" action="/administrator/system-configuration/show"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.user-accounts" action="/administrator/user-account/list"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.populate-initial" action="/administrator/populate-initial"/>
			<acme:menu-suboption code="master.menu.administrator.populate-sample" action="/administrator/populate-sample"/>			
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.shut-down" action="/administrator/shut-down"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.announcement" action="/administrator/announcement/list"/>
		</acme:menu-option>
		
		<%--INVENTOR--%>
		<acme:menu-option code="master.menu.inventor" access="hasRole('Inventor')">
			 <acme:menu-suboption code="master.menu.inventor.patronages" action="/inventor/patronage/list"/>
      		<acme:menu-suboption code = "master.menu.inventor.item" action = "/inventor/item/list-mine"/>
     	 	<acme:menu-suboption code = "master.menu.inventor.toolkit" action = "/inventor/toolkit/list"/>
    	</acme:menu-option>
    	
      	<%--PATRON--%>
		<acme:menu-option code="master.menu.patron" access="hasRole('Patron')">
			<acme:menu-suboption code="master.menu.patron.patronage" action="/patron/patronage/list"/>
			<acme:menu-suboption code="master.menu.patron.patron-dashboard" action="/patron/patron-dashboard/show"/>
		</acme:menu-option>
    	
    	<%--AUTENTICADOS--%>
		<acme:menu-option code="master.menu.authenticated" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.any.toolkits" action="/any/toolkit/list"/>	
			<acme:menu-suboption code="master.menu.any.items" action="/any/item/list"/>
      		<acme:menu-suboption code="master.menu.any.recent-chirps" action="/any/chirp/list"/>
			<acme:menu-suboption code="master.menu.authenticated.systemConfiguration" action="/authenticated/system-configuration/show"/>
     		<acme:menu-suboption code="master.menu.any.all-users" action="/any/user-account/list"/>
			<acme:menu-suboption code="master.menu.authenticated.list-announcement" action="/authenticated/announcement/list"/>
			<acme:menu-suboption code="master.menu.authenticated.money-exchage" action="/authenticated/money-exchange/perform"/>
		</acme:menu-option>
	</acme:menu-left>
	
	

	<acme:menu-right>
		<acme:menu-option code="master.menu.sign-up" action="/anonymous/user-account/create" access="isAnonymous()" />
		<acme:menu-option code="master.menu.sign-in" action="/master/sign-in" access="isAnonymous()" />
		<acme:menu-option code="master.menu.user-account" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.user-account.general-data" action="/authenticated/user-account/update" />
			
			<acme:menu-suboption code="master.menu.user-account.become-inventor" action="/authenticated/inventor/create" access="!hasRole('Inventor')" />
			<acme:menu-suboption code="master.menu.user-account.inventor" action="/authenticated/inventor/update" access="hasRole('Inventor')" />
			
			<acme:menu-suboption code="master.menu.user-account.become-patron" action="/authenticated/patron/create" access="!hasRole('Patron')" />
			<acme:menu-suboption code="master.menu.user-account.patron" action="/authenticated/patron/update" access="hasRole('Patron')" />
		</acme:menu-option>

		<acme:menu-option code="master.menu.sign-out" action="/master/sign-out" access="isAuthenticated()" />
	</acme:menu-right>
</acme:menu-bar>


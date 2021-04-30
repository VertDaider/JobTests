<%@ include file="/init.jsp" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="com.liferay.portal.kernel.portlet.PortletURLUtil" %>
<%@ page import="company.service.PositionLocalServiceUtil" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%--<%--%>
<%-- long bankId = (Long) request.getAttribute("bankId");--%>
<%--%>--%>

<%--<aui:button-row cssClass="guestbook-buttons">--%>

<%-- <portlet:renderURL var="addEntryURL">--%>
<%--  <portlet:param name="mvcPath" value="/bank/edit_entry.jsp" />--%>
<%--  <portlet:param name="bankId"--%>
<%--                 value="<%=String.valueOf(bankId)%>" />--%>
<%-- </portlet:renderURL>--%>

<%-- <aui:button onClick="<%=addEntryURL.toString()%>" value="Add Entry"></aui:button>--%>

<%--</aui:button-row>--%>

<p>
	<b><liferay-ui:message key="app.caption"/></b>
</p>



    <portlet:renderURL var="addEntryURL">
        <portlet:param name="mvcPath" value="./bank/edit_entry.jsp" />
<%--        <portlet:param name="guestbookId"--%>
<%--                       value="<%=String.valueOf(guestbookId)%>" />--%>
    </portlet:renderURL>

<aui:button-row>
    <aui:button value="Add Bank"></aui:button>
</aui:button-row>

<liferay-ui:search-container total="<%=BankLocalServiceUtil.getBanksCount()%>">
    <liferay-ui:search-container-results
            results="<%=BankLocalServiceUtil.getBanks(0, BankLocalServiceUtil.getBanksCount())%>" />

    <liferay-ui:search-container-row
            className="company.model.Bank" modelVar="bank">

        <liferay-ui:search-container-column-text name = "Название" property="bankName" />
        <liferay-ui:search-container-column-text name="БИК" property="BIK" />
        <liferay-ui:search-container-column-text name="Адрес" property="address" />

    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator />

</liferay-ui:search-container>

<liferay-ui:search-container total="<%=PositionLocalServiceUtil.getPositionsCount()%>">
    <liferay-ui:search-container-results
            results="<%=PositionLocalServiceUtil.getPositions(0, PositionLocalServiceUtil.getPositionsCount())%>" />

    <liferay-ui:search-container-row
            className="company.model.Position" modelVar="position">

        <liferay-ui:search-container-column-text name = "Должность" property="name" />
        <liferay-ui:search-container-column-text name="В архиве" property="archive" />

    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator />

</liferay-ui:search-container>





<%--<liferay-ui:search-container >--%>

<%-- <liferay-ui:search-container-results--%>
<%--                      >--%>
<%--  </liferay-ui:search-container-results>--%>

<%--  <liferay-ui:search-container-row--%>
<%--          className="company.model.Bank"--%>
<%--          modelVar="bank"--%>
<%--          keyProperty="bankId"--%>
<%--  >--%>

<%--  </liferay-ui:search-container-row>--%>
<%--  <liferay-ui:search-iterator />--%>
<%-- </liferay-ui:search-container>--%>
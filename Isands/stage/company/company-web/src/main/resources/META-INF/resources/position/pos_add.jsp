<%@ page import="company.model.Position" %>
<%@ include file="/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Position position = null;
%>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
</portlet:renderURL>
<portlet:renderURL var="viewPosURL">
    <portlet:param name="mvcPath" value="/position/pos_view.jsp"></portlet:param>
</portlet:renderURL>

<portlet:actionURL name="addPosition" var="addPositionURL"></portlet:actionURL>

<aui:form action="${addPositionURL}" name="fm">
    <aui:model-context bean="<%= position %>" model="<%= Position.class %>"/>

    <aui:input label="Должность" name="name" type="text" cssClass="add">
        <aui:validator errorMessage="errorInputMessage" name="required" />
    </aui:input>
    <aui:input label="В архиве" name="archive" type="checkbox" />

    <aui:button-row>
        <aui:button type="submit"></aui:button>
        <aui:button type="cancel" href="${viewURL}"></aui:button>
    </aui:button-row>
</aui:form>
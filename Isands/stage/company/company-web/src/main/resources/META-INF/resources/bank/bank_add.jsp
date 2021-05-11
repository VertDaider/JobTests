<%@ page import="company.model.Bank" %>
<%@ include file="/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Bank bank = null;
%>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
</portlet:renderURL>

<portlet:actionURL name="addBank" var="addPositionURL"></portlet:actionURL>

<aui:form action="${addPositionURL}" name="fm">
    <aui:model-context bean="<%= bank %>" model="<%= Bank.class %>"/>

    <aui:input label="Название" name="bankName" type="text" cssClass="add">
        <aui:validator errorMessage="errorInputMessage" name="required" />
    </aui:input>
    <aui:input label="БИК" name="bik" type="text" cssClass="add">
        <aui:validator name="required" />
        <aui:validator errorMessage="errorInputMessageDigit" name="number" />
    </aui:input>
    <aui:input label="Адрес" name="address" type="text" cssClass="add">
        <aui:validator errorMessage="errorInputMessage" name="required" />
    </aui:input>

    <aui:button-row>
        <aui:button type="submit"></aui:button>
        <aui:button type="cancel" href="${viewURL}"></aui:button>
    </aui:button-row>
</aui:form>
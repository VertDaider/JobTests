<%@ page import="company.service.BankLocalServiceUtil" %>
<%@ page import="company.model.Bank" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/init.jsp" %>

<liferay-theme:defineObjects/>
<portlet:defineObjects/>
<%
    List<Bank> bankList = BankLocalServiceUtil.getBanks(0, BankLocalServiceUtil.getBanksCount());
%>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
</portlet:renderURL>

<liferay-ui:search-container total="<%=bankList.size()%>">
    <liferay-ui:search-container-results results="<%=bankList%>"/>
    <liferay-ui:search-container-row
            className="company.model.Bank" modelVar="bank">

        <portlet:renderURL var="editURL">
            <portlet:param name="mvcPath" value="/bank/bank_edit.jsp"></portlet:param>
            <portlet:param name="bankId" value="<%=String.valueOf(bank.getBankId())%>"/>
        </portlet:renderURL>

        <portlet:actionURL name="deleteBank" var="deleteURL">
            <portlet:param name="mvcPath" value="/bank/bank_view.jsp"></portlet:param>
            <portlet:param name="bankId" value="<%=String.valueOf(bank.getBankId())%>"/>
        </portlet:actionURL>

        <liferay-ui:search-container-column-text name="Название" property="bankName"/>
        <liferay-ui:search-container-column-text name="БИК" property="BIK"/>
        <liferay-ui:search-container-column-text name="Адрес" property="address"/>
        <liferay-ui:search-container-column-text name="Редактировать запись" href="${editURL}" cssClass="text-center">
            <liferay-ui:icon image="edit"/>
        </liferay-ui:search-container-column-text>
        <liferay-ui:search-container-column-text name="Удалить запись" href="${deleteURL}" cssClass="text-center">
            <liferay-ui:icon image="delete"/>
        </liferay-ui:search-container-column-text>

    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator/>
</liferay-ui:search-container>

<aui:button-row>
    <aui:button type="cancel" href="${viewURL}"></aui:button>
</aui:button-row>

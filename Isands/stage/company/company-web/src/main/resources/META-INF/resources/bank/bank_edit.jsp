<%@ page import="company.service.BankLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="company.model.Bank" %>
<%@ include file="/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<portlet:defineObjects/>

<%
    long bankId = ParamUtil.getLong(request, "bankId");
    Bank bank = BankLocalServiceUtil.getBank(bankId);
%>

<portlet:actionURL name="editBank" var="editBankURL">
    <portlet:param name="bankId" value="<%=String.valueOf(bank.getBankId())%>"/>
</portlet:actionURL>

<aui:form action="${editBankURL}" name="fm">

    <aui:model-context bean="<%= bank %>" model="<%= Bank.class %>"/>

    <aui:input label="Название" name="bankName" type="text" cssClass="add" disabled="true"/>
    <aui:input label="БИК" name="BIK" type="text" cssClass="add">
        <aui:validator name="required"/>
        <aui:validator errorMessage="errorInputMessageDigit" name="number"/>
    </aui:input>
    <aui:input label="Адрес" name="address" type="text" cssClass="add">
        <aui:validator errorMessage="errorInputMessage" name="required"/>
    </aui:input>

    <portlet:renderURL var="viewURL">
        <portlet:param name="mvcPath" value="/bank/bank_view.jsp"></portlet:param>
    </portlet:renderURL>

    <aui:button-row>
        <aui:button type="submit"></aui:button>
        <aui:button type="cancel" href="${viewURL}"></aui:button>
    </aui:button-row>
</aui:form>

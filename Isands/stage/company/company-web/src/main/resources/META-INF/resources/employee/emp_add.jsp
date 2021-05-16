<%@ page import="company.model.Employee" %>
<%@ page import="company.model.Position" %>
<%@ page import="java.util.List" %>
<%@ page import="company.service.PositionLocalServiceUtil" %>
<%@ page import="company.model.Bank" %>
<%@ page import="company.service.BankLocalServiceUtil" %>
<%@ include file="/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Employee employee = null;
%>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
</portlet:renderURL>

<portlet:actionURL name="addEmployee" var="addEmpURL"></portlet:actionURL>

<aui:form action="${addEmpURL}" name="fm">
    <aui:model-context bean="<%= employee %>" model="<%=Employee.class%>"/>

    <aui:input label="Фамилия" name="surname" type="text" cssClass="add">
        <aui:validator name="required"></aui:validator>
    </aui:input>
    <aui:input label="Имя" name="name" type="text" cssClass="add">
        <aui:validator name="required"></aui:validator>
    </aui:input>
    <aui:input label="Отчество" name="patronymic" type="text" cssClass="add">
        <aui:validator name="required"></aui:validator>
    </aui:input>
    <table>
        <tr>
            <td>
                <aui:input type="radio" label="Мужской" name="sex" value="man"></aui:input>
            </td>
            <td>
                <aui:input type="radio" label="Женский" name="sex" value="woman"></aui:input>
            </td>
        </tr>
    </table>
    <aui:input label="Дата рождения" name="birthDay" type="date" cssClass="add">
        <aui:validator name="date"></aui:validator>
    </aui:input>
    <aui:select label="Должность" name="position" cssClass="add">
        <%
            List<Position> list = PositionLocalServiceUtil.getPositions(0, PositionLocalServiceUtil.getPositionsCount());
            for (Position l : list) {
        %>
        <aui:option value="<%=l.getPositionId()%>"><%=l.getName()%></aui:option>
        <%
            }
        %>
    </aui:select>
    <aui:input label="Дата трудоустройства" name="dateOfEmployment" type="date" cssClass="add">
        <aui:validator name="date"></aui:validator>
    </aui:input>
    <aui:input label="Заработная плата" name="salary" type="text" cssClass="add">
        <aui:validator name="required"/>
        <aui:validator name="number" errorMessage="errorInputMessageDigit"></aui:validator>
    </aui:input>
    <aui:input label="Рабочий номер телефона" name="jobPhone" type="text" cssClass="add">
        <aui:validator name="required"/>
        <aui:validator name="number" errorMessage="errorInputMessageDigit"></aui:validator>
    </aui:input>
    <aui:input label="Мобильный номер телефона" name="mobilePhone" type="text" cssClass="add">
        <aui:validator name="required"/>
        <aui:validator name="number" errorMessage="errorInputMessageDigit"></aui:validator>
    </aui:input>
    <aui:select label="Банковская организация" name="bank" cssClass="add">
        <%
            List<Bank> list = BankLocalServiceUtil.getBanks(0, BankLocalServiceUtil.getBanksCount());
            for (Bank b : list) {
        %>
        <aui:option value="<%=b.getBankId()%>"><%=b.getBankName()%></aui:option>
        <%
            }
        %>
    </aui:select>
    <aui:input label="Работает / не работает" name="archive" type="checkbox"/>

    <aui:button-row>
        <aui:button type="submit"></aui:button>
        <aui:button type="cancel" href="${viewURL}"></aui:button>
    </aui:button-row>
</aui:form>

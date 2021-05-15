<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="company.model.Employee" %>
<%@ page import="company.service.EmployeeLocalServiceUtil" %>
<%@ page import="java.util.List" %>
<%@ page import="company.service.PositionLocalServiceUtil" %>
<%@ page import="company.service.BankLocalServiceUtil" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/init.jsp" %>
<script>
    <%@include file="/js/datepicker.js" %>
</script>
<%
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
    List<Employee> listEmp = EmployeeLocalServiceUtil.getEmployees(0, EmployeeLocalServiceUtil.getEmployeesCount());
%>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
</portlet:renderURL>

<liferay-ui:search-container total="<%=listEmp.size()%>">
    <liferay-ui:search-container-results results="<%=listEmp%>"/>
    <liferay-ui:search-container-row className="company.model.Employee" modelVar="employee">

        <portlet:renderURL var="editURL">
            <portlet:param name="mvcPath" value="/employee/emp_edit.jsp"></portlet:param>
            <portlet:param name="employeeId" value="<%=String.valueOf(employee.getEmployeesId())%>"/>
        </portlet:renderURL>
        <portlet:actionURL name="deleteEmployee" var="deleteURL">
            <portlet:param name="mvcPath" value="/employee/emp_view.jsp"/>
            <portlet:param name="employeeId" value="<%=String.valueOf(employee.getEmployeesId())%>"/>
        </portlet:actionURL>
        <portlet:actionURL name="editArchiveEmp" var="editArchiveURL">
            <portlet:param name="mvcPath" value="/employee/emp_view.jsp"/>
            <portlet:param name="employeeId" value="<%=String.valueOf(employee.getEmployeesId())%>"/>
        </portlet:actionURL>

        <liferay-ui:search-container-column-text name="Фамилия" value="<%=employee.getSurname()%>"/>
        <liferay-ui:search-container-column-text name="Имя" value="<%=employee.getName()%>"/>
        <liferay-ui:search-container-column-text name="Отчество" value="<%=employee.getPatronymic()%>"/>
        <liferay-ui:search-container-column-text name="Пол" value="<%=employee.getSex()%>"/>
        <liferay-ui:search-container-column-text name="Дата рождения" value="<%=sdf.format(employee.getBirthDay())%>"/>
        <liferay-ui:search-container-column-text
                name="Должность" value="<%=PositionLocalServiceUtil.getPosition(employee.getPosition()).getName()%>"/>
        <liferay-ui:search-container-column-text name="Дата трудоустройства"
                                                 value="<%=sdf.format(employee.getDateOfEmployment())%>"/>
        <liferay-ui:search-container-column-text name="Заработная плата" property="salary"/>
        <liferay-ui:search-container-column-text name="Рабочий номер телефона" property="jobPhone"/>
        <liferay-ui:search-container-column-text name="Мобильный номер телефона" property="mobilePhone"/>
        <liferay-ui:search-container-column-text
                name="Банковская организация"
                value="<%=BankLocalServiceUtil.getBank(employee.getBank()).getBankName()%>"/>
        <liferay-ui:search-container-column-text name="Работает / не работает" cssClass="text-center"
                                                 href="${editArchiveURL}">
            <% if (!employee.isArchive()) { %>
            <liferay-ui:icon image="checked"/>
            <% } else { %>
            <liferay-ui:icon image="close"/>
            <% } %>
        </liferay-ui:search-container-column-text>
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


<portlet:renderURL var="applyFilterURL">
    <portlet:param name="mvcPath" value="/employee/emp_filter.jsp"/>
</portlet:renderURL>
<aui:form name="fbd">
    <aui:row>
        <aui:input type="text" id="firstDate" name="firstDate" cssClass="date" label="" placeholder="01.01.1990">
        </aui:input>

        <aui:input
                type="text" id="lastDate" name="lastDate" cssClass="date" label="" placeholder="01.01.2000">
        </aui:input>
    </aui:row>
    <aui:button-row>
        <aui:button type="submit" value="Apply" href="${applyFilterURL}"></aui:button>
    </aui:button-row>
</aui:form>


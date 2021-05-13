<%@ page import="company.model.Bank" %>
<%@ page import="com.liferay.portal.kernel.portlet.PortletURLUtil" %>
<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="company.service.persistence.EmployeeUtil" %>
<%@ page import="company.model.Employee" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="company.model.Position" %>
<%@ page import="company.service.*" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/init.jsp" %>
<%
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
%>

<script>
    $(function(){
        var minDate = new Date(new Date().getUTCFullYear()-99, new Date().getMonth(), new Date().getDate());
        var maxDate = new Date(new Date().getUTCFullYear(), new Date().getMonth(), new Date().getDate());
        $("#<portlet:namespace/>dob").datepicker({
            dateFormat: 'dd/mm/yy',
            changeMonth: true,
            changeYear: true,
            yearRange: '-99:+10',
            minDate: minDate,
            maxDate: maxDate,
            gotoCurrent: true
        }).datepicker('<portlet:namespace/>dob',"0");
    });
</script>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
</portlet:renderURL>

<liferay-ui:search-container total="<%=EmployeeLocalServiceUtil.getEmployeesCount()%>">
    <liferay-ui:search-container-results
            results="<%=EmployeeLocalServiceUtil.getEmployees(0, EmployeeLocalServiceUtil.getEmployeesCount())%>"/>

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
        <liferay-ui:search-container-column-text name="Работает / не работает" cssClass="text-center" href="${editArchiveURL}">
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

<aui:input type="text" name="dob" label="Фильтр по дате рождения" id="dob" cssClass="add">
    <aui:validator name="required" />
    <aui:validator name="date" />
</aui:input>

<aui:button-row>
    <aui:button type="cancel" href="${viewURL}"></aui:button>
</aui:button-row>


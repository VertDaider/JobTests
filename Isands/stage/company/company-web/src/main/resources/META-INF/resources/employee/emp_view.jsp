<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="company.model.Employee" %>
<%@ page import="company.service.EmployeeLocalServiceUtil" %>
<%@ page import="java.util.List" %>
<%@ page import="company.service.PositionLocalServiceUtil" %>
<%@ page import="company.service.BankLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="java.util.Date" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/init.jsp" %>

<aui:script>
    <%@include file="/js/datepicker.js" %>
</aui:script>

<%
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
    Date periodFrom = ParamUtil.getDate(request, "periodFrom", sdf, null);
    Date periodTo = ParamUtil.getDate(request, "periodTo", sdf, null);
    int empCount = EmployeeLocalServiceUtil.getEmployeesCount();
    List<Employee> listEmp = EmployeeLocalServiceUtil.getEmployees(0, empCount, periodFrom, periodTo);
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

        <liferay-ui:search-container-column-text name="??????????????" value="<%=employee.getSurname()%>"/>
        <liferay-ui:search-container-column-text name="??????" value="<%=employee.getName()%>"/>
        <liferay-ui:search-container-column-text name="????????????????" value="<%=employee.getPatronymic()%>"/>
        <liferay-ui:search-container-column-text name="??????" value="<%=employee.getSex()%>"/>
        <liferay-ui:search-container-column-text name="???????? ????????????????" value="<%=sdf.format(employee.getBirthDay())%>"/>
        <liferay-ui:search-container-column-text
                name="??????????????????" value="<%=PositionLocalServiceUtil.getPosition(employee.getPosition()).getName()%>"/>
        <liferay-ui:search-container-column-text name="???????? ??????????????????????????????"
                                                 value="<%=sdf.format(employee.getDateOfEmployment())%>"/>
        <liferay-ui:search-container-column-text name="???????????????????? ??????????" property="salary"/>
        <liferay-ui:search-container-column-text name="?????????????? ?????????? ????????????????" property="jobPhone"/>
        <liferay-ui:search-container-column-text name="?????????????????? ?????????? ????????????????" property="mobilePhone"/>
        <liferay-ui:search-container-column-text
                name="???????????????????? ??????????????????????"
                value="<%=BankLocalServiceUtil.getBank(employee.getBank()).getBankName()%>"/>
        <liferay-ui:search-container-column-text name="???????????????? / ???? ????????????????" cssClass="text-center"
                                                 href="${editArchiveURL}">
            <% if (!employee.isArchive()) { %>
            <liferay-ui:icon image="checked"/>
            <% } else { %>
            <liferay-ui:icon image="close"/>
            <% } %>
        </liferay-ui:search-container-column-text>
        <liferay-ui:search-container-column-text name="?????????????????????????? ????????????" href="${editURL}" cssClass="text-center">
            <liferay-ui:icon image="edit"/>
        </liferay-ui:search-container-column-text>
        <liferay-ui:search-container-column-text name="?????????????? ????????????" href="${deleteURL}" cssClass="text-center">
            <liferay-ui:icon image="delete"/>
        </liferay-ui:search-container-column-text>
    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator/>
</liferay-ui:search-container>

<aui:button-row>
    <aui:button type="cancel" href="${viewURL}"></aui:button>
</aui:button-row>


<portlet:renderURL var="filterURL">
    <portlet:param name="mvcPath" value="/employee/emp_view.jsp"/>
</portlet:renderURL>
<c:set var="filterURL" scope="request" value="${filterURL}"/>
<aui:form action="${filterURL}" cssClass="add">
    <b>???????????? ???? ???????? ????????????????</b>
    <aui:row>
        <aui:input
                type="text" name="periodFrom" cssClass="datePicker" label="" placeholder="mm.dd.yyyy">
        </aui:input>

        <aui:input
                type="text" name="periodTo" cssClass="datePicker" label="" placeholder="mm.dd.yyyy">
        </aui:input>
    </aui:row>
    <aui:button-row>
        <aui:button type="button" value="Clear" href="${filterURL}"></aui:button>
        <aui:button type="submit" value="Apply"></aui:button>
    </aui:button-row>
</aui:form>

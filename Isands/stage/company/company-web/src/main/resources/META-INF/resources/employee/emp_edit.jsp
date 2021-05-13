<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="company.model.Employee" %>
<%@ page import="company.service.EmployeeLocalServiceUtil" %>
<%@ page import="company.model.Position" %>
<%@ page import="company.service.PositionLocalServiceUtil" %>
<%@ page import="java.util.List" %>
<%@ page import="company.model.Bank" %>
<%@ page import="company.service.BankLocalServiceUtil" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.liferay.portal.kernel.util.CalendarFactoryUtil" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.ParseException" %>
<%@ include file="/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    long empId = ParamUtil.getLong(request, "employeeId");
    Employee employee = EmployeeLocalServiceUtil.getEmployee(empId);
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
%>
<%!
    public static String getDate(Date date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        return sdf.format(date);

    }

    public static Calendar toCalendar(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }
%>

<portlet:actionURL name="editEmployee" var="editEmpURL">
    <portlet:param name="empId" value="<%=String.valueOf(employee.getEmployeesId())%>"/>
</portlet:actionURL>

<aui:form action="${editEmpURL}" name="fm">
    <aui:model-context bean="<%= employee %>" model="<%= Employee.class %>"/>

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
                <aui:input type="radio" label="Мужской" name="sex" value="man"
                           checked="<%=employee.getSex().equals("мужской")%>">
                </aui:input>
            </td>
            <td>
                <aui:input type="radio" label="Женский" name="sex" value="woman"
                           checked="<%=employee.getSex().equals("женский")%>">
                </aui:input>
            </td>
        </tr>
    </table>
    <b>Дата рождения</b>
    <liferay-ui:input-date name="birthDay" cssClass="add" formName="Дата рождения"
                           dayValue="<%=toCalendar(employee.getBirthDay()).get(Calendar.DAY_OF_MONTH)%>"
                           monthValue="<%=toCalendar(employee.getBirthDay()).get(Calendar.MONTH)%>"
                           yearValue="<%=toCalendar(employee.getBirthDay()).get(Calendar.YEAR)%>">
    </liferay-ui:input-date>
<%--    <aui:input label="Дата рождения" name="birthDay" type="text" cssClass="add"--%>
<%--               value="<%=toCalendar((employee.getBirthDay()))%>">--%>
<%--        <aui:validator name="date"></aui:validator>--%>
<%--    </aui:input>--%>
    <aui:select label="Должность" name="position" cssClass="add">
        <%
            List<Position> list = PositionLocalServiceUtil.getPositions(0, PositionLocalServiceUtil.getPositionsCount());
            for (Position p : list) {
        %>
        <aui:option value="<%=p.getPositionId()%>"><%=p.getName()%></aui:option>
        <%
            }
        %>
    </aui:select>
    <b>Дата трудоутройства</b>
    <liferay-ui:input-date name="dateOfEmployment" cssClass="add" formName="Дата трудоутройства"
                           dayValue="<%=toCalendar(employee.getDateOfEmployment()).get(Calendar.DAY_OF_MONTH)%>"
                           monthValue="<%=toCalendar(employee.getDateOfEmployment()).get(Calendar.MONTH)%>"
                           yearValue="<%=toCalendar(employee.getDateOfEmployment()).get(Calendar.YEAR)%>">
    </liferay-ui:input-date>
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
    <aui:input label="Работает / не работает" name="archive" checked="<%=!employee.getArchive()%>" type="checkbox"/>

    <portlet:renderURL var="viewURL">
        <portlet:param name="mvcPath" value="/employee/emp_view.jsp"></portlet:param>
    </portlet:renderURL>

    <aui:button-row>
        <aui:button type="submit"></aui:button>
        <aui:button type="cancel" href="${viewURL}"></aui:button>
    </aui:button-row>
</aui:form>
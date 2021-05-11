<%@ include file="/init.jsp" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="company.service.PositionLocalServiceUtil" %>
<%@ page import="javax.portlet.RenderResponse" %>

<liferay-theme:defineObjects/>

<%!
    RenderRequest renderRequest;
    RenderResponse renderResponse;
%>

<portlet:defineObjects/>

<%
    PortletURL portletURL = renderResponse.createRenderURL();
%>
<div>
    <div>
        <h4><liferay-ui:message key="banks.caption"/></h4>
    </div>

    <div class="button">
        <portlet:renderURL var="banksViewURL">
            <portlet:param name="mvcPath" value="/bank/bank_view.jsp"/>
        </portlet:renderURL>
        <portlet:renderURL var="bankAddURL">
            <portlet:param name="mvcPath" value="/bank/bank_add.jsp"/>
        </portlet:renderURL>

        <aui:button-row>
            <aui:button href="${banksViewURL}" value="Просмотреть"></aui:button>
            <aui:button href="${bankAddURL}" value="Добавить"></aui:button>
        </aui:button-row>
    </div>
</div>

<div  style="clear: both">
    <div>
        <h4><liferay-ui:message key="employee.caption"/></h4>
    </div>
    <div class="button">
        <portlet:renderURL var="empViewURL">
            <portlet:param name="mvcPath" value="/employee/emp_view.jsp"/>
        </portlet:renderURL>
        <portlet:renderURL var="empAddURL">
            <portlet:param name="mvcPath" value="/employee/emp_add.jsp"/>
        </portlet:renderURL>

        <aui:button-row>
            <aui:button href="${empViewURL}" value="Просмотреть"></aui:button>
            <aui:button href="${empAddURL}" value="Добавить"></aui:button>
        </aui:button-row>
    </div>
</div>


<div style="clear: both">
    <div>
        <h4><liferay-ui:message key="pos.caption"/></h4>
    </div>
    <div class="button">
        <portlet:renderURL var="posViewURL">
            <portlet:param name="mvcPath" value="/position/pos_view.jsp"/>
        </portlet:renderURL>
        <portlet:renderURL var="posAddURL">
            <portlet:param name="mvcPath" value="/position/pos_add.jsp"/>
        </portlet:renderURL>

        <aui:button-row>
            <aui:button href="${posViewURL}" value="Просмотреть"></aui:button>
            <aui:button href="${posAddURL}" value="Добавить"></aui:button>
        </aui:button-row>
    </div>
</div>


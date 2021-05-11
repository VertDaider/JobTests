<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="company.model.Position" %>
<%@ page import="company.service.PositionLocalServiceUtil" %>
<%@ include file="/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    long posId = ParamUtil.getLong(request, "posId");
    Position position = PositionLocalServiceUtil.getPosition(posId);
%>

<portlet:actionURL name="editPos" var="editPosURL">
    <portlet:param name="posId" value="<%=String.valueOf(position.getPositionId())%>"/>
</portlet:actionURL>

<aui:form action="${editPosURL}" name="fm">

    <aui:model-context bean="<%= position %>" model="<%= Position.class %>"/>

    <aui:input label="Должность" name="name" type="text" cssClass="add">
        <aui:validator errorMessage="errorInputMessage" name="required"/>
    </aui:input>
    <aui:input label="В архиве" name="archive" checked="<%=position.getArchive()%>" type="checkbox"/>

    <portlet:renderURL var="viewURL">
        <portlet:param name="mvcPath" value="/position/pos_view.jsp"></portlet:param>
    </portlet:renderURL>

    <aui:button-row>
        <aui:button type="submit"></aui:button>
        <aui:button type="cancel" href="${viewURL}"></aui:button>
    </aui:button-row>
</aui:form>

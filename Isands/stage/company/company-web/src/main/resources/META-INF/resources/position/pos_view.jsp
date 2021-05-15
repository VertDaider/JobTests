<%@ page import="company.service.PositionLocalServiceUtil" %>
<%@ page import="company.model.Position" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/init.jsp" %>
<%
    List<Position> positionList = PositionLocalServiceUtil.getPositions(0, PositionLocalServiceUtil.getPositionsCount());
%>
<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
</portlet:renderURL>

<liferay-ui:search-container total="<%=positionList.size()%>">
    <liferay-ui:search-container-results results="<%=positionList%>"/>
    <liferay-ui:search-container-row className="company.model.Position" modelVar="position">

        <portlet:renderURL var="editURL">
            <portlet:param name="mvcPath" value="/position/pos_edit.jsp"></portlet:param>
            <portlet:param name="posId" value="<%=String.valueOf(position.getPositionId())%>"/>
        </portlet:renderURL>
        <portlet:actionURL name="deletePos" var="deleteURL">
            <portlet:param name="mvcPath" value="/position/pos_view.jsp"></portlet:param>
            <portlet:param name="posId" value="<%=String.valueOf(position.getPositionId())%>"/>
        </portlet:actionURL>
        <portlet:actionURL name="editArchivePos" var="editArchiveURL">
            <portlet:param name="mvcPath" value="/position/pos_view.jsp"></portlet:param>
            <portlet:param name="posId" value="<%=String.valueOf(position.getPositionId())%>"/>
        </portlet:actionURL>

        <liferay-ui:search-container-column-text name="Должность" property="name"/>
        <liferay-ui:search-container-column-text name="В архиве" cssClass="text-center" href="${editArchiveURL}">
            <% if (position.isArchive()) { %>
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

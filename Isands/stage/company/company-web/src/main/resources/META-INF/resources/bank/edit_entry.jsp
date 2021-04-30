<%@ include file="../init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="view.jsp"></portlet:param>
</portlet:renderURL>

<portlet:actionURL name="addEntry" var="addEntryURL"></portlet:actionURL>


<%@ page import="java.util.List" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/META-INF/resources/init.jsp" %>

<liferay-ui:message key="javax.portlet.title.ru_test_AppPortlet"></liferay-ui:message>

<%
    String dateFirst = ParamUtil.getString(request, "firstDate");
    System.out.println(dateFirst);
%>
<aui:input name="name" value="<%=dateFirst%>" cssClass="add"></aui:input>
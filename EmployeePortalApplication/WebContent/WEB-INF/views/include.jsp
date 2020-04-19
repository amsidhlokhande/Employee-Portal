<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
  <c:set var="contextPath" value="<%=request.getContextPath()%>"/>
  <script type="text/javascript" src="${contextPath}/skin/js/jquery-min.js"></script>
  <script type="text/javascript" src="${contextPath}/skin/js/jquery-ui.js"></script>
  <link type="text/css" rel="stylesheet" href="'<c:url value="${contextPath}/skin/js/jquery-ui.css"/>'">
  
  
</head>

</html>
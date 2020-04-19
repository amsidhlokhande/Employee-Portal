<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="include.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EMPLOYEE MANAGEMENT</title>

<script type="text/javascript" src="${contextPath}/skin/js/employee.js"></script>
<portlet:defineObjects/>
<portlet:actionURL var="addEmployeeActionUrl" id="employee_crud">
	<portlet:param name="action" value="add" />
</portlet:actionURL>
 <portlet:actionURL var="deleteEmployeeActionUrl" name="employee_crud">
	<portlet:param name="action" value="delete" />
</portlet:actionURL>
 <portlet:actionURL var="updateEmployeeActionUrl" name="employee_crud">
	<portlet:param name="action" value="update" />
</portlet:actionURL>
 <portlet:actionURL var="searchEmployeeActionUrl" name="employee_crud">
	<portlet:param name="action" value="search" />
</portlet:actionURL>
</head>


 
<body>
   
   <form:form action="#" id="employeeEnrollementForm" method="post" modelAttribute="employee">
           <table align="center" border="2" bgcolor="pink">
             <tr>
                <td>Employee Name :</td>
                <td><form:input path="empName"/> </td>
             </tr>
             <tr>
                <td>Company Name :</td>
                <td><form:input path="companyName"/></td>
             </tr>
             <tr>
                <td>Joining Date:</td>
                <td><form:input path="joiningDate"/></td>
             </tr>
             <tr>
                <td>Mobile Number :</td>
                <td><form:input path="mobileNumber"/></td>
             </tr>
             <tr>
                <td>Email ID :</td>
                <td><form:input path="emailId"/></td>
             </tr>
             <tr>
                <td>Address :</td>
                <td><form:input path="address"/></td>
             </tr>
             <tr>
                <td colspan="2" align="center">
                 <input type="button" value="add" onclick="submittedAction('${addEmployeeActionUrl}');"/>
                 <%-- <input type="button" value="delete" onclick="submittedAction(${deleteEmployeeActionUrl},${employee});"/>
                 <input type="button" value="update" onclick="submittedAction(${updateEmployeeActionUrl},${employee});"/>
                 <input type="button" value="search" onclick="submittedAction(${searchEmployeeActionUrl},${employee});"/> --%>
                </td>
             </tr>
          </table>
   </form:form>
 
 <input type="hidden" id="message" value="${message}">
    
   <h3 align="center">List Of Students</h3>
   <c:if test="${!empty employeeList}">
      
      <table align="center" border="2" bgcolor="pink">
          <tr>
             <th>EMPLOYEE ID</th>
             <th>EMPLOYEE NAME</th>
             <th>JOINING DATE</th>
             <th>CONATCT NUMBER</th>
             <th>EMAILID</th>
             <th>ADDRESS</th>
          </tr>
          <c:forEach items="${employeeList}" var="employee">
          <tr>
             <td>${employee.empId}</td>
             <td>${employee.empName}</td>
             <td>${employee.joiningDate}</td>
             <td>${employee.mobileNumber}</td>
             <td>${employee.emailId}</td>
             <td>${employee.address}</td>
          </tr>
          </c:forEach>
      </table>
   </c:if>
    
</body>
</html>

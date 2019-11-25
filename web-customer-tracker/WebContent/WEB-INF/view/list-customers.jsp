<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>List customer</title>


<!-- --reference oue style sheet -->

   <link type="text/css" 
         rel="stylesheet"
         href="${pageContext.request.contextPath}/resources/css/style.css"/>



</head>
<body>
<div id="wrapper">
    <div id="header">
    <h2>CRM- Customer Relationship Manager</h2>
    
    </div>  
  </div>
  
   <div id="container">
   
    <div id="content">
    
    
    <!-- --put new button: add Customer--- -->
    
    <a href="showFormForAdd">Add Customer</a>

   <!-- --add our html table here --> 
         <table>
         <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Update</th>
         </tr>
         
         
      <!---- loop over  and print our customers-- -->
      <c:forEach var="tempCustomer" items="${customers}"> 
      
      <!-- construct the update link with customer id -->
      <c:url var="updateLink" value="showFormForUpdate" >
        <c:param name="customerId" value="${tempCustomer.id}"/>
     </c:url>
     
      <!-- construct the delete link with customer id -->
      <c:url var="deleteLink" value="/delete" >
        <c:param name="customerId" value="${tempCustomer.id}"/>
      </c:url>
      
          <tr>
               <td>${tempCustomer.firstName}</td>
              <td>${tempCustomer.lastName}</td>
              <td>${tempCustomer.email}</td>
              
              <td>
              <!-- update the link -->
              <a href="${updateLink}">Update</a>
              |
              <a href="${deleteLink}"
                 onclick="if(!(confirm('Are yoy sure you want to Delete this Customer?'))) return false">Delete</a>
              </td>
         </tr>
         
      </c:forEach>
      
      
        </table>
</div>
</div>

</body>
</html>
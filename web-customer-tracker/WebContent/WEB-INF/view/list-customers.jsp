<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>
	
	<!-- reference  style sheet -->

	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	
	<div id="container">
		<div id="content">
		<!-- add customer button -->
		<input type="button" value="Add customer" onclick="window.location.href='showFormForAdd'; return false"
		class="add-button"
		/>
		<br>
			<form:form action="search" method="POST">
				Search customer: <input type="text" name="customername" />
				
				<input type="submit" value="Search" class="add-button" />
			</form:form>
			<!--  add our html table here -->

		
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
					<th>Delete</th>
					
				</tr>
				
				<!-- loop over and print our customers -->
			<c:forEach var="tempCustomer" items="${customer}">
			<!-- Construct and update link with customer id embedded -->
			<c:url var="updatelink" value="/customer/showFormForUpdate">
				<c:param name="customerId" value="${tempCustomer.id}"/>
			</c:url> 
			<c:url var="deletelink" value="/customer/delete">
				<c:param name="customerId" value="${tempCustomer.id}"/>
			</c:url> 
				
					<tr>
						<td> ${tempCustomer.firstName} </td>
						<td> ${tempCustomer.lastName} </td>
						<td> ${tempCustomer.email} </td>
						<td>
							<!-- Update link -->
							<a href="${updatelink}">Update</a>
						</td>
						<td>
							<!-- Delete link -->
										<a href="${deletelink}"
							   onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>










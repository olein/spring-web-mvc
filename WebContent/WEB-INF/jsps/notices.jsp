<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link
	href="${pageContext.request.contextPath}/static/lib/bootstrap/css/bootstrap.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	Hello world!!
	<div class="col-md-6 col-md-offset-3">
		<table class="table table-striped">
			<tr>
				<th>id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Notice</th>
			</tr>
			<c:forEach var="notice" items="${notices}">
				<tr>
					<td><c:out value="${notice.id}"></c:out></td>
					<td><c:out value="${notice.name}"></c:out></td>
					<td><c:out value="${notice.email}"></c:out></td>
					<td><c:out value="${notice.text}"></c:out></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>





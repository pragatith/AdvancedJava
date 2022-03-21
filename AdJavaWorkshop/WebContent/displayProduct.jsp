<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<th>Id</th>
<th>Name</th>
<th>Price</th>
</tr>
<c:forEach items="${requestscope:productList}" var="product">
<tr>
<td><c:out value="${product.id}"></c:out></td>
<td><c:out value="${product.name}"></c:out></td>
<td><c:out value="${product.price}"></c:out></td>
</tr>
</c:forEach>

</table>
</body>
</html>
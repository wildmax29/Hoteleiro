<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Categoria</title>
</head>
<body>
	 <table >
	
		<tr>
			<th>NOME DA CATEGORIA</th>
			<th>VALOR</th>
		</tr>
		
		<c:forEach var="v" items="${listarCategoria}">
			<tr>
				<td>${v.Categoria["nomeCategoria"]}</td>
				<td><fmt:formatNumber value="${v.Categoria['precoCategoria']}" type="currency"/></td>
			
				
				
			</tr>
		</c:forEach>
	</table>


</body>
</html>
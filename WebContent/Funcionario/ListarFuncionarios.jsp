<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar FUncionario</title>
</head>
<body>
	 <table >
	
		<tr>
			<th>NOME DO FUNCIONARIO</th>
			<th>LOGIN</th>
		</tr>
		
		<c:forEach var="v" items="${listarFuncionario}">
			<tr>
				<td>${v.Funcionario["nomeFuncionario"]}</td>
				<!--  <td><fmt:formatNumber value="${v.Funcionario['precoCategoria']}" type="currency"/></td>-->
			
				
				
			</tr>
		</c:forEach>
	</table>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Quartos</title>
</head>
<body>
	<table >
	
		<tr>
			<th>NUMERO DO QUARTO</th>
			<th>STATUS</th>
		</tr>
		
		<c:forEach var="v" items="${listarQuartos}">
			<tr>
				<td>${v.numeroQuarto}</td>
				<td>${v.statusQuarto}</td>
    			<td><a href="/hoteleiro/Quarto?acao=excluir&id_quarto=${v.idQuarto}">Excluir</a></td>
    			<td><a href="/hoteleiro/Quarto?acao=exibirAlterar&id_quarto=${v.idQuarto}">Alterar</a></td>

			</tr>
		</c:forEach>
	</table>

	

</body>
</html>
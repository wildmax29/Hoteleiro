<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Hospede</title>
</head>
<body>

	<table>

		<tr>
			<th>NOME DO HOSPEDE</th>
			<th>EMAIL DO HOSPEDE</th>
			<th>CPF DO HOSPEDE</th>
		</tr>

		<c:forEach var="v" items="${listaHospede}">
			<tr>
				<td>${v.nome_hospede}</td>
				<td>${v.email_hospede}</td>
				<td>${v.cpf_hospede}</td>
				<td><a href="/hoteleiro/Hospede?acao=excluir&id_hospede=${v.idHospede}">Excluir</a></td> 
				<td><input type="button" onclick="location='/hoteleiro/Hospede?acao=exibirAlterar&id_hospede=${v.idHospede}'" value="alterar"/></td>
				
			</tr>
		</c:forEach>
	
	</table>
		<button type="button" onclick="location='/hoteleiro/Index.jsp'" >Cancelar</button><br>
		</body>
<%@page import="servlet.Paths"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

<title>CADASTRAR RESERVA</title>
<!-- Bootstrap Core CSS -->
    <link href="../boostrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../boostrap/css/sb-admin.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="../boostrap/css/plugins/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../boostrap/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

</head>
<body>
<form role="form" method="post" action="/hoteleiro/Reserva?acao=inserir">
                            <p>	<a>Quarto</a><p>
				<select name="numero_quarto">
					<c:forEach var="c" items="${listarQuartos}">
						<option value="${c.idQuarto}">
							<c:out value="${c.numeroQuarto}" />
						</option>
					</c:forEach>
				</select>
			</p>


                            
                            <p>	<a> Hospede</a><p>
				<select name="nome_hospede">
					<c:forEach var="c" items="${listarHospedes}">
						<option value="${c.idHospede}">
							<c:out value="${c.nome_hospede}" />
						</option>
					</c:forEach>
				</select>
			</p>
                             
                           <center><input type="submit" name="acao" value="inserir"></input>
                           
                            <button type="button" onclick="location='/hoteleiro/Index.jsp'" >Cancelar</button><br></center>
			</form>

</body>
</html> 
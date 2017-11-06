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

<title>CADASTRO DE QUARTO</title>
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


                <div class="row">
                    <div class="col-lg-6">
			
                        <form role="form" method="post" action="../Hospede">

                            <div class="form-group">
                                <center><label><b>CADASTRO DE QUARTO</b></label></center>
                                </br>
                               </br>
                                <input name="numero_quarto"class="form-control" placeholder="Número do Quarto" >
                               
                                <p class="help-block">NÚMERO DO QUARTO</p>
                            </div>

                            <div class="form-group">
                               
                                <select name="status_quarto">
  									<option  value="0">Ocupado</option>
 									<option name="disponivel" value="1">Disponivel</option>
						</select>
						 <p class="help-block">STATUS</p>
                            </div>
                            
                            <p>	<a> Categoria</a><p>
				<select name="nome_categoria">
					<c:forEach var="c" items="${listarCategoria}">
						<option value="${c.idCategoria}">
							<c:out value="${c.nomeCategoria}" />
						</option>
					</c:forEach>
				</select>
			</p>
                             
                           <center><input type="submit" name="acao" value="inserir"></input>
                           
                            <button type="submit" class="btn btn-secudary">Cancelar</button></center>
			</form>

</body>
</html> 
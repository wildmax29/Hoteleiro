<%@page import="servlet.Paths"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

<title>CADASTRO DE HOSPEDE</title>
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
			<%
						if(request.getAttribute("msg") != null){
							out.println(request.getAttribute("msg"));
						}
                    
                    %>
                        <form role="form" method="post" action="../Categoria">

                            <div class="form-group">
                                <center><label><b>CADASTRO DE HOSPEDE</b></label></center>
                                </br>
                               </br>
                                <input name="nome_categoria"class="form-control" placeholder="Nome da Categoria" >
                               
                                <p class="help-block">NOME DA CATEGORIA</p>
                            </div>

                            <div class="form-group">
                                <input name="preco_categoria" class="form-control" placeholder="R$">
                                <p class="help-block">PRECO</p>
                            </div>
                             
                           <center><input type="submit" name="acao" value="inserir"></input>
                           
                            <button type="submit" class="btn btn-secudary">Cancelar</button></center>
			</form>

</body>
</html> 
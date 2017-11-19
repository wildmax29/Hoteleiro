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

<title>ALTERAR FUNCIONARIO</title>
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
                        <form role="form" method="post" action="../hoteleiro/Hospede?acao=alterar&id_hospede=${hospede.idHospede}">

                            <div class="form-group">
                                <center><label><b>ALTERAR HOSPEDE</b></label></center>
                                </br>
                               </br>
                                <p class="help-block">NOME DO HOSPEDE </p>
                                <input name="nome_hospede"class="form-control" value="${hospede.nome_hospede}" >
                               
                               
                            </div>

                            <div class="form-group">
                            	<p class="help-block">EMAIL</p>
                                <input name="email_hospede" class="form-control" value="${hospede.email_hospede}">
                                
                            </div>
                             <div class="form-group">
                             <p class="help-block">CPF</p>
                                <input name="cpf_hospede" class="form-control"  value="${hospede.cpf_hospede}">
                                
                            </div>
                            
                           <center><input type="submit" name="acao" value="alterar"></input>
                           
                            <button type="button" onclick="location='/hoteleiro/Index.jsp'" >Cancelar</button><br>
                                                       
			</form>

</body>
</html> 
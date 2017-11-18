

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bem vindo ao Sistema Hoteleiro</title>
</head>
<body>
 	BEM VINDO! AO SISTEMA HOTELEIRO!
 	
 	
 	 <button type="button" onclick="location='/hoteleiro/WebContent/Funcionario/InserirFuncionario'" >Cadastrar Funcionario</button>
 	
 	<button type="button" onclick="location='/hoteleiro/Quarto?acao=CadastrarQuarto'" value= "CadastrarQuarto" >Cadastrar Quarto</button>
 	<button type="button" onclick="location='/hoteleiro/Categoria?acao=listarCategoria'" value= "ListarCategorias" >Listar Categoria</button>
 	<button type="button" onclick="location='/hoteleiro/Funcionario?acao=listarFuncionarios'" value= "ListarFuncionarios" >Listar Funcionarios</button>
 	<button type="button" onclick="location='/hoteleiro/Quarto?acao=listarQuartos'" value= "listarQuartos" >Listar Quartos</button>	
 	<button type="button" onclick="location='/hoteleiro/Hospede?acao=listarHospede'" value= "ListarHospede" >Listar Hospede</button>	
	
 	
</body>
</html>
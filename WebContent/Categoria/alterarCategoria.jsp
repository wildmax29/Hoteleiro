<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar Categoria</title>
</head>
<body>
	
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	
	<body>
	<form method="post" action="Hospede">
	<c:import url="../ItensComuns/Menu.jsp" />
	
	<h1>Alterar categoria de produto</h1>
	<fieldset> 
	    <legend>Categoria de Produto</legend>
	     
	    <div> 
	        <input type="hidden" name="id" value="${Categoria.id}"></input>
	        <label>Nome
	        	<input name="nome" value="${Categoria.nome}" type="text" size="45" maxlength="45" required="" autofocus=""> 
			</label>			
			<label>Preco
	        	<input name="preco" value="${Categoria.preco}" type="text" size="45" maxlength="45" required="" autofocus=""> 
			</label>			
			
	    
	    <div> 
		    <br>
		    <input type="hidden" name="acao" value="alterar"></input>
		    <input type="submit" value="Alterar" > 
	    </div>
	    
	  </fieldset>
	   
	</form> 
	</body>
</html>
</body>
</html>
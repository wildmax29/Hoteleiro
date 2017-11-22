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
	


	
	<h1>Alterar categoria do quarto</h1>
	<fieldset> 
	    <legend>Categoria do Quarto</legend>
	      <form role="form" method="post" action="../hoteleiro/Categoria?acao=alterar&id_categoria=${categoria.idCategoria}">
    <div> 
	        <input type="hidden" name="id_categoria" value="${categoria.idCategoria}"></input>
	        <label>Nome
	        	<input name="nome_categoria" value="${categoria.nomeCategoria}" type="text" size="45" maxlength="45" required="" autofocus=""> 
			</label>			
			<label>Preco
	        	<input name="preco_categoria" value="${categoria.precoCategoria}" type="number" size="45" maxlength="45" required="" autofocus=""> 
			</label>			
			
	    
	    <div> 
		    <br>
		    <input type="submit"acao" value="alterar"></input>
		    <button type="button" onclick="location='/hoteleiro/Index.jsp'" >Cancelar</button><br>
		     
	    </div>
	    
	  </fieldset>
	   
	</form> 
	</body>
</html>
</body>
</html>
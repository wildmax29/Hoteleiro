<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>LOGIN HOTEL VILMAX</title>
</head>

<form action="/hoteleiro/Login" method="post" >
	<font style='font-weight:bold;'>
	<div class="login_div" >
		<h1>Sistema Hoteleiro</h1>
		
		<input type="hidden" name="acao" value="Logar"/>
	
		<p>	<font color="red" size="3" ><b><c:out value="${mensagem}" /> </b></font>	
		<p> Usuario: <input type="text" name="login_funcionario"  required="" autofocus="" size="15" maxlength="45"/>
		<p> Senha: <input type="password" name="senha_funcionario" required="" autofocus="" size="15" maxlength="10"  />
		<p><input type="submit" value="Login" />
		
	</div>
		
	</font>	
	</form>
</body>
</html>
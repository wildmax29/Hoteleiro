package servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Login Servlet", urlPatterns = "/Login")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		if(acao.equals("Logar")){
			Funcionario u = new Funcionario();
			u.setNome( request.getParameter("user"));
		 	u.setSenha(request.getParameter("senha"));
		 	UsuarioService service = new UsuarioService();
		 	try {
		 		u = service.verificarLogin(u);
		 		if(u != null){
					request.getSession().setAttribute("situacao", "Usuario logado");
					request.getSession().setAttribute("usuarioIdLogado", u.getId());
					request.getSession().setAttribute("usuarioNomeLogado", u.getNome());
					response.sendRedirect("/SuperLanches/index.jsp");
				}else{
					request.setAttribute("mensagem", "Login inválido.");
					request.getRequestDispatcher("/Login.jsp").forward(request, response);
				}
			} catch (SistemaException e) {
				
				e.printStackTrace();
			}
		 	
		 	
		}else{
			response.sendRedirect("/SuperLanches/Login.jsp");
		}
	}
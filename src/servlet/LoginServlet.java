package servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Funcionario;
import services.FuncionarioService;


@WebServlet("/Login")
public class LoginServlet extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (req.getSession(false) !=null) {
			req.getSession().invalidate();
		}
		resp.sendRedirect("/hoteleiro/Login.jsp");		
		

	

	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		String user = request.getParameter("login_funcionario");
		String senha = request.getParameter("senha_funcionario");
		
		if(acao.equals("Logar")){
			
			FuncionarioService service = new FuncionarioService();
			boolean retorno = service.login(user, senha);
			
			if(!retorno) {
				request.getSession().invalidate();
				request.setAttribute("mensagem", "Login inválido.");
				request.getRequestDispatcher("/Login.jsp").forward(request, response);
				System.out.println("Senha errada, idiota!");
			}else {
				request.getSession().setAttribute("situacao", "Usuario logado");
				//request.getSession().setAttribute("usuarioIdLogado", f.getIdFuncionario());
				//request.getSession().setAttribute("usuarioNomeLogado", f.getLoginFuncionario());
				response.sendRedirect("/hoteleiro/Index.jsp");
			}
			
//			Funcionario f = new Funcionario();
//			f.setLoginFuncionario("login_funcionario");
//		 	f.setSenhaFuncionario(request.getParameter("senha_funcionario"));
//		 	FuncionarioService service = new FuncionarioService();
//		 	
//		 	try {
//		 		List<Funcionario> funcionarios = service.listarTodosFuncionarios();
//		 		if(f != null){
//					request.getSession().setAttribute("situacao", "Usuario logado");
//					request.getSession().setAttribute("usuarioIdLogado", f.getIdFuncionario());
//					request.getSession().setAttribute("usuarioNomeLogado", f.getLoginFuncionario());
//					response.sendRedirect("/hoteleiro/Index.jsp");
//				}else{
//					request.setAttribute("mensagem", "Login inválido.");
//					request.getRequestDispatcher("/Login.jsp").forward(request, response);
//				}
//			} catch (Exception e) {
//				
//				e.printStackTrace();
//			}
		 	
		 	
		}else{
			request.getSession().invalidate();
			System.out.println("saindo.............");
			response.sendRedirect("/hoteleiro/Login.jsp");
		}
	}
}

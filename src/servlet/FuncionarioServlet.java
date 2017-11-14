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
import services.Validacao;



@WebServlet("/Funcionario")
public class FuncionarioServlet extends HttpServlet {
	
			
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String acao = request.getParameter("acao");
			String botao = request.getParameter("b1");
			if(botao != null){
				acao = "menu";
			}
			
			
			if(acao.equals("inserir")){
				incluirFuncionario(request, response);
			}else if(acao.equals("exibirInserir")){
				request.getRequestDispatcher("/Funcionario/InserirFuncionario.jsp").forward(request, response);
			}else if(acao.equals("exibirAlterar")){
				exibirFuncionario(request, response);
			}else if(acao.equals("alterar")){
				alterarFuncionario(request, response);
			}else if(acao.equals("excluir")){
				excluirFuncionario(request, response);
			}else if(acao.equals("listarFuncionarios")){
				listarFuncionarios(request, response);
			}else if(acao.equals("pesquisarFuncionarios")){
				pesquisarFuncionario(request, response);
			}else if(acao.equals("exibirPesquisarFuncionarios")){
				request.getRequestDispatcher("/funcionario/pesquisarFuncionario.jsp").forward(request, response);
			}else if(acao.equals("menu")){
				response.sendRedirect("index.jsp");
			}
		}
		
		private void pesquisarFuncionario(HttpServletRequest request, HttpServletResponse response) throws ServletException  {
			try {
				Funcionario us = new Funcionario();

				boolean peloMenosUmCampo = false;
				
				if (!Validacao.campoVazio(request.getParameter("nome"))) {
					peloMenosUmCampo = true;
					us.setNome_funcionario(request.getParameter("nome"));	
				}
				
				if (!Validacao.campoVazio(request.getParameter("login"))){
					peloMenosUmCampo = true;
					us.setLoginFuncionario(request.getParameter("login"));
				}
				
				if (!Validacao.campoVazio(request.getParameter("senha"))){
					peloMenosUmCampo = true;
					us.setSenhaFuncionario(request.getParameter("senha"));
				}
				
				if (peloMenosUmCampo == false){
					request.setAttribute("mensagem", "Pelo menos um campo deve ser preenchido.");
					request.getRequestDispatcher("Funcionario?acao=exibirPesquisarFuncionarios").forward(request, response);
				}
				
				List<Funcionario> lista = new FuncionarioService().pesquisarFuncionarios(us);
				
				if (lista.isEmpty()){
					request.setAttribute("mensagem", "Nenhum registro encontrado para o filtro informado.");
					request.getRequestDispatcher("Funcionario?acao=exibirPesquisarFuncionarios").forward(request, response);
				}
				
				request.setAttribute("listaFuncionario", lista);
				request.getRequestDispatcher("/funcionario/relatorioFuncionario.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}
		
		
		private void incluirFuncionario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Funcionario us = new Funcionario();
			us.setNome_funcionario(request.getParameter("nome_funcionario"));
			us.setLoginFuncionario(request.getParameter("login_funcionario"));
			us.setSenhaFuncionario(request.getParameter("senha_funcionario"));
							
			try {
				FuncionarioService service = new FuncionarioService();
				service.incluirFuncionario(us);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
			
			request.setAttribute("mensagem", "Funcionario inserido com sucesso.");
			
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			
		}
		
		private void exibirFuncionario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
				FuncionarioService service = new FuncionarioService();
				Funcionario funcionario = service.consultarFuncionarioPorId(Integer.valueOf(request.getParameter("id")));
				
				request.setAttribute("funcionario", funcionario);
				request.getRequestDispatcher("/funcionario/alterarFuncionario.jsp").forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
			
		}

		
		private void alterarFuncionario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
				FuncionarioService service = new FuncionarioService();
				Funcionario us = new Funcionario();
				
				us = service.consultarFuncionarioPorId(Integer.valueOf(request.getParameter("id_funcionario"))); 
				
				us.setNome_funcionario(request.getParameter("nome_funcionario"));
				us.setLoginFuncionario(request.getParameter("login_funcionario"));
				us.setSenhaFuncionario(request.getParameter("senha_funcionario"));
				
				service.alterarFuncionario(us);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
			
			request.setAttribute("mensagem", "Funcionario alterado com sucesso.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		
		private void listarFuncionarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
				List<Funcionario> listarFuncionario = new FuncionarioService().listarTodosFuncionarios();
				request.setAttribute("listarFuncionarios", listarFuncionario);
				request.getRequestDispatcher("/Funcionario/ListarFuncionarios.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}
		
		private void excluirFuncionario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Funcionario us = new Funcionario();
			us.setIdFuncionario(Integer.valueOf(request.getParameter("id")));
			
			try {
				FuncionarioService service = new FuncionarioService();
				service.excluirFuncionario(us);
			} catch (Exception e) {
				if (e.getMessage().contains("foreign key constraint")) {
					request.setAttribute("mensagem", "Não é possível excluir este Funcionario ");
					listarFuncionarios(request, response);
				}
				
				e.printStackTrace();
				throw new ServletException(e);
			}
			
			request.setAttribute("mensagem", "Funcionario excluido com sucesso!");
			listarFuncionarios(request, response);
		}
		
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
		}
		
}
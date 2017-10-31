package servlet;

	import java.io.IOException;
	import java.util.List;

	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

import modelo.Quarto;
import services.QuartoService;


@WebServlet("/Quarto")
public class QuartoServlet extends HttpServlet {
			
		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String acao = request.getParameter("acao");
			String botao = request.getParameter("b1");
			if(botao != null){
				acao = "menu";
			}

			if(acao.equals("inserir")){
				incluirQuarto(request, response);
			}else if(acao.equals("exibirInserir")){
				request.getRequestDispatcher("/Quarto/inserirQuarto.jsp").forward(request, response);
			}else if(acao.equals("exibirAlterar")){
				exibirQuarto(request, response);
			}else if(acao.equals("alterar")){
				alterarQuarto(request, response);
			}else if(acao.equals("excluir")){
				excluirQuarto(request, response);
			}else if(acao.equals("listarCategoria")){
				listarQuartos(request, response);
			}else if(acao.equals("menu")){
				response.sendRedirect("index.jsp");
			}
		}

		private void listarQuartos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
				List<Quarto> listarQuarto = new QuartoService().listarTodosQuartos();
				request.setAttribute("listaQuarto", listarQuarto);
				request.getRequestDispatcher("/Quarto/listarQuarto.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
			
		}

		private void excluirQuarto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Quarto q = new Quarto();
			q.setIdQuarto(Integer.valueOf(request.getParameter("id_quarto")));
			
			try {
				QuartoService service = new QuartoService();
				service.excluirQuarto(q);
			} catch (Exception e) {
				if (e.getMessage().contains("foreign key constraint")) {
					request.setAttribute("mensagem", "Não é possível exlcuir esse quarto.");
					listarQuartos(request, response);
				}
				
				e.printStackTrace();
				throw new ServletException(e);
			}
			
			request.setAttribute("mensagem", "quarto excluido com sucesso!");
			listarQuartos(request, response);
			
		}

		private void alterarQuarto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
				QuartoService service = new QuartoService();
				Quarto q = new Quarto();
				
				q = service.consultarQuartoPorId(Integer.valueOf( request.getParameter("id_quarto"))); 
				
				q.setNumeroQuarto(Integer.parseInt(request.getParameter("numero_quarto")));
				service.alterarQuarto(q);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
			
			request.setAttribute("mensagem", "Quarto alterado com sucesso.");
			
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			
		}

		private void exibirQuarto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try{
			QuartoService service = new QuartoService();
			Quarto quarto = service.consultarQuartoPorId(Integer.valueOf(request.getParameter("id_quarto")));
			
			request.setAttribute("quarto", quarto);
			request.getRequestDispatcher("/Quarto/alterarQuarto.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
			
		}

		private void incluirQuarto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Quarto quarto= new Quarto();
			quarto.setNumeroQuarto(Integer.parseInt(request.getParameter("numero_quarto")));
			quarto.setStatusQuarto(Byte.parseByte(request.getParameter("status_quarto")));
			try{
			QuartoService service = new QuartoService();
			service.incluirQuarto(quarto);
			}catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
			
			request.setAttribute("mensagem", "quarto inserido com sucesso.");
			
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}

		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
		}
	}





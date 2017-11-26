package servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.*;
import services.HospedeService;

@WebServlet("/Hospede")
public class HospedeServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		System.out.println(acao);
		String botao = request.getParameter("b1");
		if(botao != null ){
			acao = "menu";
		}
		
		//popularListBoxes(request);
		if(acao.equals("inserir")){
			incluirHospede(request, response);
		}else if(acao.equals("exibirInserir")){
			request.getRequestDispatcher("/Hospede/inserirHospede.jsp").forward(request, response);
		}else if(acao.equals("exibirAlterar")){
			exibirHospede(request, response);
		}else if(acao.equals("alterar")){
			alterarCliente(request, response);
		}else if(acao.equals("excluir")){
			excluirHospede(request, response);
		}else if(acao.equals("listarHospede")){
			listarHospedes(request, response);
		}else if(acao.equals("pesquisarHospede")){
			pesquisarHospede(request, response);
		}else if(acao.equals("exibirPesquisarHospede")){
			request.getRequestDispatcher("/Hospede/pesquisarHospede.jsp").forward(request, response);
		}else if(acao.equals("menu")){
			response.sendRedirect("index.jsp");
		}
	}
	
	private void pesquisarHospede(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			Hospede h = new Hospede();
			
			boolean peloMenosUmCampo = false;
			
			
				h.setNome_hospede(request.getParameter("nome_hospede"));
			
				h.setEmail_hospede(request.getParameter("email_hospede"));
				h.setCpf_hospede(Integer.parseInt(request.getParameter("cpf_hospede")));
				
			
			
				
			if (peloMenosUmCampo == false){
				request.setAttribute("mensagem", "Pelo menos um campo deve ser preenchido.");
				request.getRequestDispatcher("Cliente?acao=exibirPesquisarClientes").forward(request, response);
			}
			
			List<Hospede> lista = new HospedeService().pesquisarHospedes(h);
			
			if (lista.isEmpty()){
				request.setAttribute("mensagem", "Nenhum registro encontrado para o filtro informado.");
				request.getRequestDispatcher("Hospede?acao=exibirPesquisarHospede").forward(request, response);
			}
			
			request.setAttribute("listaHospede", lista);
			request.getRequestDispatcher("/cliente/relatorioHospede.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

	
	private void excluirHospede(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Hospede h = new Hospede();
		h.setIdHospede(Integer.valueOf(request.getParameter("id_hospede")));
		
		try {
			HospedeService service = new HospedeService();
			service.excluirHospede(h);
		} catch (Exception e) {
			if (e.getMessage().contains("foreign key constraint")) {
				request.setAttribute("mensagem", "Não é possível exlcuir esse cliente pois está sendo usado por uma venda.");
				listarHospedes(request, response);
			}
			
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		request.setAttribute("mensagem", "Cliente excluido com sucesso!");
		listarHospedes(request, response);
		
	
	}
	private void listarHospedes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Hospede> lista = new HospedeService().listarTodosHospede();
			request.setAttribute("listaHospede", lista);
			request.getRequestDispatcher("/Hospede/ListarHospede.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}		
	}
	private void alterarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HospedeService service = new HospedeService();	
			Hospede c = new Hospede();
			
			c = service.consultarHospedePorId(Integer.valueOf( request.getParameter("id_hospede"))); 
			System.out.println(c);
			
			c.setNome_hospede(request.getParameter("nome_hospede"));
			c.setEmail_hospede(request.getParameter("email_hospede"));
			
			c.setCpf_hospede(Integer.parseInt(request.getParameter("cpf_hospede")));
			
			service.alterarHospede(c);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		request.setAttribute("mensagem", "HOSPEDE alterado com sucesso.");
		
		request.getRequestDispatcher("/Index.jsp").forward(request, response);		
	}
	private void exibirHospede(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HospedeService service = new HospedeService();	
			Hospede hospede = service.consultarHospedePorId(Integer.valueOf(request.getParameter("id_hospede")));
			
			request.setAttribute("hospede", hospede);
			request.getRequestDispatcher("/Hospede/AlterarHospede.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
	}
	private void incluirHospede(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Hospede c = new Hospede();
		c.setNome_hospede(request.getParameter("nome_hospede"));
		c.setEmail_hospede(request.getParameter("email_hospede"));
		c.setCpf_hospede(Integer.parseInt(request.getParameter("cpf_hospede")));
		
		
				
		try {
			HospedeService service = new HospedeService();
			service.IncluirHospede(c);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		request.setAttribute("mensagem", "Hospede inserido com sucesso.");
		request.getRequestDispatcher("/Index.jsp").forward(request, response);
		
	}
	private void popularListBoxes(HttpServletRequest request) throws ServletException {
		try {
			List<Hospede> listaCliente = new HospedeService().listarTodosHospede(); 
			
			request.setAttribute("listaCliente", listaCliente);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
	}

}

package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Categoria;
import services.CategoriaService;




@WebServlet("/Categoria")
public class CategoriaServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		String botao = request.getParameter("b1");
		if(botao != null){
			acao = "menu";
		}

		if(acao.equals("inserir")){
			incluirCategoria(request, response);
		}else if(acao.equals("exibirInserir")){
			request.getRequestDispatcher("/Categoria/inserirCategoria.jsp").forward(request, response);
		}else if(acao.equals("exibirAlterar")){
			exibirCategoria(request, response);
		}else if(acao.equals("alterar")){
			alterarCategoria(request, response);
		}else if(acao.equals("excluir")){
			excluirCategoria(request, response);
		}else if(acao.equals("listarCategoria")){
			listarCategorias(request, response);
		}else if(acao.equals("menu")){
			response.sendRedirect("index.jsp");
		}
	}

	private void listarCategorias(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Categoria> listarCategoria = new CategoriaService().listarTodasCategorias();
			request.setAttribute("listaCategoria", listarCategoria);
			request.getRequestDispatcher("/Categoria/listarCategorias.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
	}

	private void excluirCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Categoria p = new Categoria();
		p.setIdCategoria(Integer.valueOf(request.getParameter("id_categoria")));
		
		try {
			CategoriaService service = new CategoriaService();
			service.excluirCategoria(p);
		} catch (Exception e) {
			if (e.getMessage().contains("foreign key constraint")) {
				request.setAttribute("mensagem", "Não é possível exlcuir essa categoria de quarto pois está sendo usado por um produto.");
				listarCategorias(request, response);
			}
			
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		request.setAttribute("mensagem", "Categoria de quarto excluido com sucesso!");
		listarCategorias(request, response);
		
	}

	private void alterarCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			CategoriaService service = new CategoriaService();
			Categoria p = new Categoria();
			
			p = service.consultarCategoriaPorId(Integer.valueOf( request.getParameter("id_categoria"))); 
			
			p.setNomeCategoria(request.getParameter("nome_categoria"));
			service.alterarCategoria(p);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		request.setAttribute("mensagem", "Quarto alterado com sucesso.");
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
	}

	private void exibirCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
		CategoriaService service = new CategoriaService();
		Categoria categoria = service.consultarCategoriaPorId(Integer.valueOf(request.getParameter("id_categoria")));
		
		request.setAttribute("quartoCategoria", categoria);
		request.getRequestDispatcher("/Categoria/alterarCategoria.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
	}

	private void incluirCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Categoria categoria= new Categoria();
		categoria.setNomeCategoria(request.getParameter("nome_categoria"));
		categoria.setPrecoCategoria(Float.parseFloat(request.getParameter("preco_categoria")));
		try{
		CategoriaService service = new CategoriaService();
		service.incluirCategoria(categoria);
		}catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		request.setAttribute("mensagem", "Categoria de quarto inserido com sucesso.");
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}


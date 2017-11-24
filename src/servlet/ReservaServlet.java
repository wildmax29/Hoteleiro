package servlet;

	import java.io.IOException;
	import java.util.List;

	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;


import modelo.Hospede;
import modelo.Quarto;
import modelo.Reserva;
import services.HospedeService;
import services.QuartoService;
import services.ReservaService;


@WebServlet("/Reserva")
public class ReservaServlet extends HttpServlet {
			@Override
			protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doPost(req, resp);
			
			}
		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String acao = request.getParameter("acao");
			String botao = request.getParameter("b1");
			if(botao != null){
				acao = "menu";
			}

			if(acao.equals("inserir")){
				incluirReserva(request, response);
			}else if(acao.equals("exibirInserir")){
				request.getRequestDispatcher("/Reserva/InserirReserva.jsp").forward(request, response);
			}else if(acao.equals("menu")){
				response.sendRedirect("Index.jsp");
			}else if(acao.equals("CadastrarReserva")) {
				try {
					buscarListaReserva(response,request);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		private void buscarListaReserva(HttpServletResponse response, HttpServletRequest request) throws Exception {
			QuartoService quarto= new QuartoService();
			
			List<Quarto> listarQuarto = quarto.listarTodosQuartos();
			request.setAttribute("listarQuartos", listarQuarto);
		
			HospedeService hospede= new HospedeService();
			
			List<Hospede> listarHospede = hospede.listarTodosHospede();
			request.setAttribute("listarHospedes", listarHospede);
			request.getRequestDispatcher("/Reserva/InserirReserva.jsp").forward(request, response);
			
		}
		private void incluirReserva(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
				
			Reserva reserva=  new Reserva();
			Quarto quarto= new Quarto();
			Hospede hospede = new Hospede();
			quarto.setIdQuarto(Integer.parseInt(request.getParameter("numero_quarto")));
			hospede.setIdHospede(Integer.parseInt(request.getParameter("nome_hospede")));
		
			
			
			ReservaService service = new ReservaService();
			service.incluirReserva(reserva);			
			}catch(Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}

		
		}
}
	





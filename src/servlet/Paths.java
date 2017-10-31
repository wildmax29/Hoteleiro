package servlet;


public class Paths {

	public static final String PATH = "/Hoteleiro/";
	public static final String MENU = PATH + "index.jsp";
	public static final String QUARTO_SERVLET = PATH + "Quarto";
	public static final String CATEGORIA_SERVLET = PATH + "Categoria";
	public static final String HOSPEDE_SERVLET = PATH + "Hospede";
	public static final String FUNCIONARIO_SERVLET = PATH + "Funcionario";
	public static final String LOGIN_SERVLET = PATH + "Login";

	public static long getTime(){
		return System.currentTimeMillis();
	}

}

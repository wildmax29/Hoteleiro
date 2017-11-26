package Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FiltroSeguranca implements Filter {

   

	
	public void destroy() {
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String url = httpServletRequest.getRequestURI();
		HttpSession sessao = httpServletRequest.getSession();
		
		if(sessao.getAttribute("login_funcionario") != null || url.lastIndexOf("Index.jsp") > -1
				|| url.lastIndexOf("/Login") > -1 || url.lastIndexOf("/imagens")>-1 ||url.lastIndexOf("imagem1.jpg")>-1)  {
		
			chain.doFilter(request, response);
			
		}else{
			
			((HttpServletResponse) response).sendRedirect("/hoteleiro/Login.jsp");

		}
	}


	public void init(FilterConfig fConfig) throws ServletException {
	}

}
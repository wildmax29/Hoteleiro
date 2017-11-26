package services;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.bcel.internal.generic.RETURN;

@WebFilter("/*")
public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String url = httpServletRequest.getRequestURI();
		HttpSession sessao = httpServletRequest.getSession();

		if (verificarParamentro(sessao) || url.lastIndexOf("Login.jsp") > -1 || url.lastIndexOf("/Login") > -1
				|| url.lastIndexOf("/img") > -1 || url.lastIndexOf("img02.jpg") > -1) {

			chain.doFilter(request, response);

		} else {

			System.out.println("Sai satanas...");
			((HttpServletResponse) response).sendRedirect("/hoteleiro/Login.jsp");
			
		}

	}

	private Boolean verificarParamentro(HttpSession sessao) {
		boolean a = true;

		try {

			if (!sessao.getAttribute("situacao").equals("Usuario logado")) {
				a = false;
			}
		} catch (Exception e) {

			a = false;
		}
		return a;
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}

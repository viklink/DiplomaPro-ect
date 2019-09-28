package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.UserData;

/**
 * Servlet Filter implementation class UserFilter
 */
public class UserFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session = null;
		if (request instanceof HttpServletRequest) {
			session = ((HttpServletRequest) request).getSession();
			Object obj = session.getAttribute("loggedInUser");
			if (obj != null && obj instanceof UserData) {
				chain.doFilter(request, response);
			} else {
				HttpServletResponse httpResp = (HttpServletResponse) response;
				httpResp.sendError(403);
			}
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/login.jsp");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

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
import static models.UserData.ADMIN_ROLE;

/**
 * Servlet Filter implementation class AdminFilter
 */
public class AdminFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session = null;
		if (request instanceof HttpServletRequest) {
			session = ((HttpServletRequest) request).getSession(false);
			Object obj = session.getAttribute("loggedInUser");
			if (obj != null && obj instanceof UserData) {
				UserData userData = (UserData) obj;
				String role = userData.getRole();
				if (role.equals(ADMIN_ROLE)) {
					chain.doFilter(request, response);
				} else {
					responseNotAllowed(response);
				}
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/login.jsp");
			}
		}

	}

	private void responseNotAllowed(ServletResponse response) throws IOException {
		HttpServletResponse httpResp = (HttpServletResponse) response;
		httpResp.sendError(403, "You are not allowed to access this resource");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import impl.DefaultOrderDao;
import impl.DefaultTourDao;
import impl.DefaultUserDao;
import models.OrderData;
import models.TourData;
import models.UserData;

/**
 * Servlet implementation class SaveOrderServlet
 */
public class SaveOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DefaultTourDao tourDao;
	private DefaultUserDao userDao;
	private DefaultOrderDao orderDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		tourDao = DefaultTourDao.getTourDaoInstance();
		List<TourData> tours = tourDao.getAllTours();
		request.setAttribute("tours", tours);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/order.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userEmail = (String) session.getAttribute("userEmail");
		userDao = DefaultUserDao.getUserDaoInstance();
		UserData user = userDao.getUserByEmail(userEmail);
		
		String save = request.getParameter("save");
		if (save != null) {
		OrderData order = new OrderData();
		order.setUserId(user.getId());
		order.setTourId(Integer.valueOf(save));
		order.setDate(request.getParameter("date"));
		order.setPersonNum(Integer.valueOf(request.getParameter("personNum")));
		orderDao = DefaultOrderDao.getOrderDaoInstance();
		orderDao.saveOrder(order);
		}
		response.sendRedirect(getServletContext().getContextPath() + "/myaccount");
	}

}

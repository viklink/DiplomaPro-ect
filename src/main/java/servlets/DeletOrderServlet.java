package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import impl.DefaultOrderDao;
import models.OrderData;

/**
 * Servlet implementation class DeletOrderServlet
 */
public class DeletOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	private DefaultOrderDao orderDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer orderId = Integer.valueOf(request.getParameter("orderId"));
		orderDao = DefaultOrderDao.getOrderDaoInstance();
		OrderData orderById = orderDao.getOrderById(orderId);
		response.getWriter().println(orderById);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer orderId = Integer.valueOf(request.getParameter("orderId"));
		orderDao = DefaultOrderDao.getOrderDaoInstance();
		orderDao.deleteOrder(orderId);
		response.getWriter().println("Record is deleted");
	}

}

package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import impl.DefaultOrderDao;
import models.OrderData;

/**
 * Servlet implementation class UpdateOrderServlet
 */
public class UpdateOrderServlet extends HttpServlet {
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
		OrderData order = orderDao.getOrderById(orderId);
		order.setOrderId(orderId);
		order.setUserId(Integer.valueOf(request.getParameter("userId")));
		order.setTourId(Integer.valueOf(request.getParameter("tourId")));
		order.setDate(request.getParameter("date"));
		orderDao.updateOrder(orderId);
		response.getWriter().println(order);
	}
}

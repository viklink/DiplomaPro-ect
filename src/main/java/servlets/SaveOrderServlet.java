package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import impl.DefaultOrderDao;
import models.OrderData;

/**
 * Servlet implementation class SaveOrderServlet
 */
public class SaveOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	private DefaultOrderDao orderDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderData order = new OrderData();
		order.setOrderId(Integer.valueOf(request.getParameter("orderId")));
		order.setUserId(Integer.valueOf(request.getParameter("userId")));
		order.setTourId(Integer.valueOf(request.getParameter("tourId")));
		order.setDate(request.getParameter("date"));
		orderDao = DefaultOrderDao.getOrderDaoInstance();
		orderDao.saveOrder(order);
		response.getWriter().println(order);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderData order = new OrderData();
		order.setOrderId(Integer.valueOf(request.getParameter("orderId")));
		order.setUserId(Integer.valueOf(request.getParameter("userId")));
		order.setTourId(Integer.valueOf(request.getParameter("tourId")));
		order.setDate(request.getParameter("date"));
		orderDao = DefaultOrderDao.getOrderDaoInstance();
		orderDao.saveOrder(order);
		response.getWriter().println(order);
	}

}

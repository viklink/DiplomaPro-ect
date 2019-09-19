package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import impl.DefaultTourDao;
import models.TourData;

/**
 * Servlet implementation class TourByNameServlet
 */
public class TourByNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private DefaultTourDao tourDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		tourDao = DefaultTourDao.getTourDaoInstance();
		TourData tourByName = tourDao.getTourByName(name);
		response.getWriter().println(tourByName);
	}

}

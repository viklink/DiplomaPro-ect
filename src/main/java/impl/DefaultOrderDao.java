package impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.OrderDao;
import models.OrderData;
import models.TourData;
import models.UserData;

public class DefaultOrderDao implements OrderDao {
	
	private static final String JDBC_MYSQL_HOST = "jdbc:mysql://localhost:3306/";
	private static final String MYSQL_JDBC_DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private static final String DB_NAME = "travel  ";
	private static final String PARAMS = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "jogdogJ25";
	
	public static final String SELECT_ORDER_BY_ID = "SELECT * FROM orders WHERE order_id = ?";
	public static final String INSERT_ORDER = "INSERT INTO orders (order_id, user_id, tour_id, date) VALUES (?, ?, ?, ?)";
	public static final String UPDATE_ORDER = "UPDATE orders SET user_id = ?, tour_id = ?, date = ? WHERE order_id = ?";
	public static final String DELETE_ORDER = "DELETE FROM orders WHERE order_id = ?";
	public static final String SELECT_TOUR_BY_USER_ID = "SELECT t.id, t.name, t.price FROM tours_users tu " + 
			"JOIN users u ON u.id = tu.user_id " + 
			"JOIN tours t ON t.id = tu.tour_id " + 
			"WHERE u.id = ?";
	public static final String SELECT_USER_BY_TOUR_COUNT = "SELECT u.name, COUNT(u.id) as tours FROM tours_users tu " + 
			"JOIN users u ON u.id = tu.user_id " + 
			"GROUP BY u.id " + 
			"HAVING(COUNT(u.id)>1)";
	
	private static DefaultOrderDao instance;
	private DefaultOrderDao() {
	}
	public static synchronized DefaultOrderDao getOrderDaoInstance() {
		if(instance == null) {
			instance = new DefaultOrderDao();
		}
		return instance;
	}
	
	@Override 
	public OrderData getOrderById(int orderId) {
		OrderData order = new OrderData();
		try (Connection conn = getConnection();
				PreparedStatement statement = conn.prepareStatement(SELECT_ORDER_BY_ID)) {
			statement.setInt(1, orderId);
			try (ResultSet rs = statement.executeQuery()) {
				while (rs.next()) {
					order.setOrderId(rs.getInt("orderId"));
					order.setUserId(rs.getInt("userId"));
					order.setTourId(rs.getInt("tourId"));
					order.setDate(rs.getString("date"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return order;
	}
	
	@Override
	public boolean saveOrder(OrderData orderData) {
		int rows = 0;
		try (Connection conn = getConnection(); 
				PreparedStatement statement = conn.prepareStatement(INSERT_ORDER)) {
			LocalDate date = LocalDate.of(2020, 7, 28);
			statement.setInt(1, 6);
			statement.setInt(2, 6);
			statement.setInt(3, 5);
			statement.setString(4, date.toString());
			rows = statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (rows != 0) {
			return true;
		} else {
			return false;
		}
	}
	@Override
	public void updateOrder(int id) {
		try (Connection conn = getConnection();
				PreparedStatement statement = conn.prepareStatement(UPDATE_ORDER)) {
			LocalDate date = LocalDate.of(2020, 6, 24);
			statement.setInt(1, 3);
			statement.setInt(2, 5);
			statement.setString(3, date.toString());
			statement.setInt(4, 3);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Order is updated");
	}

	@Override
	public void deleteOrder(int id) {
		try (Connection conn = getConnection();
				PreparedStatement statement = conn.prepareStatement(DELETE_ORDER)) {
			statement.setInt(1, 7);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Order is deleted");
	}
	
	@Override
	public List<TourData> getTourByUserId(int useId) {
		List<TourData> tours = new ArrayList<>();
		try (Connection conn = getConnection();
				PreparedStatement statement = conn.prepareStatement(SELECT_TOUR_BY_USER_ID)) {
				statement.setInt(1, 1);
				try (ResultSet rs = statement.executeQuery()) {
					while (rs.next()) {
						TourData tourData = new TourData();
						tourData.setId(rs.getInt("id"));
						tourData.setName(rs.getString("name"));
						tourData.setPrice(rs.getDouble("price"));
						tours.add(tourData);
						}
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tours;
	}
	@Override
	public UserData getUserByTourCount() {
		UserData userData = null;
		try (Connection conn = getConnection();
				PreparedStatement statement = conn.prepareStatement(SELECT_USER_BY_TOUR_COUNT)) {
			
				try (ResultSet rs = statement.executeQuery()) {
					while (rs.next()) {
						userData = new UserData();
						userData.setId(rs.getInt("id"));
						userData.setName(rs.getString("name"));
						userData.setLastName(rs.getString("last_name"));
						userData.setRoleId(rs.getInt("role_id"));
						}
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userData;
	}
	
	private Connection getConnection() {
		try {
			Class.forName(MYSQL_JDBC_DRIVER_NAME);
			return DriverManager.getConnection(JDBC_MYSQL_HOST + DB_NAME + PARAMS, USERNAME, PASSWORD);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}

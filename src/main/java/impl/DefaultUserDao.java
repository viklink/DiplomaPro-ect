package impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dao.UserDao;
import models.UserData;

public class DefaultUserDao implements UserDao {

	private static final String JDBC_MYSQL_HOST = "jdbc:mysql://localhost:3306/";
	private static final String MYSQL_JDBC_DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private static final String DB_NAME = "travel  ";
	private static final String PARAMS = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "jogdogJ25";

	public static final String SELECT_USER_BY_ID = "SELECT * FROM users WHERE id = ?";
	public static final String SELECT_USER_BY_EMAIL = "SELECT * FROM users WHERE email = ?";
	public static final String INSERT_USER = "INSERT INTO users (id, name, last_name, role, email, password) VALUES (?, ?, ?, ?, ?, ?)";
	public static final String UPDATE_USER_RECORD = "UPDATE users SET name = ?, last_name = ?, role = ?, email = ?, password = ? WHERE id = ?";
	public static final String DELETE_USER_RECORD = "DELETE FROM users WHERE id = ?";
	
	//создание синглтона
	private static DefaultUserDao instance;

	private DefaultUserDao() {	
	}
	
	public static synchronized DefaultUserDao getUserDaoInstance() {
		if(instance == null) {
			instance = new DefaultUserDao();
		}
		return instance;
	}

	@Override
	public UserData getUserById(int id) {
		UserData user = new UserData();
		try (Connection conn = getConnection();
				PreparedStatement statement = conn.prepareStatement(SELECT_USER_BY_ID)) {
			statement.setInt(1, id);
			try (ResultSet rs = statement.executeQuery()) {
				while (rs.next()) {
					user.setId(rs.getInt("id"));
					user.setName(rs.getString("name"));
					user.setLastName(rs.getString("last_name"));
					user.setRole(rs.getString("role"));
					user.setEmail(rs.getString("email"));
					user.setPassword(rs.getString("password"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	@Override
	public UserData getUserByEmail(String email) {
		UserData user = null;
		try (Connection conn = getConnection();
				PreparedStatement statement = conn.prepareStatement(SELECT_USER_BY_EMAIL)) {
			statement.setString(1, email);
			try (ResultSet rs = statement.executeQuery()) {
				while (rs.next()) {
					user = new UserData();
					user.setId(rs.getInt("id"));
					user.setName(rs.getString("name"));
					user.setLastName(rs.getString("last_name"));
					user.setRole(rs.getString("role"));
					user.setEmail(rs.getString("email"));
					user.setPassword(rs.getString("password"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean saveUser(UserData user) {
		int rows = 0;
		try (Connection conn = getConnection(); 
				PreparedStatement statement = conn.prepareStatement(INSERT_USER)) {
			statement.setInt(1, user.getId());
			statement.setString(2, user.getName());
			statement.setString(3, user.getLastName());
			statement.setString(4, user.getRole());
			statement.setString(5, user.getEmail());
			statement.setString(6, user.getPassword());
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
	public void updateUserRecord(int id) {
		try (Connection conn = getConnection();
				PreparedStatement statement = conn.prepareStatement(UPDATE_USER_RECORD)) {
			statement.setString(1, "Ivan");
			statement.setString(2, "Zolotarev");
			statement.setInt(3, 3);
			statement.setInt(4, 6);
			statement.setString(5, "zxcv");
			statement.setInt(6, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Record is updated");
	}
	@Override
	public void deleteUserRecord(int id) {
		try (Connection conn = getConnection();
				PreparedStatement statement = conn.prepareStatement(DELETE_USER_RECORD)) {
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Record is deleted");
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

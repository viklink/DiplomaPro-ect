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
	public static final String INSERT_USER = "INSERT INTO users (id, name, last_name, role_id) VALUES (?, ?, ?, ?)";
	public static final String UPDATE_USER_RECORD = "UPDATE users SET name = ?, last_name = ?, role_id = ? WHERE id = ?";
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
					user.setRoleId(rs.getInt("role_id"));
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
			statement.setInt(1, 7);
			statement.setString(2, "Daniil");
			statement.setString(3, "Bobrov");
			statement.setInt(4, 3);
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
			statement.setInt(1, 7);
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

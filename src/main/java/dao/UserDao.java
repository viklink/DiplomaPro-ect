package dao;


import models.UserData;

public interface UserDao {
	
	UserData getUserById(int id);
	UserData getUserByEmail(String email);
	boolean saveUser(UserData userData);
	void updateUserRecord(int id);
	void deleteUserRecord(int id);

}

package com.project.MobileStoreBackEnd.dao;

import com.project.MobileStoreBackEnd.model.User;

public interface UserDAO {
	public boolean addUser(User user);
	public boolean deleteUser(User user);
	public User getUser(int userID);
	public boolean updateUser(User user);
}

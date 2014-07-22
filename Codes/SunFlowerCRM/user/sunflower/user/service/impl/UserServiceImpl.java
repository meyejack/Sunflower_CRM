package sunflower.user.service.impl;

import java.util.List;

import sunflower.user.dao.UserDao;
import sunflower.user.entity.User;
import sunflower.user.service.UserService;

public class UserServiceImpl implements UserService {
	UserDao userDao;

	public UserServiceImpl() {
		userDao = new UserDao();
	}

	@Override
	public User login(String username, String password) {
		User u = userDao.getUser(username, password);
		return u;
//		if (u != null)
//			if (u.getUserPassword().equals(password))
//				return true;
//		return false;
	}

	@Override
	public boolean addUser(User user) {
		return userDao.saveUser(user);
	}

	@Override
	public User getUser(String userID) {
		return userDao.getUser(userID);
	}

	@Override
	public boolean updateUser(User user) {
		return userDao.updateUser(user);
	}

	@Override
	public List<User> getManagers() {
		return userDao.getManagers();
	}

}

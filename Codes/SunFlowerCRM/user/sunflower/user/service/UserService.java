package sunflower.user.service;

import java.util.List;

import sunflower.user.entity.User;

public interface UserService {
	public User login(String username, String password);

	public boolean addUser(User user);

	public User getUser(String userID);

	public boolean updateUser(User user);
	
	public List<User> getManagers();
}

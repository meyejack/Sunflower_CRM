package sunflower.user.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import sunflower.user.entity.User;
import sunflower.util.support.HibernateUtil;

public class UserDao {
	private Session session;

	public UserDao() {
	}

	// 获取用户by id 已测
	public User getUser(String userID) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		User user = (User) session.get(User.class, userID);
		return user;
	}

	// 获取用户by username 已测
	public User getUser(String username, String password) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		User user = null;
		user = (User) session.createCriteria(User.class)
				.add(Restrictions.eq("userName", username)).uniqueResult();

		return user;
	}

	// // 通过UserName获取用户
	// public User getUser(String userName) {
	// System.out.println("userDao-get user");
	// session = HibernateUtil.getSessionFactory().openSession();
	// session.beginTransaction();
	// System.out.println("userDao-open session");
	// User user = (User) session.get(User.class, userName);
	// //
	// System.out.println("userDao-user:"+user.getUserAccount()+" "+user.getUserName()+" "+user.getUserPassword());
	// System.out.println("userDao-user:" + user);
	// session.close();
	//
	// return user;
	// }

	// 添加用户 已测
	public boolean saveUser(User user) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			user.setUserId("000000000000000000000000000000000000");
			session.save(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// 修改用户
	public boolean updateUser(User user) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			session.update(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	// 删除用户 已测
	public boolean deleteUser(User user) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			session.delete(session.load(User.class, user.getUserId()));
			session.getTransaction().commit();
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	// 得到客户经理列表 已测
	@SuppressWarnings("unchecked")
	public List<User> getManagers() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<User> managers = (List<User>) session.createCriteria(User.class)
				.add(Restrictions.eq("userState", 0))
				.add(Restrictions.eq("userLevel", 1)).list();
		return managers;
	}
}

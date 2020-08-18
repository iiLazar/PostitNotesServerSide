package ilazar.postit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ilazar.postit.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public User getUserByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		Query<User> query = 
				session.createQuery("from User where username=:username", User.class);
		query.setParameter("username", username);

		User user = null;
		try {
			user = query.getSingleResult();
		} catch (Exception e) {
			user = null;
		}
		return user;
	}

	@Override
	public void save(User newUser) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(newUser);
	}

	

}

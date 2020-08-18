package ilazar.postit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ilazar.postit.entity.Role;

@Repository
public class RoleDaoImpl implements RoleDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public Role findRoleByName(String roleName) {
		Session session = sessionFactory.getCurrentSession();
		Query<Role> query =
				session.createQuery("from Role where name=:roleName", Role.class);
		query.setParameter("roleName", roleName);
		
		Role role = null;
		try {
			role = query.getSingleResult();
		} catch (Exception e) {
			role = null;
		}
		
		return role;
	}

}

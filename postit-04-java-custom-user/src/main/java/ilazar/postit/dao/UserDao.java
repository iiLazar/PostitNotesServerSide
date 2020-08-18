package ilazar.postit.dao;

import ilazar.postit.entity.User;

public interface UserDao {

	User getUserByUsername(String username);

	void save(User newUser);

}

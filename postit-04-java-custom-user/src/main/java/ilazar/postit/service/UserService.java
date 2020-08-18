package ilazar.postit.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import ilazar.postit.entity.User;
import ilazar.postit.user.PostitUser;

public interface UserService extends UserDetailsService {

	User getUserByUsername(String username);

	void save(PostitUser user);

}

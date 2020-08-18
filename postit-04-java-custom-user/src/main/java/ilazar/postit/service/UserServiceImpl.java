package ilazar.postit.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ilazar.postit.dao.RoleDao;
import ilazar.postit.dao.UserDao;
import ilazar.postit.entity.Role;
import ilazar.postit.entity.User;
import ilazar.postit.user.PostitUser;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private RoleDao roleDao;
	
	@Override
	@Transactional
	public User getUserByUsername(String username) {
		return userDao.getUserByUsername(username);
	}
	
	@Override
	@Transactional
	public void save(PostitUser postitUser) {
		User newUser = new User();
		newUser.setPassword(passwordEncoder.encode(postitUser.getPassword()));
		newUser.setUsername(postitUser.getUsername());
		newUser.setFirstName(postitUser.getFirstName());
		newUser.setLastName(postitUser.getLastName());
		newUser.setEmail(postitUser.getEmail());
		
		newUser.setRoles(Arrays.asList(roleDao.findRoleByName("ROLE_EMPLOYEE")));
		
		userDao.save(newUser);
	}
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.getUserByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("Username or password are not valid.");
		}

		return new org.springframework.security.core.userdetails.User(
						user.getUsername(), user.getPassword(),
						mapRolesToAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(
														Collection<Role> roles) {

		return roles.stream()
					.map(role -> new SimpleGrantedAuthority(role.getName()))
					.collect(Collectors.toList());
	}

}

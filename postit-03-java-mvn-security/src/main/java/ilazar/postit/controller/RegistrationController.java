package ilazar.postit.controller;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ilazar.postit.user.PostitUser;

@Controller
@RequestMapping("/register")
public class RegistrationController {
	
	@Autowired
	private UserDetailsManager userDetailsManager;
	
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@InitBinder
	public void InitBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor trimmer = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, trimmer);
	}

	
	@GetMapping("/showRegistrationForm")
	public String showRegistrationForm(Model model) {
		model.addAttribute("postitUser", new PostitUser());
		return "registration-form";
	}
	
	@PostMapping("/registerUser")
	public String registerUser(
			@Valid @ModelAttribute("postitUser") PostitUser user,
			BindingResult bindingResult,
			Model model) {
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("postitUser", new PostitUser());
			model.addAttribute("registrationError", "Username and password must be entered.");

			return "registration-form";
		}

		String username = user.getUsername();
		boolean userExists = userDetailsManager.userExists(username);
		
		if(userExists) {
			model.addAttribute("postitUser", new PostitUser());
			model.addAttribute("registrationError", "Username already exists.");

			return "registration-form";
		}
		
		String password = passwordEncoder.encode(user.getPassword());
		password = "{bcrypt}" + password;
		List<GrantedAuthority> authorities =
				AuthorityUtils.createAuthorityList("ROLE_EMPLOYEE");
		User securityUser = new User(username, password, authorities);
		userDetailsManager.createUser(securityUser);
		
		return "registration-success";
	}


}

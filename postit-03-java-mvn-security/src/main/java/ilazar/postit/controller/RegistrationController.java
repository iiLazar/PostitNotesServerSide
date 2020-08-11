package ilazar.postit.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ilazar.postit.dao.NoteDAOImpl;
import ilazar.postit.user.PostitUser;

@Controller
@RequestMapping("/register")
public class RegistrationController {

	
	@GetMapping("/showRegistrationForm")
	public String showRegistrationForm(Model model) {
		System.out.println("------ inside showRegForm -------");
		model.addAttribute("newUser", new PostitUser());
		System.out.println(" --------- model filled --------");
		return "registration-form";
	}
//	
//	@PostMapping("/registerUser")
//	public String registerUser(
//			@Valid @ModelAttribute("newUser") postitUser user,
//			BindingResult bindingResult,
//			Model model) {
//		System.out.println("---- done that ;) -------");
//		return "registration-success";
//	}
//

}

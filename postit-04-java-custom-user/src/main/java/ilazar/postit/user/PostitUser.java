package ilazar.postit.user;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PostitUser {

	@NotNull(message = "required")
	@Size(min = 1, message = "required")
	private String username;
	
	@NotNull(message = "required")
	@Size(min = 1, message = "required")
	private String password;

	@NotNull(message = "required")
	@Size(min = 1, message = "required")
	private String firstName;
	
	@NotNull(message = "required")
	@Size(min = 1, message = "required")
	private String lastName;
	
	@NotNull(message = "required")
	@Size(min = 1, message = "required")
	private String email;
	
	public PostitUser() {
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}

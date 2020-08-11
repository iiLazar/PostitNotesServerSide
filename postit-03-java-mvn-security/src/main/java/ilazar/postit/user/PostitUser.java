package ilazar.postit.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PostitUser {

	@NotNull(message = "required")
	@Size(min = 1, message = "required")
	private String username;
	
	@NotNull(message = "required")
	@Size(min = 1, message = "required")
	private String password;
	
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
	
	
}

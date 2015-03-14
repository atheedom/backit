package je.backit.model;

public class Authenticator {

	public String authenticate(String username, String password) {
		if (("admin".equalsIgnoreCase(username))
				&& ("admin".equals(password))) {
			return "success";
		} else {
			return "failure";
		}
	}
}

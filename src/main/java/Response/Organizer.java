package Response;

public class Organizer {

	private String  email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isSelf() {
		return self;
	}
	public void setSelf(boolean self) {
		this.self = self;
	}
	private boolean self;
}

package altimetrik.greetings.domain;

public class Status {

	private String status;
	private String message;
	private String token;
	
	

	public String getToken() {
		return token;
	}

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public void setToken(String token) {
		this.token = token;
	}

	
}

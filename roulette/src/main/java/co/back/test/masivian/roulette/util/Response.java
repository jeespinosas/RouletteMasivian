package co.back.test.masivian.roulette.util;

import java.util.HashMap;

import org.springframework.http.HttpStatus;

public class Response {

	private String status;
	private String message;
	private HashMap<String, Object> payload;
	
	public Response(HttpStatus status, String message) {
		this.status = status.toString();
		this.message = message;
		this.payload = new HashMap<>();
	}

	public void addPayload(String key, Object value) {
		this.payload.put(key, value);
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

	public HashMap<String, Object> getPayload() {
		return payload;
	}

	public void setPayload(HashMap<String, Object> payload) {
		this.payload = payload;
	}
}

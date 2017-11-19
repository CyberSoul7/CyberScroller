package net.griscraft.cyberscroller.images;

public class InvalidLevelException extends Exception {
	private static final long serialVersionUID = -5056836281378297195L;
	private String reason;
	
	public InvalidLevelException(String reason) {
		this.reason = reason;
	}
	
	public String getReason() {
		return reason;
	}
	
}

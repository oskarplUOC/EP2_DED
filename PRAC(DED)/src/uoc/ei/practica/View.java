package uoc.ei.practica;

import java.util.Date;

public class View {
	
	private String idChannel;
	
	private Program pr;
	
	private String idUser; 
	
	private Date startTime;
	
	public View(String idChannel, Program pr, String idUser, Date startTime) {
		
		this.idChannel = idChannel;
		this.pr = pr;
		this.idUser = idUser;
		this.startTime = startTime;
		
	}
	
	public String getIdChannel() {
		
		return this.idChannel;
	}
	
	public Program getProgram() {
		
		return this.pr;
	}
	
	public String getIdUser() {
		
		return this.idUser;
	}
	
	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		sb.append(this.pr.getIdProgram()).append(", ");
		sb.append(this.pr.getName()).append(", ");
		sb.append(this.pr.getDescription()).append(", ");
		sb.append("(").append(this.pr.getActivityProgram()).append(")");
		
		return sb.toString();
		
	}
		
	
	
}

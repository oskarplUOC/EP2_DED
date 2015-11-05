package uoc.ei.practica;

import java.util.Date;

public class View {
	
	private String idChannel;
	
	private String idProgram;
	
	private String idUser; 
	
	private Date startTime;
	
	public View(String idChannel, String idProgram, String idUser, Date startTime) {
		
		this.idChannel = idChannel;
		this.idProgram = idProgram;
		this.idUser = idUser;
		this.startTime = startTime;
		
	}
	
	public String getIdChannel() {
		
		return this.idChannel;
	}
	
	public String getIdProgram() {
		
		return this.idProgram;
	}
	
	public String getIdUser() {
		
		return this.idUser;
	}
	
	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		sb.append(this.idChannel).append(" ");
		sb.append(this.idProgram).append(" ");
		sb.append(this.idUser).append(" ");
		sb.append(this.startTime).append(Messages.LS);
		
		return sb.toString();
		
	}
		
	
	
}

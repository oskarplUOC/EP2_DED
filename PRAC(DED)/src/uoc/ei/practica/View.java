package uoc.ei.practica;

import java.util.Date;

public class View {
	
	private String idChannel;
	
	private Program program;
	
	private String idUser; 
	
	private Date startTime;
	
	public View(String idChannel, Program program, String idUser, Date startTime) {
		
		this.idChannel = idChannel;
		this.program = program;
		this.idUser = idUser;
		this.startTime = startTime;
		
	}
	
	public String getIdChannel() {
		
		return this.idChannel;
	}
	
	public Program getProgram() {
		
		return this.program;
	}
	
	public String getIdUser() {
		
		return this.idUser;
	}
	
	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		sb.append(this.idChannel).append(" ");
		sb.append(this.program).append(" ");
		sb.append(this.idUser).append(" ");
		sb.append(this.startTime).append(Messages.LS);
		
		return sb.toString();
		
	}
		
	
	
}

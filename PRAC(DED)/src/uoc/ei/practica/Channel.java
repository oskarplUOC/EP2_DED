package uoc.ei.practica;

import java.util.Comparator;

public class Channel {
	
	public static final int PC = 100;
	
	public static final int TOP_10 = 10;
	
	private String idChannel;
	
	private String name;
	
	private String description;
	
	private OrderedVectorProgramChannel<String,Program> programsChannel;
	
	public Channel(String idChannel, String name, String description) {
		
		this.idChannel=idChannel;
		this.name=name;
		this.description=description;
		this.programsChannel = new OrderedVectorProgramChannel<String, Program>(PC, Program.COMP);
	} 
	
	public static Comparator<String>  COMP = new Comparator<String>() {
		
		public int compare(String idChannel0, String idChannel1) {
			
			return idChannel0.compareTo(idChannel1);
		}		
	};
	
	public OrderedVectorProgramChannel<String,Program> getProgramsChannel() {
		
		return this.programsChannel;
	}
	
	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		sb.append(this.idChannel).append(" ").append(this.name).append(" ").append(this.description).append(" ");
				
		return sb.toString();
	}

}

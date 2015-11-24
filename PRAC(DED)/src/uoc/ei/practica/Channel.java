package uoc.ei.practica;

import java.util.Comparator;

import uoc.ei.tads.Iterador;

public class Channel {
	
	public static final int PC = 100;
	
	public static final int TOP_10 = 10;
	
	private String idChannel;
	
	private String name;
	
	private String description;
	
	private OrderedVectorProgramChannel<String,Program> programsChannel;
	
	private ArrayTop channelTop10Program;
	
	public Channel(String idChannel, String name, String description) {
		
		this.idChannel=idChannel;
		this.name=name;
		this.description=description;
		this.programsChannel = new OrderedVectorProgramChannel<String, Program>(PC, Program.COMP1);
		this.channelTop10Program = new ArrayTop();
	} 
	
	public static Comparator<String>  COMP = new Comparator<String>() {
		
		public int compare(String idChannel0, String idChannel1) {
			
			return idChannel0.compareTo(idChannel1);
		}		
	};
	
	public OrderedVectorProgramChannel<String,Program> getProgramsChannel() {
		
		return this.programsChannel;
	}
	
	public ArrayTop getChannelTop10Program() {
		
		return this.channelTop10Program;
	}
	
	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		sb.append(this.idChannel).append(" ").append(this.name).append(" ").append(this.description).append(" ");
				
		return sb.toString();
	}

	public void updateTop10(Program program) {	
		
		if (!this.channelTop10Program.estaPle()) {
			
			boolean found = false;
			
			Iterador<Program> it = this.channelTop10Program.elements();
			
			while(it.hiHaSeguent() && !found) {
				
				if (it.seguent().getIdProgram() == program.getIdProgram()) {
					
					found = true;
				}
			}
			
			if(!found){
				
				this.channelTop10Program.addLastProgram(program);
			}
		}
	}

}

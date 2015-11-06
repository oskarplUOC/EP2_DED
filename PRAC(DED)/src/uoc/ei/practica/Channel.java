package uoc.ei.practica;

import java.util.Comparator;

public class Channel {
	
	public static final int PC = 100;
	
	public static final int TOP_10 = 10;
	
	private String idChannel;
	
	private String name;
	
	private String description;
	
	private ChannelTop10Program[] channelTop10Programs;
		
	private OrderedVector<String,Program> programsChannel;
	
	public Channel(String idChannel, String name, String description) {
		
		this.channelTop10Programs= new ChannelTop10Program[TOP_10];
		this.idChannel=idChannel;
		this.name=name;
		this.description=description;
		this.programsChannel = new OrderedVector<String, Program>(PC, Program.COMP);				
	} 
	
	public static Comparator<String>  COMP = new Comparator<String>() {
		
		public int compare(String arg0, String arg1) {
			
			return arg0.compareTo(arg1);
		}		
	};
	
	public OrderedVector<String,Program> getProgramsChannel() {
		
		return this.programsChannel;
	}
	
	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		sb.append(this.idChannel).append(" ").append(this.name).append(" ").append(this.description).append(" ");
				
		return sb.toString();
	}

	public ChannelTop10Program[] getChannelTop10Programs() {
		
		return this.channelTop10Programs;
	}

}

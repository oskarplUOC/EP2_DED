package uoc.ei.practica;

import java.util.Comparator;

public class Program implements Comparable<Program>{
	
	private String idProgram;

	private String name;

	private String description;
	
	private String idChannel;
	
	private int activityProgram;
	
	private double ratingProgram;
	
	private int nRatingProgram;
	
	private int rating;
	
	public Program(String idProgram, String name, String description, String idChannel) {
		
		this.idProgram = idProgram;
		this.name = name;
		this.description = description;
		this.idChannel = idChannel;
		this.activityProgram = 0;
		this.ratingProgram = 0;
		this.nRatingProgram = 0;
	}
	
	public static Comparator<String>  COMP1 = new Comparator<String>() {
		
		public int compare(String programsChannel0, String programsChannel1) {
			
			return programsChannel0.compareTo(programsChannel1);
		}		
	};
	
	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		
		sb.append(this.idProgram).append(", ").append(this.name).append(", ");
		sb.append(this.description).append(" ").append("views(" + this.activityProgram +") ").append("rating(" + this.getRatingProgram() + ") ");
		
		return sb.toString();
				
	}
	
	public void incActivityProgram() {
		
		this.activityProgram++;
	}
	
	public int getActivityProgram() {
		
		return activityProgram;
	
	}
	
	public void addRating(int rating) {
		
		this.ratingProgram += rating;
		
		this.nRatingProgram++;
		
	}
	
	public double getRatingProgram() {						
		
		double result = (this.nRatingProgram != 0 ? this.ratingProgram/this.nRatingProgram:0);
		
		return result;
	}

	public String getIdProgram() {
		
		return this.idProgram;
	}

	public String getName() {
		
		return this.name;
	}
	
	public String getDescription() {
		
		return this.description;
	}

	public String getIdChannel() {
		
		return idChannel;
	}

	@Override
	public int compareTo(Program p) {
		
		if (activityProgram < p.activityProgram) {
            
			return -1;
        }
        
		if (activityProgram > p.activityProgram) {
            
			return 1;
        }
        
		return 0;
    }

}

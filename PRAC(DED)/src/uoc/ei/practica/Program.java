package uoc.ei.practica;

import java.util.Comparator;

import uoc.ei.tads.Llista;
import uoc.ei.tads.LlistaEncadenada;

public class Program {
	
	private String idProgram;

	private String name;

	private String description;
	
	private String idChannel;
	
	private int activityProgram;
	
	private double ratingProgram;
	
	private int nRatingProgram;
	
	public Program(String idProgram, String name, String description, String idChannel) {
		
		this.idProgram = idProgram;
		this.name = name;
		this.description = description;
		this.idChannel = idChannel;
		this.ratingProgram = 0;
		this.nRatingProgram = 0;
			
	}
	
	public static Comparator<String>  COMP = new Comparator<String>() {
		
		public int compare(String arg0, String arg1) {
			
			return arg0.compareTo(arg1);
		}		
	};
	
	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		
		sb.append(this.idProgram).append(", ").append(this.name).append(", ");
		sb.append(this.description).append(" ").append("views(" + this.activityProgram +") ").append("rating(" + this.rating() + ") ").append(Messages.LS);
		
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

	public double rating() {						
		
		double result = (this.nRatingProgram != 0 ? this.ratingProgram/this.nRatingProgram:0);
		
		return result;
	}

}

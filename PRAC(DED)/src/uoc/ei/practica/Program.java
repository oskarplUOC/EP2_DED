package uoc.ei.practica;

import java.util.Comparator;

import uoc.ei.tads.Llista;
import uoc.ei.tads.LlistaEncadenada;

public class Program {
	
	private String idProgram;

	private String name;

	private String description;
	
	private String idChannel;
	
	private Llista<View> viewsProgram;
	
	private int activityProgram;
	
	private double ratingProgram;
	
	public Program(String idProgram, String name, String description, String idChannel) {
		
		this.idProgram = idProgram;
		this.name = name;
		this.description = description;
		this.idChannel = idChannel;
		this.viewsProgram = new LlistaEncadenada<View>();
	
	}
	
	public static Comparator<String>  COMP = new Comparator<String>() {
		
		public int compare(String arg0, String arg1) {
			
			return arg0.compareTo(arg1);
		}		
	};
	
	public void addView(View view) {
		
		this.viewsProgram.afegirAlFinal(view);
	}

	
	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		
		sb.append(this.idProgram).append(", ").append(this.name).append(", ");
		sb.append(this.description).append(" ").append("views(" + this.activityProgram +") ").append("rating(0.0) ").append(Messages.LS);
		
		return sb.toString();
				
	}

	public void incActivityProgram() {
		
		this.activityProgram++;
	}
	
	public int getActivityProgram() {
		
		return activityProgram;
	
	}

}

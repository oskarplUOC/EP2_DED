package uoc.ei.practica;

import uoc.ei.tads.Contenidor;
import uoc.ei.tads.ContenidorAfitat;
import uoc.ei.tads.Iterador;


public class Top10Program<V> implements ContenidorAfitat<V> {

	private static final long serialVersionUID = 1L;
	
	public static final int TOP_10 = 10;
	
	private Program pr2;
	
	private Contenidor<Top10Program> programs;
	
	private Top10Program[] top10Programs;
	
	public Top10Program(Program pr2) {

		this.pr2 = pr2;
		this.top10Programs= new Top10Program[TOP_10];
	}

	@Override
	public Iterador elements() {
		
		if (this.programs.estaBuit()); 
			
		return programs.elements();			
	}

	@Override
	public boolean estaBuit() {
		
		if (programs.estaBuit()) {
			
			return true;			
		}
		
		return false;		
	}

	@Override
	public int nombreElems() {
		
		return this.programs.nombreElems();
	}

	@Override
	public boolean estaPle() {
		
		if (top10Programs.length == 10) {
			
			return true;
		}
		
		else {
			
			return false;
		}
	}
	
	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		sb.append(this.pr2.getIdProgram()).append(", ");
		sb.append(this.pr2.getName()).append(", ");
		sb.append(this.pr2.getDescription()).append(", ");
		sb.append("(").append(this.pr2.getActivityProgram()).append(")");
		sb.append("(").append(this.pr2.getRatingProgram()).append(")");
		
		return sb.toString();
		
	}
	
}

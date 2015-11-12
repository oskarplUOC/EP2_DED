package uoc.ei.practica;

import uoc.ei.tads.Contenidor;
import uoc.ei.tads.ContenidorAfitat;
import uoc.ei.tads.Iterador;
import uoc.ei.tads.LlistaEncadenada;


public class Top10Program<V> implements ContenidorAfitat<V> {

	private static final long serialVersionUID = 1L;
	
	public static final int TOP_10 = 10;
	
	private Program pr2;
	
	private ContenidorAfitat<Top10Program> top10Programs;
	
	public Top10Program(Program pr2) {

		this.pr2 = pr2;
	}

	@Override
	public Iterador elements() {
		
		if (this.top10Programs.estaBuit()); 
			
		return top10Programs.elements();			
	}

	@Override
	public boolean estaBuit() {
		
		if (this.top10Programs.estaBuit()) {
			
			return true;			
		}
		
		return false;		
	}

	@Override
	public int nombreElems() {
		
		return this.top10Programs.nombreElems();
	}

	@Override
	public boolean estaPle() {
		
		if (this.top10Programs.estaPle()) {
			
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

package uoc.ei.practica;

import java.util.Comparator;

import uoc.ei.tads.ContenidorAfitat;
import uoc.ei.tads.Iterador;


public class ArrayTop<Program> implements ContenidorAfitat<Program> {

	private static final long serialVersionUID = 1L;
	
	public ArrayTop() {
		
	}
		
	private ContenidorAfitat<Program> top10Programs;
	
	private View viewTop10;
	
	public ArrayTop(View viewTop10) {

		this.viewTop10 = viewTop10;
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
		
		sb.append(this.viewTop10.getProgram().getIdProgram()).append(", ");
		sb.append(this.viewTop10.getProgram().getName()).append(", ");
		sb.append(this.viewTop10.getProgram().getDescription()).append(", ");
		sb.append("(").append(this.viewTop10.getProgram().getActivityProgram()).append(")");
		sb.append("(").append(this.viewTop10.getProgram().getRatingProgram()).append(")");
		
		return sb.toString();
	}

}

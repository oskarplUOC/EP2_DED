package uoc.ei.practica;

import uoc.ei.tads.ContenidorAfitat;
import uoc.ei.tads.Iterador;


public class ArrayTop<Program> implements ContenidorAfitat<Program> {

	private static final long serialVersionUID = 1L;
	
	String [] top10 = new String[TVUOCManager.TOP_10];
	
	private ContenidorAfitat<Program> top10Programs;
	
	public ArrayTop() {

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
	
}

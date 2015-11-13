package uoc.ei.practica;

import uoc.ei.tads.ContenidorAfitat;
import uoc.ei.tads.Iterador;


public class ArrayTop<Program> implements ContenidorAfitat<Program> {

	private static final long serialVersionUID = 1L;
	
	Integer [] top10 = new Integer[TVUOCManager.TOP_10];
	
	public ArrayTop(Integer top10) {

	}

	@Override
	public Iterador elements() {
		
		return null;	
	}

	@Override
	public boolean estaBuit() {
		
		return true;		
	}

	@Override
	public int nombreElems() {
		
		return 0;
	}

	@Override
	public boolean estaPle() {
		
		return true;
	}
		
}

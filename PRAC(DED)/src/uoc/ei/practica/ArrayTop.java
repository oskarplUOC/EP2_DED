package uoc.ei.practica;

import java.lang.reflect.Array;
import java.util.Arrays;

import uoc.ei.tads.ContenidorAfitat;
import uoc.ei.tads.Iterador;


public class ArrayTop<Program> implements ContenidorAfitat<Program> {

	private static final long serialVersionUID = 1L;
	
	private Program[] top10;
	
	public static final int TOP_10 = 10;

    private int currentSize;
    
    public ArrayTop(){
        
    	top10 = (Program[]) new Object[TOP_10];
    }
    
    public void addLastProgram(Program program) {
        
    	top10[currentSize++] = program;
    }
	
	@Override
	public Iterador elements() {
		
		return this.elements();							
	}

	@Override
	public boolean estaBuit() {
		
		if (top10.length == 0) {
			
			return true;			
		}
		
		return false;
		
	}

	@Override
	public int nombreElems() {
		
		return this.currentSize;
				
	}

	@Override
	public boolean estaPle() {
		
		if (top10.length == 10) {
			
			return true;			
		}
		
		return false;
		
	}	
	
	public String toString() {
        
		return Arrays.toString(top10);
    }
}
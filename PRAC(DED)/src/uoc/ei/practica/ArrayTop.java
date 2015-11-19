package uoc.ei.practica;

import java.lang.reflect.Array;
import java.util.Arrays;

import uoc.ei.tads.Contenidor;
import uoc.ei.tads.ContenidorAfitat;
import uoc.ei.tads.Iterador;
import uoc.ei.tads.IteradorVectorImpl;


public class ArrayTop<Program> implements ContenidorAfitat<Program> {

	private static final long serialVersionUID = 1L;
	
	private Program[] top10;
	
	public int maximSize;

    private int currentSize;
    
    public ArrayTop(){
        
    	this.maximSize = 10;
    	top10 = (Program[]) new Object[maximSize];
    }
    
    public void addLastProgram(Program program) {
        
    	top10[currentSize++] = program;
    }
	
	@Override
	public Iterador elements() {
		
		Iterador<Program> it = new IteradorVectorImpl<Program>(this.top10,this.currentSize, 0);
	    return it;
								
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
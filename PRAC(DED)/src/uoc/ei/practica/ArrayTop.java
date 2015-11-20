package uoc.ei.practica;

import java.lang.reflect.Array;

import uoc.ei.tads.ContenidorAfitat;
import uoc.ei.tads.Iterador;
import uoc.ei.tads.IteradorVectorImpl;

@SuppressWarnings("hiding")
public class ArrayTop<Program> implements ContenidorAfitat<Program> {

	private static final long serialVersionUID = 1L;

	private Program[] top10;
	
	private int maximSize = 10;

    private int currentSize;
       
    public ArrayTop(){
        
    	@SuppressWarnings("unchecked")
		final Program[] top10 = (Program[]) Array.newInstance(uoc.ei.practica.Program.class, maximSize);

		this.top10 = top10;	
    	
    	/*top10 = (Program[]) new Object[this.maximSize];*/
    	
    }
    
    public void addLastProgram(Program program) { 
    	
    	top10[currentSize++] = program;
    	
    }
    	
	@Override
	public Iterador<Program> elements() {
		
		Iterador<Program> it = new IteradorVectorImpl<Program>(this.top10, this.currentSize, 0);
	    return it;
								
	}

	@Override
	public boolean estaBuit() {
		
		if (this.nombreElems() == 0) {
			
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
		
		if (this.nombreElems() == 10) {
			
			return true;			
		}
		
		return false;
		
	}	
}
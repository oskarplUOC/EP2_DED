package uoc.ei.practica;

import uoc.ei.tads.ContenidorAfitat;
import uoc.ei.tads.Iterador;
import uoc.ei.tads.IteradorVectorImpl;

public class ArrayTop implements ContenidorAfitat<Program> {

	private static final long serialVersionUID = 1L;

	private Program[] top10;
	
	private int maximSize = 10;

	private int currentSize;
       
	public ArrayTop(){
        
    	top10 =  new Program[this.maximSize];
    	
    }
    
    public void addLastProgram(Program p) { 
    	
    	top10[currentSize++] = p;
    	
    }
    
    public void ordenarTop10(){
    	
    	int maxPosicio = this.nombreElems();
    	
    	Program temp;
    	
    	for ( int i = 0; i < (maxPosicio - 1); i++ ) {
    		
    		for ( int j = (i + 1); j < maxPosicio; j++ ) {
    			
    			if ( top10[i].getActivityProgram() < top10[j].getActivityProgram() ) {
    				
    				temp = top10[i];
    				
    				top10[i] = top10[j];
    				
    				top10[j] = temp;
    			}
    		} 
    	}
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
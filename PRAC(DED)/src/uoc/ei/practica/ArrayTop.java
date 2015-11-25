package uoc.ei.practica;

import java.util.Comparator;

import uoc.ei.tads.ContenidorAfitat;
import uoc.ei.tads.Iterador;
import uoc.ei.tads.IteradorVectorImpl;

public class ArrayTop implements ContenidorAfitat<Program> {

	private static final long serialVersionUID = 1L;

	private Program[] top10;
	
	private Comparator<Program> comparator;
	
	private int maximSize = 10;

	private int currentSize;
       
	public static Comparator<Program> CompTop10 = new Comparator<Program>() {
         
		@Override
        public int compare(Program p1, Program p2) {
               
         	return (p2.getActivityProgram() - p1.getActivityProgram());
         	
        }       
    };
	
	public ArrayTop(){
        
    	top10 =  new Program[this.maximSize];
    	
    	comparator = ArrayTop.CompTop10;   	
    	
    }
    
    public void addLastProgram(Program p) { 
    	
    	top10[currentSize++] = p;
    	
    	int i = 0;
    	
    	// si ha un element que sigui menor que el que ens arriba.
    	
    	for (int j = 0; j < top10.length; j++) {
        
    		if (this.comparator.compare(p, top10[i]) > 0) {
    			
    			Program variableauxiliar = top10[j];	
    			
    			top10[j] = top10[i];
    			
    			top10[i] = variableauxiliar;
    				 				
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
package uoc.ei.practica;

import java.lang.reflect.Array;

import uoc.ei.tads.ContenidorAfitat;
import uoc.ei.tads.Iterador;


public class ArrayTop<Program> implements ContenidorAfitat<Program> {

	private static final long serialVersionUID = 1L;
	
	private Program[] container;
    
	private int top;
    
	public static final int TOP_10 = 10;
	
    public ArrayTop() {
		
    	this(TOP_10);
    }

    public ArrayTop(int initSize) {
		
    	container = (Program[]) new Object [initSize];
        top = 0;
	}

	public Program getTop() {
        
    	if (top == 0)
        
    	return null;
        return container[top];
        
    }
    
    @Override
	public boolean estaBuit() {
		
		return (top == 0);
	}
    
    public Program top() {
        
    	if (top == 0)
      
        return null;
        return container[top--];
    }
 
    public void push(Program program) {
        
    	container[++top] = program;
    }
 
	@Override
	public Iterador<Program> elements() {
		
		/*for ( Iterador it =  tad.elements(); it.hiHaSeguent(); )
		     
			System.out.println(it.seguent());*/
		return this.elements();
	}
	
	@Override
	public int nombreElems() {
		
		return (top + 1);
				
	}

	@Override
	public boolean estaPle() {
		
		return top == this.top-1;
		
	}	
	
}
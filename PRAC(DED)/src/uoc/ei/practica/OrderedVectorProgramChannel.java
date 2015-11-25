package uoc.ei.practica;

import java.util.Comparator;

import uoc.ei.tads.ClauValor;
import uoc.ei.tads.ContenidorAfitat;
import uoc.ei.tads.DiccionariVectorImpl;
import uoc.ei.tads.Iterador;
import uoc.ei.tads.IteradorVectorImpl;
import uoc.ei.tads.Posicio;

/**
 * TAD que implementa un vector ordenat. L'ordenació del vector
 * es determina amb el comparador.
 */
public class OrderedVectorProgramChannel<K,V> extends DiccionariVectorImpl<K,V> implements ContenidorAfitat<V>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private static final int KEY_NOT_FOUND = -1;

	
	private Comparator<K> comparator;


	public OrderedVectorProgramChannel(int max, Comparator<K> comparator) {
		
		super(max);
		this.comparator = comparator;
	}


	@Override
	public boolean estaPle() {
		return (super.n==super.diccionari.length);
	}
	
	public void afegir(K clau,V obj) {
	
		super.afegir(clau, obj);
  
		int i=this.n-1;
		
		boolean done=false;
		
		ClauValor kv;
		ClauValor last=this.diccionari[this.n-1];
		
		while (i>=0 && !done) {
			
			kv = this.diccionari[i]; 
			
			if (this.comparator.compare((K) kv.getClau(), clau)>0) {
				
				this.diccionari[i] = last;
				this.diccionari[i+1]=kv;
				last = this.diccionari[i];				
			}

			i--;
		}
		
	}

	public V consultar(K clau) {
		
		int pos = this.binary_search(clau, 0, this.n-1);
		return (pos!=this.KEY_NOT_FOUND?this.diccionari[pos].getValor():null);		
	}

	public V consultar(K clau, String message) throws EIException {
		
		V value=this.consultar(clau);
		if (value==null) throw new EIException(message);
		return value;
	}

	private int binary_search(K key, int imin, int imax) {
	 
	  if (imax < imin)
	    
	    return KEY_NOT_FOUND;
	  
	  else {
		  
	    int imid = midpoint(imin, imax);
	   
	    if (this.comparator.compare(this.diccionari[imid].getClau(), key)>0)
	        
	        return binary_search(key, imin, imid-1);
	      
	    else if (this.comparator.compare(this.diccionari[imid].getClau(), key)<0)
	    	  
	        return binary_search(key, imid+1, imax);
	      
	    else
	        
	    	return imid;
	    }
	}
	
	private int midpoint(int imin, int imax) {
		
		return imin + ((imax - imin) / 2);
	}


	public static void main(String[] args) {
		
		Comparator<String> cmp = new Comparator<String>() {

			@Override
			public int compare(String arg0, String arg1) {
				
				return arg0.compareTo(arg1);
			}
			
		};
		OrderedVectorProgramChannel<String, Integer> v = new OrderedVectorProgramChannel<String,Integer>(10, cmp);
		
		v.afegir("09", 9);
		v.afegir("07", 7);
		v.afegir("02", 2);
		v.afegir("03", 3);
		v.afegir("04", 4);
		v.afegir("05", 5);
		v.afegir("06", 6);
		v.afegir("01", 1);

		
		System.out.println("estaPle "+v.estaPle());
		
		for (Iterador<Integer> it = v.elements(); it.hiHaSeguent();) {
			System.out.println(it.seguent());
		}
		
		v.afegir("09", 9);
		v.afegir("10", 10);
		System.out.println("estaPle "+v.estaPle());
		v.afegir("11", 11);
		System.out.println("estaPle "+v.estaPle());		
		
		for (Iterador<Integer> it = v.elements(); it.hiHaSeguent();) {
			System.out.println(it.seguent());
		}

		System.out.println("1: "+ v.consultar("01"));
		System.out.println("5: "+ v.consultar("05"));
		
		System.out.println("11: "+ v.consultar("11"));

		System.out.println("1: "+ v.consultar("1"));
		System.out.println("5: "+ v.consultar("5"));

	}

}

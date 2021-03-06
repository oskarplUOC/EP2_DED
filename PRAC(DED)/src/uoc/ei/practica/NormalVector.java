package uoc.ei.practica;

import java.util.Comparator;

import uoc.ei.tads.ContenidorAfitat;
import uoc.ei.tads.DiccionariVectorImpl;
import uoc.ei.tads.Iterador;


public class NormalVector<K,V> extends DiccionariVectorImpl<K,V> implements ContenidorAfitat<V>{
	
	private static final long serialVersionUID = 1L;

	private static final int KEY_NOT_FOUND = -1;
	
	private Comparator<K> comparator;

	public NormalVector(int max, Comparator<K> comparator) {
		
		super(max);
		this.comparator = comparator;
		
	}

	@Override
	public boolean estaPle() {
		return (super.n==super.diccionari.length);
	}

	public void afegir(K clau,V obj) {
		
		super.afegir(clau, obj);

	}
	
	public V consultar(K clau) {
		
		int pos = this.lineal_search(clau, this.n-1);
		
		return (pos!= NormalVector.KEY_NOT_FOUND?this.diccionari[pos].getValor():null);		
	}

	public V consultar(K clau, String message) throws EIException {
		
		V value=this.consultar(clau);
		
		if (value==null) throw new EIException(message);
		
		return value;
	}

	
	private int lineal_search(K key, int max) {
		
		 int posicio = -1;
		  
		 for(int i = 0; i <= max; i++){
		      if(this.comparator.compare(this.diccionari[i].getClau(), key)==0) {
		    	  posicio = i;
		    	  break;
		   }
		 }
		 
		 return posicio;
	}

    public static void main(String[] args) {
		
		Comparator<String> cmp = new Comparator<String>() {

			@Override
			public int compare(String arg0, String arg1) {
				
				return arg0.compareTo(arg1);
			}
			
		};
		
		NormalVector<String, Integer> v = new NormalVector<String,Integer>(10, cmp);
		
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

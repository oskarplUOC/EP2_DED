package uoc.ei.practica;

import java.util.Comparator;

import uoc.ei.tads.ClauValor;
import uoc.ei.tads.ContenidorAfitat;
import uoc.ei.tads.DiccionariVectorImpl;

public class OrderedVectorTop10<K,V> extends DiccionariVectorImpl<K,V> implements ContenidorAfitat<V> {

	private static final long serialVersionUID = 1L;
	
	private Comparator<K> comparator;
		
	public OrderedVectorTop10(int n, Comparator<K> comparator) {
		
		super(n);
		this.comparator = comparator;
	}

	
	@Override
	public boolean estaPle() {
		
		return (super.n==super.diccionari.length);
		
	}
	
	public void afegir(K clau,V obj) {
		super.afegir(clau, obj);

		// add Key-Value  
		int i=this.n-1;
		
		boolean done=false;
		
		ClauValor kv;
		ClauValor last=this.diccionari[this.n-1];
		
		while (i>=0 && !done) {
			kv = this.diccionari[i]; 
			
			if (this.comparator.compare((K) kv.getClau(), clau)>0) {
				// swap
				this.diccionari[i] = last;
				this.diccionari[i+1]=kv;
				last = this.diccionari[i];				
			}

			i--;
		}
		
	}

}

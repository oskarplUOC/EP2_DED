package uoc.ei.practica;

import uoc.ei.tads.Iterador;

import uoc.ei.tads.LlistaEncadenada;

public class IdentifiedList<E> extends LlistaEncadenada<E> {

	protected  E getIdentifiedObject(String identifier, String exceptionMessage) throws EIException {
		IdentifiedObject result=null;
		if (this.nombreElems()>0) {
			Iterador<? extends IdentifiedObject> iterator = (Iterador<? extends IdentifiedObject>) super.elements();
			while (iterator.hiHaSeguent() && result==null) {
				IdentifiedObject current=iterator.seguent();
				if (current.getIdentifier().equals(identifier))
					result=current;
			}
		}
		if (result==null && exceptionMessage!=null)
		throw new EIException(exceptionMessage);

		return (E)result;
	}
	
	protected E getIdentifiedObject(String identifier) {
		E result=null;
		try {
			result=getIdentifiedObject(identifier, null);
		} catch (EIException e) {
			
		}
		return result;
	}
 	
	public Iterador<E> elements(String exceptionMessage) throws EIException {
		if (this.estaBuit()) throw new EIException(exceptionMessage);
		return this.elements();
	}

}

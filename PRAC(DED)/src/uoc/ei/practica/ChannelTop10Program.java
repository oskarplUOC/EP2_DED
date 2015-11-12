package uoc.ei.practica;

import uoc.ei.tads.ContenidorAfitat;
import uoc.ei.tads.Iterador;

public class ChannelTop10Program<E> implements ContenidorAfitat<E>{
	
private static final long serialVersionUID = 1L;
	
	private Program pr2;
	
	public ChannelTop10Program(Program pr2, String idChannel) {

		this.pr2 = pr2;
	}

	@Override
	public Iterador elements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean estaBuit() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int nombreElems() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean estaPle() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		sb.append(this.pr2.getIdProgram()).append(", ");
		sb.append(this.pr2.getName()).append(", ");
		sb.append(this.pr2.getDescription()).append(", ");
		sb.append("(").append(this.pr2.getActivityProgram()).append(")");
		sb.append("(").append(this.pr2.getRatingProgram()).append(")");
		
		return sb.toString();
		
	}

}

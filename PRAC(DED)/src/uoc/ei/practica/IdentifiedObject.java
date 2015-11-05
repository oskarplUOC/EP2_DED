package uoc.ei.practica;


public class IdentifiedObject {

 
	protected String identifier;
	
	public IdentifiedObject() {
		
	}
	
	public IdentifiedObject(String identifier) {
		this.identifier=identifier;
	}
	
	public void setIdentifier(String identifier) {
		this.identifier=identifier;
	}
	
	public String getIdentifier() {
		return identifier;
	}
		
 
	public String toString() {
	    StringBuffer result = new StringBuffer();
	    result.append("id: "+ this.getIdentifier() + Messages.LS);
		return  result.toString();
	}

}
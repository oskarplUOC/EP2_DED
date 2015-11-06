package uoc.ei.practica;

import uoc.ei.tads.LlistaEncadenada;

public class User extends IdentifiedObject {
	
	private String idUser;

	private String email;

	private String password;
	
	private LlistaEncadenada<View> viewsUser;
	
	public User(String idUser, String email, String password) {
		
		super(idUser);
		this.email = email;
		this.password = password;
		this.viewsUser = new LlistaEncadenada<View>();
		
	}	
	
	public String getIdUser() {
		
		return this.idUser;
	
	}
	
	public String getEmail() {
		
		return this.email;
	
	}
	
	public void setEmail(String email) {
		
		this.email = email;
	}
			
	public String getPassword() {
		
		return this.password;
	
	}
	
	public void setPassword(String password) {
		
		this.password = password;
	}

	public LlistaEncadenada<View> getViewsUser() {
		
		return viewsUser;
	}

	public void setViewsUser(LlistaEncadenada<View> viewsUser) {
		
		this.viewsUser = viewsUser;
	}

}

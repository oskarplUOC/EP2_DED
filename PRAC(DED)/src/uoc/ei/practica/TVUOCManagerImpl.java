package uoc.ei.practica;

import java.util.Date;
import uoc.ei.tads.Contenidor;
import uoc.ei.tads.Iterador;
import uoc.ei.tads.Posicio;
import uoc.ei.tads.Recorregut;

public class TVUOCManagerImpl implements TVUOCManager {
	
	private IdentifiedList<User> users;
	
	private Vector<String, Channel> channels;
				
	private Program topRating;
	
	public TVUOCManagerImpl() {
		
		this.users = new IdentifiedList<User>();
		
		this.channels = new Vector<String, Channel>(C, Channel.COMP);
		
		this.topRating = null;
		
	}
	
	@Override
	public void addUser(String idUser, String email, String password) throws EIException {
		
		User user = this.users.getIdentifiedObject(idUser);  
		 
		if (user != null) {
					
			user.setEmail(email);
			user.setPassword(password);
		 }
		
		 else {
			 
			 user = new User(idUser, email, password);
			 this.users.afegirAlPrincipi(user);
						 
		 }
		
		 /*Posicio<User> posicio = null;
		 User user1 = new User(idUser, email, password);
	     boolean found = false;
	      
	     for (Recorregut<User> it = users.posicions(); it.hiHaSeguent(); ){
	         
	    	 posicio = it.seguent();
	         User userUpdate = (User)posicio.getElem();
	         
	         if(userUpdate.getIdUser().equals(user1.getIdUser())){
	            
	        	this.users.reemplacar(posicio, user1);
	            found = true;
	         }
	      }
	      
	      if(!found) 
	    	  
	    	  this.users.afegirAlPrincipi(user1);*/
	}
		
	@Override
	public void addChannel(String idChannel, String name, String description) throws EIException {
		
		this.channels.afegir(idChannel, new Channel(idChannel, name, description));
		
	}

	@Override
	public void addProgram(String id, String name, String description, String idChannel) throws EIException {
		
		Channel channel = this.channels.consultar(idChannel);
        Program program = new Program(id, name, description, idChannel);
        	
        this.channels.consultar(idChannel).getProgramsChannel().afegir(id, program); 
	}

	@Override
	public void registerView(String idChannel, String idProgram, String idUser, Date dateTime) throws EIException {
		
		User user = this.users.getIdentifiedObject(idUser, Messages.USER_NOT_FOUND);
		
		Channel channel = this.channels.consultar(idChannel, Messages.CHANNEL_NOT_FOUND);
		
		Program program = this.channels.consultar(idChannel).getProgramsChannel().consultar(idProgram, Messages.PROGRAM_NOT_FOUND);
		
		program.incActivityProgram();
		
			
	}

	@Override
	public void rateProgram(String idChannel, String idProgram, int rating) throws EIException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterador<View> getUserViews(String idUser) {
		
		/*User user = this.users.getIdentifiedObject(idUser);
		Contenidor<View> contenidor = user.getViewsUser();
		return contenidor.elements();*/
		return null;
	}

	@Override
	public Iterador<Program> getTop10Programs() throws EIException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterador<Program> getChannelTop10Programs(String idChannel) throws EIException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Program topRating() throws EIException {
		
		if (this.topRating == null) throw new EIException(Messages.NO_PROGRAMS);
		
		return this.topRating;
	}

	@Override
	public Iterador<User> users() throws EIException {
		
		if (this.users.estaBuit()) throw new EIException(Messages.NO_USERS);
		
		return this.users.elements();
	}

	@Override
	public Iterador<Channel> channels() throws EIException {
		
		if (this.channels.estaBuit()) throw new EIException(Messages.NO_CHANNELS);
		
		return channels.elements();
	}

	@Override
	public Iterador<Program> programs(String idChannel) throws EIException {
		
		Channel channel = this.channels.consultar(idChannel, Messages.CHANNEL_NOT_FOUND);
		
		Contenidor<Program> programsChannel = channel.getProgramsChannel();  
		
		if (programsChannel.estaBuit()) throw new EIException(Messages.NO_PROGRAMS);
				
		return programsChannel.elements();
	}

	@Override
	public Program program(String idChannel, String idProgram) throws EIException {
		// TODO Auto-generated method stub
		return null;
	}


}

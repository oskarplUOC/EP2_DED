package uoc.ei.practica;

import java.util.Date;

import uoc.ei.tads.Contenidor;
import uoc.ei.tads.Iterador;
import uoc.ei.tads.IteradorVectorImpl;
import uoc.ei.tads.Posicio;
import uoc.ei.tads.Recorregut;

public class TVUOCManagerImpl implements TVUOCManager {
	
	private IdentifiedList<User> users;
	
	private NormalVector<String, Channel> channels;
	
	public Program topRating;
	
	private ArrayTop<Program> top10Program;
	
	public TVUOCManagerImpl() {
		
		this.users = new IdentifiedList<User>();
		
		this.channels = new NormalVector<String, Channel>(C, Channel.COMP2);
		
		this.top10Program = new ArrayTop<Program>();
		
		this.topRating = null;	
	}
	
	@Override
	public void addUser(String idUser, String email, String password) throws EIException {
		
		 Posicio<User> posicio = null;
		 User user = new User(idUser, email, password);
	     boolean found = false;
	      
	     for (Recorregut<User> it = users.posicions(); it.hiHaSeguent(); ){
	         
	    	 posicio = it.seguent();
	         User userUpdate = (User)posicio.getElem();
	         
	         if(userUpdate.identifier.equals(user.identifier)){
	            
	        	this.users.reemplacar(posicio, user);
	            found = true;
	         }
	      }
	      
	      if(!found) 
	    	  
	    	  this.users.afegirAlPrincipi(user);
	}
		
	@Override
	public void addChannel(String idChannel, String name, String description) throws EIException {
		
		Channel channel = new Channel(idChannel, name, description);
		this.channels.afegir(idChannel, channel);
		
	}

	@Override
	public void addProgram(String id, String name, String description, String idChannel) throws EIException {
		
		Channel channel = this.channels.consultar(idChannel, Messages.CHANNEL_NOT_FOUND);
        				
		Program program = new Program(id, name, description, idChannel);
        
		this.channels.consultar(idChannel).getProgramsChannel().afegir(id, program); 
	}

	@Override
	public void registerView(String idChannel, String idProgram, String idUser, Date dateTime) throws EIException {
		
		User user = this.users.getIdentifiedObject(idUser, Messages.USER_NOT_FOUND);
		
		Channel channel = this.channels.consultar(idChannel, Messages.CHANNEL_NOT_FOUND);
		
		Program program = this.channels.consultar(idChannel).getProgramsChannel().consultar(idProgram, Messages.PROGRAM_NOT_FOUND);
		
		View view = new View(idChannel, program, idUser, dateTime);		
		
		program.incActivityProgram();
				
		user.addView(view); 
		
		updateTop10(program);
		
		channel.updateTop10 (program);
		
	}		
	
	public void updateTop10(Program program) {
		
		/*this.top10Program.addLastProgram(program);*/
					
	}
	
	@Override
	public void rateProgram(String idChannel, String idProgram, int rating) throws EIException {
		
		Channel channel = this.channels.consultar(idChannel, Messages.CHANNEL_NOT_FOUND);
		Program program = this.channels.consultar(idChannel).getProgramsChannel().consultar(idProgram, Messages.PROGRAM_NOT_FOUND);
		
		if (rating < 0 || rating > 5) {
			
			throw new EIException (Messages.RATING_NOT_CORRECT);
			
		}
		
		else {
		
			program.addRating(rating);
		}
	}

	@Override
	public Iterador<View> getUserViews(String idUser) {
		
		User user = this.users.getIdentifiedObject(idUser);
		
		Contenidor<View> contenidor = user.getViewsUser();
		
		return contenidor.elements();		
	}

	@Override
	public Iterador<Program> getTop10Programs() throws EIException {
					
		if (this.top10Program.estaBuit()) throw new EIException(Messages.NO_PROGRAMS);
		
	 	return this.top10Program.elements();
	}
	
	@Override
	public Iterador<Program> getChannelTop10Programs(String idChannel) throws EIException {
		
		Channel channel = this.channels.consultar(idChannel, Messages.CHANNEL_NOT_FOUND);
		
		Contenidor<Program> contenidor =  channel.getChannelTop10Program();  
				
		return contenidor.elements();
			
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
		
		Channel channel = this.channels.consultar(idChannel);
		
		Program program = this.channels.consultar(idChannel).getProgramsChannel().consultar(idProgram);
		
		if (channel == null) throw new EIException(Messages.CHANNEL_NOT_FOUND);
		
		if (program == null) throw new EIException(Messages.PROGRAM_NOT_FOUND);
		
		if (this.topRating == null || this.topRating.getRatingProgram() < program.getRatingProgram()) this.topRating = program;
		
		return program;
	}

}

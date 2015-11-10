package uoc.ei.practica;

import java.util.Date;

import uoc.ei.tads.Contenidor;
import uoc.ei.tads.Iterador;
import uoc.ei.tads.IteradorVectorImpl;
import uoc.ei.tads.Posicio;
import uoc.ei.tads.Recorregut;

public class TVUOCManagerImpl implements TVUOCManager {
	
	private IdentifiedList<User> users;
	
	private Vector<String, Channel> channels;
	
	private Top10Program[] top10Programs;
	
	private ChannelTop10Program[] channelTop10Programs;
	
	private int len;
	
	private int len2;
	
	public Program topRating;
	
	public TVUOCManagerImpl() {
		
		this.top10Programs= new Top10Program[TOP_10];
		
		this.len = 0;
		
		this.channelTop10Programs= new ChannelTop10Program[TOP_10];
		
		this.len2 = 0;
		
		this.users = new IdentifiedList<User>();
		
		this.channels = new Vector<String, Channel>(C, Channel.COMP);
		
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
		this.channels.afegir(idChannel, channel );
		
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
		
		View view = new View(idChannel, program, idUser, dateTime);		
		user.addView(view);                             
		
		/*6. actualitzes tot el referent al top10*/		
	}

	@Override
	public void rateProgram(String idChannel, String idProgram, int rating) throws EIException {
		
		Channel channel = this.channels.consultar(idChannel);
		Program program = this.channels.consultar(idChannel).getProgramsChannel().consultar(idProgram);
		
		program.addRating(rating);
		
	}

	@Override
	public Iterador<View> getUserViews(String idUser) {
		
		User user = this.users.getIdentifiedObject(idUser);
		
		Contenidor<View> contenidor = user.getViewsUser();
		
		return contenidor.elements();		
	}

	@Override
	public Iterador<Program> getTop10Programs() throws EIException {
		
		return null;	
	}
	
	@Override
	public Iterador<Program> getChannelTop10Programs(String idChannel) throws EIException {
		
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
		
		Channel channel = this.channels.consultar(idChannel);
		
		Program program = this.channels.consultar(idChannel).getProgramsChannel().consultar(idProgram);
		
		if (channel == null) throw new EIException(Messages.CHANNEL_NOT_FOUND);
		
		if (program == null) throw new EIException(Messages.PROGRAM_NOT_FOUND);
		
		return program;
	}


}

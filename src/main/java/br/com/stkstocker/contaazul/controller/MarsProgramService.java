package br.com.stkstocker.contaazul.controller;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import br.com.stkstocker.contaazul.model.Robot;

@Path("/")
public class MarsProgramService {
	
	Robot robot = new Robot();
	
	@POST
	@Path("/{param}")
	public Response getEntry(@PathParam("param") String entry) {
		
		entry = entry.toUpperCase();
		
		if (entry.matches("[LRM]+")) { // Aceitos apenas os caracteres LRM
			try{
				if( robot.validatePosition(entry.toCharArray()) ){ // Envia a entrada para validação
					return Response.status(200).entity( robot.getCoordinates() ).build();
				}
			}catch(Exception ex){
				return Response.status(400).entity(ex.getMessage()).build();
			}
			
		}else{
			return Response.status(400).build();
		}
		return null;
	}

	
}

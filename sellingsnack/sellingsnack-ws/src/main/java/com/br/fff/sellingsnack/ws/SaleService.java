package com.br.fff.sellingsnack.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import com.owlike.genson.Genson;
//import com.owlike.genson.GensonBuilder;
import com.google.gson.Gson;

@Path("/sale")
public class SaleService {
	
	protected Logger logger = LogManager.getLogger(getClass());
	
	private final static Gson gson = new Gson();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response list() {

		String jsonString = gson.toJson(DataInMemory.SALES);
		
		logger.debug(String.format("GET list Sales: \"%s\"", jsonString));
		
		return Response.ok(jsonString).build();
	}

}

package com.br.fff.sellingsnack.ws;

import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.br.fff.sellingsnack.model.Snack;

@Path("/snack")
public class SnackService {

	protected Logger logger = LogManager.getLogger(getClass());
	

	private final static Gson gson = new Gson();

	private Snack findById(int id) {
		Snack snack = DataInMemory.SNACKS_BY_ID.get(id);
		if (snack == null) {
			logger.error("Snack not found in Server. Snack Id: \"{}\"", id);
			throw new WebApplicationException(404);
		}
		
		return snack;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response list() {
		List<String> snacks = new LinkedList<>();

		for (Entry<String, Snack> entry : DataInMemory.SNACKS_BY_NAME.entrySet()) {
			snacks.add(entry.getKey());
		}

		String jsonString = gson.toJson(snacks);
		logger.debug(String.format("GET list Snacks: \"%s\"", jsonString));

		return Response.ok(jsonString).build();
	}

	@GET
	@Path("/find/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSnackByName(@PathParam("name") String name) {
		String jsonString = "[]";		
		Snack snack = DataInMemory.SNACKS_BY_NAME.get(name);
		
		if (snack == null) {
			logger.error("Snack not found in Server. Snack Name: \"{}\"", name);
			throw new WebApplicationException(404);
		}

		try {			
			jsonString = gson.toJson(snack);
			logger.debug(String.format("GET Snack By Name(\"%s\"): \"%s\"", name, jsonString));
			
		} catch (Exception e) {
			logger.error("Fail to generate JSON of Snack. Snack Name: \"{}\"", name);
			logger.error("Exception:\n > {}", e.getMessage());
			throw new WebApplicationException(500);
		}

		return Response.ok(jsonString).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{snackId}")
	public Response getSnack(@PathParam("snackId") int id) {
		String jsonString = "[]";
		
		try {
			jsonString = gson.toJson(findById(id));
			logger.debug(String.format("GET Snack By ID(\"%d\"): \"%s\"", id, jsonString));
			
		} catch (Exception e) {
			logger.error("Fail to generate JSON of Snack. Snack ID: \"{}\"", id);
			logger.error("Exception:\n > {}", e.getMessage());
			throw new WebApplicationException(500);
		}
		
		return Response.ok(jsonString).build();
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") int id) {
		Snack snackFound = findById(id);
		DataInMemory.SNACKS_BY_ID.remove(snackFound.getId());
		DataInMemory.SNACKS_BY_NAME.remove(snackFound.getName());

		return Response.ok().build();
	}

	/*
	 * @PUT
	 * 
	 * @Path("/{id}")
	 * 
	 * @Consumes(MediaType.APPLICATION_JSON) public Response update(@PathParam("id")
	 * int id, Snack snack) { Snack snackFound = findById(id);
	 * DataInMemory.SNACKS_BY_NAME.remove(snackFound.getName());
	 * 
	 * snackFound.setName(snack.getName());
	 * snackFound.setIngredients(snack.getIngredients());
	 * DataInMemory.SNACKS_BY_ID.put(snackFound.getId(), snackFound);
	 * DataInMemory.SNACKS_BY_NAME.put(snackFound.getName(), snack);
	 * 
	 * String jsonString = gson.toJson(snackFound);//GENSON.serialize(snackFound)
	 * System.out.println(jsonString);
	 * 
	 * return Response.ok(jsonString).build(); }
	 */

	/*
	 * @POST
	 * 
	 * @Consumes(MediaType.APPLICATION_JSON)
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public Response add(Snack snack) { if
	 * (snack != null) { snack.setId(DataInMemory.SNACKS_BY_ID.size());
	 * DataInMemory.SNACKS_BY_ID.put(snack.getId(), snack);
	 * DataInMemory.SNACKS_BY_NAME.put(snack.getName(), snack); }
	 * 
	 * String jsonString = gson.toJson(snack); //GENSON.serialize(snack)
	 * System.out.println(jsonString);
	 * 
	 * return Response.ok(jsonString).build(); }
	 */

}

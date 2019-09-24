package com.br.fff.sellingsnack.ws;

import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//import com.owlike.genson.Genson;
//import com.owlike.genson.GensonBuilder;
import com.google.gson.Gson;

import com.br.fff.sellingsnack.model.Snack;


@Path("/snack")
public class SnackService {

	//private final static Genson GENSON = new GensonBuilder().create();
	private final static Gson gson = new Gson();

	private Snack findById(int id) {
		Snack snack = null;
		try {
			snack = DataInMemory.SNACKS_BY_ID.get(id);
			if (snack == null) {
				throw new WebApplicationException(404);
			}
		} catch (Exception e) {
			// TODO: To implement LOG4J
			throw new WebApplicationException(500);
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
		System.out.println(jsonString);
		
		return Response.ok(jsonString).build();
	}
	
	@GET
	@Path("/find/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSnackByName(@PathParam("name") String name) {
		Snack snack = DataInMemory.SNACKS_BY_NAME.get(name);
		if (snack == null) {
			throw new WebApplicationException(404);
		}

		String jsonString = gson.toJson(snack);
		System.out.println(jsonString);
		
		//return Response.ok(GENSON.serialize(snack)).build();
		return Response.ok(jsonString).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{snackId}")
	public Snack getSnack(@PathParam("snackId") int id) {
		return findById(id);
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") int id, Snack snack) {
		Snack snackFound = findById(id);
		DataInMemory.SNACKS_BY_NAME.remove(snackFound.getName());

		snackFound.setName(snack.getName());
		snackFound.setIngredients(snack.getIngredients());
		DataInMemory.SNACKS_BY_ID.put(snackFound.getId(), snackFound);
		DataInMemory.SNACKS_BY_NAME.put(snackFound.getName(), snack);

		String jsonString = gson.toJson(snackFound);//GENSON.serialize(snackFound)
		System.out.println(jsonString);
		
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
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response add(Snack snack) {
		if (snack != null) {
			snack.setId(DataInMemory.SNACKS_BY_ID.size());
			DataInMemory.SNACKS_BY_ID.put(snack.getId(), snack);
			DataInMemory.SNACKS_BY_NAME.put(snack.getName(), snack);
		}
		
		String jsonString = gson.toJson(snack); //GENSON.serialize(snack)
		System.out.println(jsonString);
		
		return Response.ok(jsonString).build();
	}

}

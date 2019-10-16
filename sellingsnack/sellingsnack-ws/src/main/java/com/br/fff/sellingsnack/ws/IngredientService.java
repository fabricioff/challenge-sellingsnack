package com.br.fff.sellingsnack.ws;

import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;

import com.br.fff.sellingsnack.model.Ingredient;

@Path("/ingredient")
public class IngredientService {
	
	protected Logger logger = LogManager.getLogger(getClass());
	
	private final static Gson gson = new Gson();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response list() {
		List<Ingredient> ingredients = new LinkedList<>();

		for (Ingredient ingredient : DataInMemory.INGREDIENTS) {
			ingredients.add(ingredient);
		}

		String jsonString = gson.toJson(ingredients);
		logger.debug(String.format("GET list Ingredients: \"%s\"", jsonString));
		
		return Response.ok(jsonString).build();
	}

}

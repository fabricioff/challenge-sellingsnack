package com.br.fff.sellingsnack.ws;

import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//import com.owlike.genson.Genson;
//import com.owlike.genson.GensonBuilder;
import com.google.gson.Gson;

import com.br.fff.sellingsnack.model.Sale;

@Path("/sale")
public class SaleService {
	
	//private final static Genson GENSON = new GensonBuilder().create();
	private final static Gson gson = new Gson();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response list() {
		List<Sale> sales = new LinkedList<>();

		for (Sale promotion : DataInMemory.SALES) {
			sales.add(promotion);
		}

		String jsonString = gson.toJson(sales); //GENSON.serialize(sales)
		System.out.println(jsonString);
		
		return Response.ok(jsonString).build();
	}

}

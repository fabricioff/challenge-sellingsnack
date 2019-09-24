package com.br.fff.sellingsnack.ws;

import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.br.fff.sellingsnack.model.Promotion;
import com.owlike.genson.Genson;
import com.owlike.genson.GensonBuilder;


@Path("/promotion")
public class PromotionService {
	
	private final static Genson GENSON = new GensonBuilder().create();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response list() {
		List<Promotion> promotions = new LinkedList<>();

		for (Promotion promotion : DataInMemory.PROMOTION) {
			promotions.add(promotion);
		}

		return Response.ok(GENSON.serialize(promotions)).build();
	}

}

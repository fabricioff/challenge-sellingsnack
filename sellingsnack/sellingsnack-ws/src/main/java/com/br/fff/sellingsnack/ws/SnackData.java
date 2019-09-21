package com.br.fff.sellingsnack.ws;

import java.util.LinkedHashMap;
import java.util.Map;

import com.br.fff.sellingsnack.model.Ingredient;
import com.br.fff.sellingsnack.model.Snack;


@SuppressWarnings("unused")
public class SnackData {

	public final static Map<Integer, Snack> SNACKS_BY_ID = new LinkedHashMap<Integer, Snack>();
	public final static Map<String, Snack> SNACKS_BY_NAME = new LinkedHashMap<String, Snack>();
	
	static {
		Ingredient ovo = new Ingredient(5, "Ovo", 0.80f);
		Ingredient bacon = new Ingredient(1, "Bacon", 2.00f);
		Ingredient queijo = new Ingredient(3, "Queijo", 1.50f);
		Ingredient alface = new Ingredient(4, "Alface", 0.40f);
		Ingredient hamburgerCarne = new Ingredient(2, "Hamburguer de carne", 3.00f);

		Snack xBacon = new Snack();
		xBacon.setId(1);
		xBacon.setName("X-Bacon");
		xBacon.getIngredients().add(bacon);
		xBacon.getIngredients().add(hamburgerCarne);
		xBacon.getIngredients().add(queijo);
		SNACKS_BY_ID.put(xBacon.getId(), xBacon);
		SNACKS_BY_NAME.put(xBacon.getName(), xBacon);

		Snack xBurger = new Snack();
		xBurger.setId(2);
		xBurger.setName("X-Burger");
		xBurger.getIngredients().add(hamburgerCarne);
		xBurger.getIngredients().add(queijo);
		SNACKS_BY_ID.put(xBurger.getId(), xBurger);
		SNACKS_BY_NAME.put(xBurger.getName(), xBurger);

		Snack xEgg = new Snack();
		xEgg.setId(3);
		xEgg.setName("X-Egg");
		xEgg.getIngredients().add(ovo);
		xEgg.getIngredients().add(hamburgerCarne);
		xEgg.getIngredients().add(queijo);
		SNACKS_BY_ID.put(xEgg.getId(), xEgg);
		SNACKS_BY_NAME.put(xEgg.getName(), xEgg);

		Snack xEggBacon = new Snack();
		xEggBacon.setId(4);
		xEggBacon.setName("X-Egg Bacon");
		xEggBacon.getIngredients().add(ovo);
		xEggBacon.getIngredients().add(bacon);
		xEggBacon.getIngredients().add(hamburgerCarne);
		xEggBacon.getIngredients().add(queijo);
		SNACKS_BY_ID.put(xEggBacon.getId(), xEggBacon);
		SNACKS_BY_NAME.put(xEggBacon.getName(), xEggBacon);
	}
}

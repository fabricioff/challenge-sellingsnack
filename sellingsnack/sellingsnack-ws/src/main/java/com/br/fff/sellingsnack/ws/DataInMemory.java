package com.br.fff.sellingsnack.ws;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.br.fff.sellingsnack.model.Item;
import com.br.fff.sellingsnack.model.Ingredient;
import com.br.fff.sellingsnack.model.Sale;
import com.br.fff.sellingsnack.model.Snack;
import com.br.fff.sellingsnack.model.TypeDeduction;

public class DataInMemory {

	
	public final static Map<Integer, Snack> SNACKS_BY_ID = new LinkedHashMap<Integer, Snack>();
	public final static Map<String, Snack> SNACKS_BY_NAME = new LinkedHashMap<String, Snack>();
	public final static List<Sale> SALES = new LinkedList<Sale>();
	public final static List<Ingredient> INGREDIENTS = new LinkedList<Ingredient>();
	
	/************************************************************************************************************************************************
		PROMOÇÃO 		REGRA DE NEGÓCIO	
		Light..........:Se o lanche tem alface e não tem bacon, ganha 10% de desconto.	
		Muita carne....:A cada 3 porções de carne o cliente só paga 2. Se o lanche tiver 6 porções, ocliente pagará 4. Assim por diante...	
		Muito queijo...:A cada 3 porções de queijo o cliente só paga 2. Se o lanche tiver 6 porções, ocliente pagará 4. Assim por diante...	
		Inflação.......:Os valores dos ingredientes são alterados com frequência e não gastaríamos que isso influenciasse nos testes automatizados. 
	*************************************************************************************************************************************************/
	
	static {
		Ingredient bacon = new Ingredient(1, "Bacon", 2.00f);
		Ingredient hamburgerCarne = new Ingredient(2, "Hamburguer de carne", 3.00f);
		Ingredient queijo = new Ingredient(3, "Queijo", 1.50f);
		Ingredient alface = new Ingredient(4, "Alface", 0.40f);
		Ingredient ovo = new Ingredient(5, "Ovo", 0.80f);
		INGREDIENTS.add(bacon);
		INGREDIENTS.add(hamburgerCarne);
		INGREDIENTS.add(queijo);
		INGREDIENTS.add(alface);
		INGREDIENTS.add(ovo);
		
		Sale ligth = new Sale.Builder().id(1).name("Ligth")
				.description("Se o lanche tem alface e não tem bacon, ganha 10% de desconto")
				.addCondition(new Item(alface, 1))
				.addCondition(new Item(bacon, 0))
				.deduction(0.1f)
				.typeDeduction(TypeDeduction.SNACK)
				.build();
		SALES.add(ligth);
		
		Sale muchMeat = new Sale.Builder().id(2).name("Muita carne")
				.description("A cada 3 porções de carne o cliente só paga 2. Se o lanche tiver 6 porções, ocliente pagará 4. Assim por diante")
				.addCondition(new Item(hamburgerCarne, 3))
				.deduction(0.3335f)
				.typeDeduction(TypeDeduction.INGREDIENT)
				.build();
		SALES.add(muchMeat);
		
		Sale muchCheese = new Sale.Builder().id(3).name("Muito queijo")
				.description("A cada 3 porções de queijo o cliente só paga 2. Se o lanche tiver 6 porções, ocliente pagará 4. Assim por diante")
				.addCondition(new Item(queijo, 3))
				.deduction(0.3335f)
				.typeDeduction(TypeDeduction.INGREDIENT)
				.build();
		SALES.add(muchCheese);

		Snack xBacon = new Snack.Builder().id(1).name("X-Bacon")
				.addIngredient(new Item(bacon, 1))
				.addIngredient(new Item(hamburgerCarne, 1))
				.addIngredient(new Item(queijo, 1))
				.build();
		SNACKS_BY_ID.put(xBacon.getId(), xBacon);
		SNACKS_BY_NAME.put(xBacon.getName(), xBacon);

		Snack xBurger = new Snack.Builder().id(2).name("X-Burger")
				.addIngredient(new Item(hamburgerCarne, 1))
				.addIngredient(new Item(queijo, 1))
				.build();
		SNACKS_BY_ID.put(xBurger.getId(), xBurger);
		SNACKS_BY_NAME.put(xBurger.getName(), xBurger);

		Snack xEgg = new Snack.Builder().id(3).name("X-Egg")
				.addIngredient(new Item(ovo, 1))
				.addIngredient(new Item(hamburgerCarne, 1))
				.addIngredient(new Item(queijo, 1))
				.build();
		SNACKS_BY_ID.put(xEgg.getId(), xEgg);
		SNACKS_BY_NAME.put(xEgg.getName(), xEgg);

		Snack xEggBacon = new Snack.Builder().id(4).name("X-Egg Bacon")
				.addIngredient(new Item(ovo, 1))
				.addIngredient(new Item(bacon, 1))
				.addIngredient(new Item(hamburgerCarne, 1))
				.addIngredient(new Item(queijo, 1))
				.build();
		SNACKS_BY_ID.put(xEggBacon.getId(), xEggBacon);
		SNACKS_BY_NAME.put(xEggBacon.getName(), xEggBacon);
		
		
		Snack xCarnivoro = new Snack.Builder().id(5).name("X-Carnivoro")
				.addIngredient(new Item(ovo, 1))
				.addIngredient(new Item(bacon, 1))
				.addIngredient(new Item(hamburgerCarne, 3))
				.addIngredient(new Item(queijo, 1))
				.build();
		SNACKS_BY_ID.put(xCarnivoro.getId(), xCarnivoro);
		SNACKS_BY_NAME.put(xCarnivoro.getName(), xCarnivoro);
		
		Snack xSalada = new Snack.Builder().id(5).name("X-Salada")
				.addIngredient(new Item(alface, 1))
				.addIngredient(new Item(hamburgerCarne, 1))
				.addIngredient(new Item(queijo, 1))
				.build();
		SNACKS_BY_ID.put(xSalada.getId(), xSalada);
		SNACKS_BY_NAME.put(xSalada.getName(), xSalada);
	}
}

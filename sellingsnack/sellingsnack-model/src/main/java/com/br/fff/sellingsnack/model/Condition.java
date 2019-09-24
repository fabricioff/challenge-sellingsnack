package com.br.fff.sellingsnack.model;

public class Condition {
	private Ingredient ingredient;
	private Boolean hasIngredient;
	
	public Condition(Ingredient ingredient, boolean hasIngredient) {
		this.ingredient = ingredient;
		this.hasIngredient = hasIngredient;
	}
	
	public Ingredient getIngredient() {
		return this.ingredient;
	}
	
	public Boolean hasIngredient() {
		return this.hasIngredient;
	}	
}

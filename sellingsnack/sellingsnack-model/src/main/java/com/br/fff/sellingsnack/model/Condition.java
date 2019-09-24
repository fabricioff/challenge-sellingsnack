package com.br.fff.sellingsnack.model;

import java.io.Serializable;

public class Condition implements Serializable {
	
	private static final long serialVersionUID = -2856901395807409682L;
	
	private Ingredient ingredient;
	private Integer amountIngredient;
		
	public Condition() {
		super();
	}

	public Condition(Ingredient ingredient, Integer amountIngredient) {
		this.ingredient = ingredient;
		this.amountIngredient = amountIngredient;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public Integer getAmountIngredient() {
		return amountIngredient;
	}

	public void setAmountIngredient(Integer amountIngredient) {
		this.amountIngredient = amountIngredient;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amountIngredient == null) ? 0 : amountIngredient.hashCode());
		result = prime * result + ((ingredient == null) ? 0 : ingredient.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Condition other = (Condition) obj;
		if (amountIngredient == null) {
			if (other.amountIngredient != null)
				return false;
		} else if (!amountIngredient.equals(other.amountIngredient))
			return false;
		if (ingredient == null) {
			if (other.ingredient != null)
				return false;
		} else if (!ingredient.equals(other.ingredient))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Condition [ingredient=" + ingredient + ", amountIngredient=" + amountIngredient + "]";
	}

}

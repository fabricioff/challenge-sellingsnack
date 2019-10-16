package com.br.fff.sellingsnack.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Snack implements Serializable {

	private static final long serialVersionUID = -4722795308521318962L;
	
	private Integer id;
	private String name;
	private List<Item> ingredients = new LinkedList<Item>();
	
	private Snack(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.ingredients = builder.ingredients;
	}
	
	public static class Builder {
		private Integer id;
		private String name;
		private List<Item> ingredients = new LinkedList<Item>();
		
		public Builder id(Integer id) {
			this.id = id;
			return this;
		}
		
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		
		public Builder addIngredient(Item ingredient) {
			this.ingredients.add(ingredient);
			return this;
		}
		
		public Snack build() {
			return new Snack(this);
		}		
	}

	public Integer getId() {
		return id;
	}	

	public String getName() {
		return name;
	}	
	
	public List<Item> getIngredients() {
		return ingredients;
	}	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ingredients == null) ? 0 : ingredients.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Snack other = (Snack) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ingredients == null) {
			if (other.ingredients != null)
				return false;
		} else if (!ingredients.equals(other.ingredients))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Snack [id=" + id + ", name=" + name + ", ingredients=" + ingredients + "]";
	}

}

package com.br.fff.sellingsnack.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author fabricio
 * 
 * Desig Pattern: Builder
 * 
 *
 */

public class Sale implements Serializable {

	private static final long serialVersionUID = 7390415536671066862L;

	private Integer id;
	private String name;
	private String description;
	private List<Condition> conditions = new LinkedList<Condition>();
	private Float deduction;
	private TypeDeduction typeDeduction;

	private Sale(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.description = builder.description;
		this.conditions = builder.conditions;
		this.deduction = builder.deduction;
		this.typeDeduction = builder.typeDeduction;
	}

	public static class Builder {
		private Integer id;
		private String name;
		private String description;
		private List<Condition> conditions = new LinkedList<Condition>();
		private Float deduction;
		private TypeDeduction typeDeduction;

		public Builder id(Integer id) {
			this.id = id;
			return this;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}
		
		public Builder description(String description) {
			this.description = description;
			return this;
		}

		public Builder addCondition(Condition condition) {
			this.conditions.add(condition);
			return this;
		}

		public Builder deduction(Float deduction) {
			this.deduction = deduction;
			return this;
		}
		
		public Builder typeDeduction(TypeDeduction typeDeduction) {
			this.typeDeduction = typeDeduction;
			return this;
		}
		
		public Sale build() {
			return new Sale(this);
		}
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}

	public List<Condition> getConditions() {
		return conditions;
	}

	public Float getDeduction() {
		return deduction;
	}
	
	public TypeDeduction getTypeDeduction() {
		return typeDeduction;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deduction == null) ? 0 : deduction.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((conditions == null) ? 0 : conditions.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((typeDeduction == null) ? 0 : typeDeduction.hashCode());
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
		Sale other = (Sale) obj;
		if (deduction == null) {
			if (other.deduction != null)
				return false;
		} else if (!deduction.equals(other.deduction))
			return false;
		if (typeDeduction == null) {
			if (other.typeDeduction != null)
				return false;
		} else if (!typeDeduction.equals(other.typeDeduction))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (conditions == null) {
			if (other.conditions != null)
				return false;
		} else if (!conditions.equals(other.conditions))
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
		return "Sale [id=" + id + ", name=" + name + ", conditions=" + conditions + ", deduction=" + deduction 
				+ ", typeDeduction=" + typeDeduction + "]";
	}

}

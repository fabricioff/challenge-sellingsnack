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

public class Promotion implements Serializable {

	private static final long serialVersionUID = 7390415536671066862L;

	private Integer id;
	private String name;
	private List<Condition> conditions = new LinkedList<Condition>();
	private Float deduction;

	private Promotion(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.conditions = builder.conditions;
		this.deduction = builder.deduction;
	}

	public static class Builder {
		private Integer id;
		private String name;
		private List<Condition> conditions = new LinkedList<Condition>();
		private Float deduction;

		public Builder id(Integer id) {
			this.id = id;
			return this;
		}

		public Builder name(String name) {
			this.name = name;
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
		
		public Promotion build() {
			return new Promotion(this);
		}
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Condition> getConditions() {
		return conditions;
	}

	public Float getDeduction() {
		return deduction;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deduction == null) ? 0 : deduction.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((conditions == null) ? 0 : conditions.hashCode());
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
		Promotion other = (Promotion) obj;
		if (deduction == null) {
			if (other.deduction != null)
				return false;
		} else if (!deduction.equals(other.deduction))
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
		return "Promotion [id=" + id + ", name=" + name + ", conditions=" + conditions + ", deduction=" + deduction
				+ "]";
	}

}

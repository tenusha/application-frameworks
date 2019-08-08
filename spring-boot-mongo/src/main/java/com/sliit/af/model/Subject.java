package com.sliit.af.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="subjects")
public class Subject {
	@Id
	String id;
	String name;
	String description;
	double amount;
	
	public Subject(String name, String description, double amount) {
		super();
		this.name = name;
		this.description = description;
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", description=" + description + ", amount=" + amount + "]";
	}
	
}

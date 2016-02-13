package br.com.casadocodigo.loja.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String title;
	
	@Lob
	private String description;
	
	private int numberOfPages;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	@Override
	public String toString() {
		return "Product { " //
				+ "title=" + title + "," //
				+ "description=" + description + "," //
				+ "numberOfPages=" + numberOfPages + "," //
				+ "}";
	}

}
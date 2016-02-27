package br.com.casadocodigo.loja.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private Integer id;

	@NotBlank
	private String title;

	@NotBlank
	@Lob
	private String description;

	@Min(30)
	private int numberOfPages;

	@ElementCollection
	private List<Price> prices = new ArrayList<Price>();

	@DateTimeFormat
	private Calendar releaseDate;

	private String summaryPath;

	public Integer getId() {
		return id;
	}

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

	public void setPrices(List<Price> prices) {
		this.prices = prices;
	}

	public List<Price> getPrices() {
		return prices;
	}

	public Calendar getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Calendar releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getSummaryPath() {
		return summaryPath;
	}

	public void setSummaryPath(String summaryPath) {
		this.summaryPath = summaryPath;
	}

	@Override
	public String toString() {
		return "Product { " //
				+ "title=" + title + "," //
				+ "description=" + description + "," //
				+ "numberOfPages=" + numberOfPages + "," //
				+ "}";
	}

	public BigDecimal priceFor(BookType bookType) {
		return prices.stream() //
				.filter(price -> price.getBookType().equals(bookType)) //
				.findFirst().get().getValue();
	}

}

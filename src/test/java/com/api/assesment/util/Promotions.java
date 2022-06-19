package com.api.assesment.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Json object to store Promotions
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Promotions implements JsonTypes
{
	
	@JsonProperty("Id")
	private int id;
	
	@JsonProperty("Name")
	private String name;
	
	@JsonProperty("Description")
	private String description;
	
	@JsonProperty("Price")
	private double price;
	
	@JsonProperty("OriginalPrice")
	private double originalPrice;
	
	@JsonProperty("MinimumPhotoCount")
	private int minimumPhotoCount;
	
	@JsonProperty("Recommended")
	private boolean recommended;
	
	@Override
	public String toString() {
		
		return "Values in Promotions ID " + this.id 
				+" Name "+ this.name
				+" Description " + this.description
				+" price "+ this.price
				+" OriginalPrice "+ this.originalPrice
				+" MinimumPhotoCount "+ this.minimumPhotoCount
				+" Recommended "+ this.recommended;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public double getOriginalPrice() {
		return originalPrice;
	}

	public int getMinimumPhotoCount() {
		return minimumPhotoCount;
	}

	public boolean isRecommended() {
		return recommended;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
	}

	public void setMinimumPhotoCount(int minimumPhotoCount) {
		this.minimumPhotoCount = minimumPhotoCount;
	}

	public void setRecommended(boolean recommended) {
		this.recommended = recommended;
	}
    
    
    
    
}

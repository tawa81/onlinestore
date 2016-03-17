/**
 * 
 */
package com.company.onlinestore.product.item;

import java.math.BigDecimal;

import com.company.onlinestore.product.category.ICategory;

/**
 * @author ATavanti
 *
 */
public class Item implements IItem {
	
	private String name;
	private BigDecimal price;
	private boolean isImported;
	private ICategory category;
	
	
	
	public Item(String name, BigDecimal price, boolean isImported,ICategory category) {
		super();
		this.name = name;
		this.price = price;
		this.isImported = isImported;
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public boolean isImported() {
		return isImported;
	}
	public void setImported(boolean isImported) {
		this.isImported = isImported;
	}
	public ICategory getCategory() {
		return category;
	}
	public void setCategory(ICategory category) {
		this.category = category;
	}

	
}

package com.company.onlinestore.product.item;

import java.math.BigDecimal;

import com.company.onlinestore.product.category.ICategory;

/**
 * Interface representing an item
 * @author ATavanti
 *
 */
public interface IItem {

	public BigDecimal getPrice();
	
	public String getName();
	
	public boolean isImported();
	
	public ICategory getCategory();
	
}

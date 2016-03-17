/**
 * 
 */
package com.company.onlinestore.product.category;

import com.company.onlinestore.salestax.ISalesTax;


/**
 * Interface for category of products
 * @author ATavanti
 *
 */
public interface ICategory {
	
	public String getName();
	
	public ISalesTax getSalesTax();

}

/**
 * 
 */
package com.company.onlinestore.product.category;

import com.company.onlinestore.salestax.ISalesTax;
import com.company.onlinestore.salestax.NoSalesTax;


/**
 * @author ATavanti
 *
 */
public class FoodCategory implements ICategory {


	public String getName() {
		return "Foods";
	}


	public ISalesTax getSalesTax() {
		return new NoSalesTax();
	}

}

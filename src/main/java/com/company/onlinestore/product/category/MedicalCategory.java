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
public class MedicalCategory implements ICategory {


	public String getName() {
		return "medical";
	}


	public ISalesTax getSalesTax() {
		return new NoSalesTax();
	}

}

package com.company.onlinestore.product.category;

import com.company.onlinestore.salestax.BasicSalesTax;
import com.company.onlinestore.salestax.ISalesTax;


public class CosmeticCategory implements ICategory {

	public String getName() {
		return "cosmetics";
	}

	public ISalesTax getSalesTax() {
		return new BasicSalesTax();
	}

}

package com.company.onlinestore.product.category;

import com.company.onlinestore.salestax.BasicSalesTax;
import com.company.onlinestore.salestax.ISalesTax;


public class MusicCategory implements ICategory {

	public String getName() {
		return "music";
	}

	public ISalesTax getSalesTax() {
		return new BasicSalesTax();
	}

}

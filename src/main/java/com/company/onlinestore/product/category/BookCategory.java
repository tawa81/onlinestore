package com.company.onlinestore.product.category;

import com.company.onlinestore.salestax.ISalesTax;
import com.company.onlinestore.salestax.NoSalesTax;


public class BookCategory implements ICategory {

	public String getName() {
		return "books";
	}

	public ISalesTax getSalesTax() {
		return new NoSalesTax();
	}

}

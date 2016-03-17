package com.company.onlinestore.salestax;

import java.math.BigDecimal;

public class NoSalesTax implements ISalesTax {

	public BigDecimal getRate() {
		return new BigDecimal("0.0");
	}

}

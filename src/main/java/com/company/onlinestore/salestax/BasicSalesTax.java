package com.company.onlinestore.salestax;

import java.math.BigDecimal;

public class BasicSalesTax implements ISalesTax {

	public BigDecimal getRate() {
		return new BigDecimal("0.10");
	}

}

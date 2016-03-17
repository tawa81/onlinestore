package com.company.onlinestore.salestax;

import java.math.BigDecimal;

public class ImportDutySalesTax implements ISalesTax{

	public BigDecimal getRate() {
		return new BigDecimal("0.05");
	}
}

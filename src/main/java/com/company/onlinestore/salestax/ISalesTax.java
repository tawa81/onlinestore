package com.company.onlinestore.salestax;

import java.math.BigDecimal;

/**
 * Interface representing sales tax (apply to the price of an item)
 * @author ATavanti
 *
 */
public interface ISalesTax {
	
	/**
	 * @return the rate of the sales tax
	 */
	public BigDecimal getRate();

}

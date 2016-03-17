package com.company.onlinestore.salestax.roundingpolicy;

import java.math.BigDecimal;

/**
 * Rounding policy: rule up (np/100 rounded up to the nearest 0.05)
 * @author ATavanti
 *
 */
public class RoundUpPolicy implements IRoundingPolicy {

	private BigDecimal roundValue = new BigDecimal("0.05");

	public BigDecimal getRoundedValue(BigDecimal value) { 
		BigDecimal divided = value.divide(roundValue, 0, BigDecimal.ROUND_UP);
		BigDecimal result = divided.multiply(roundValue);
		return result;
	}

}

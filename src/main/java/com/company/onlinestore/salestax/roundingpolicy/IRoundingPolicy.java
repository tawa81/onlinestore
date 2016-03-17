/**
 * 
 */
package com.company.onlinestore.salestax.roundingpolicy;

import java.math.BigDecimal;

/**
 * Interface for the policy of rounding sales tax
 * @author ATavanti
 *
 */
public interface IRoundingPolicy {
	
	public BigDecimal getRoundedValue(BigDecimal value);

}

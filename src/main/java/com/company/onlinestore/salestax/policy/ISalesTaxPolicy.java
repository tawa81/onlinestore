/**
 * 
 */
package com.company.onlinestore.salestax.policy;

import com.company.onlinestore.product.item.IItem;
import com.company.onlinestore.salestax.ISalesTax;
import com.company.onlinestore.salestax.ImportDutySalesTax;

/**
 * Sales Tax policy.
 * Applied to "special" taxes like {@link ImportDutySalesTax}
 * @author ATavanti
 *
 */
public interface ISalesTaxPolicy {
	
	public boolean isTaxApplicable(IItem item);
	
	public ISalesTax getSalesTax();

}

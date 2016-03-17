/**
 * 
 */
package com.company.onlinestore.salestax.policy;

import com.company.onlinestore.product.item.IItem;
import com.company.onlinestore.salestax.ISalesTax;
import com.company.onlinestore.salestax.ImportDutySalesTax;

/**
 * @author ATavanti
 *
 */
public class ImportDutyPolicy implements ISalesTaxPolicy {

	public boolean isTaxApplicable(IItem item) {
		if(item!=null){
			return item.isImported();
		}
		return false;
	}

	public ISalesTax getSalesTax() {
		return new ImportDutySalesTax();
	}

}

/**
 * 
 */
package com.company.onlinestore.salestax;

import java.math.BigDecimal;
import java.util.List;

import com.company.onlinestore.product.category.ICategory;
import com.company.onlinestore.product.item.IItem;
import com.company.onlinestore.salestax.policy.ISalesTaxPolicy;
import com.company.onlinestore.salestax.roundingpolicy.IRoundingPolicy;

/**
 * @author ATavanti
 *
 */
public class SalesTaxCalculator {
	
	public static BigDecimal calculateTax(IItem item,List<ISalesTaxPolicy> salesTaxPolicyList, IRoundingPolicy roundingPolicy){		
		ICategory category = item.getCategory();
		BigDecimal taxValue = new BigDecimal("0.0");
		if(category.getSalesTax()!=null){
			taxValue =item.getPrice().multiply(category.getSalesTax().getRate());
		}
		for (ISalesTaxPolicy salesTaxPolicy : salesTaxPolicyList) {
			if(salesTaxPolicy.isTaxApplicable(item)){
				taxValue = taxValue.add(item.getPrice().multiply(salesTaxPolicy.getSalesTax().getRate()));
			}
		}
		return roundingPolicy.getRoundedValue(taxValue);
	}

}

/**
 * 
 */
package com.company.onlinestore.payment;

import com.company.onlinestore.order.Order;
import com.company.onlinestore.receipt.IReceipt;

/**
 * @author ATavanti
 *
 */
public interface IPaymentStrategy {
	
	public IReceipt pay(Order order);

}

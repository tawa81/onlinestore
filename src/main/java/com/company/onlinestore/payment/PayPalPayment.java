/**
 * 
 */
package com.company.onlinestore.payment;

import com.company.onlinestore.order.Order;
import com.company.onlinestore.receipt.IReceipt;
import com.company.onlinestore.receipt.ExampleReceipt;

/**
 * @author ATavanti
 *
 */
public class PayPalPayment implements IPaymentStrategy {

	private String email;
	private String password;
	
	public PayPalPayment(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}


	public IReceipt pay(Order order) {
		// TODO complete transaction with payapl and update order status....
		return new ExampleReceipt(order);
	}

}

/**
 * 
 */
package com.company.onlinestore.payment;

import java.util.Date;

import com.company.onlinestore.order.Order;
import com.company.onlinestore.receipt.IReceipt;
import com.company.onlinestore.receipt.ExampleReceipt;

/**
 * @author ATavanti
 *
 */
public class CredidCardPayment implements IPaymentStrategy {

	private String crediCartNumber;
	private String cvv;
	private String owner;
	private Date expireDate;
	
	public CredidCardPayment(String crediCartNumber, String cvv, String owner,Date expireDate) {
		super();
		this.crediCartNumber = crediCartNumber;
		this.cvv = cvv;
		this.owner = owner;
		this.expireDate = expireDate;
	}


	public IReceipt pay(Order order) {
		// TODO complete credit card transaction and update order status...
		return new ExampleReceipt(order);
	}

}

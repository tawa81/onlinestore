/**
 * 
 */
package com.company.onlinestore;

import java.util.Arrays;
import java.util.List;

import com.company.onlinestore.order.Order;
import com.company.onlinestore.payment.IPaymentStrategy;
import com.company.onlinestore.receipt.IReceipt;
import com.company.onlinestore.salestax.policy.ISalesTaxPolicy;
import com.company.onlinestore.salestax.roundingpolicy.IRoundingPolicy;
import com.company.onlinestore.shoppingcart.ShoppingCart;

/**
 * Class representing the online store
 * 
 * @author ATavanti
 *
 */
public class OnlineStore {
	
	private IRoundingPolicy roundingTaxPolicy;
	private List<ISalesTaxPolicy> salesTaxPolicyList;

	/**
	 * OnlineStore constructor needs roundingTaxPolicy and some salesTaxPolicy
	 * @param roundingTaxPolicy
	 * @param salesTaxPolicy
	 */
	public OnlineStore(IRoundingPolicy roundingTaxPolicy,ISalesTaxPolicy... salesTaxPolicy){
		this.roundingTaxPolicy = roundingTaxPolicy;
		this.salesTaxPolicyList=Arrays.asList(salesTaxPolicy);
	}
	
	/**
	 * this method checkOut all the items inside the shopping cart and create a new Order
	 * @param shoppingCart
	 * @return new Order
	 */
	public Order checkOut(ShoppingCart shoppingCart){
		Order newOrder = new Order(shoppingCart,salesTaxPolicyList,roundingTaxPolicy);
		return newOrder;
	}
	
	/**
	 * confirm checkOut of the order with a specific kind of payment 
	 * @param order
	 * @param paymentStrategy
	 * @return the receipt
	 */
	public IReceipt confirmCheckOut(Order order,IPaymentStrategy paymentStrategy){
		return paymentStrategy.pay(order);
	}
	

}

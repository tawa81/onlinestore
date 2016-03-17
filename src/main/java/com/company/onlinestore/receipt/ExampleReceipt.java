package com.company.onlinestore.receipt;

import com.company.onlinestore.order.Order;
import com.company.onlinestore.order.OrderDetail;
import com.company.onlinestore.shoppingcart.ShoppingCartItem;

/**
 * Receipt of an order
 * @author ATavanti
 *
 */
public class ExampleReceipt implements IReceipt{

	private Order order;
	
	public ExampleReceipt(Order order) {
		super();
		this.order = order;
	}
	
	
	public void print(){
		System.out.println("********** Online store **********");
		for (OrderDetail orderDetail: order.getOrderDetailList()) {
			ShoppingCartItem shoppingCartItem = orderDetail.getShoppingCartItem();
			System.out.println(shoppingCartItem.getQuantity() + " " + shoppingCartItem.getItem().getName() + " :" + orderDetail.getCartItemTotalPrice());
		}
		System.out.println("Sales Taxes: " + order.getSalesTaxAmount());
		System.out.println("Total: " + order.getAmount());
		System.out.println("*********** Thank you ************");
		System.out.println("");
	}

	
}

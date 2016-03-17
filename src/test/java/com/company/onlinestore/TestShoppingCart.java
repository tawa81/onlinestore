/**
 * 
 */
package com.company.onlinestore;

import java.math.BigDecimal;

import junit.framework.TestCase;

import com.company.onlinestore.order.Order;
import com.company.onlinestore.payment.PayPalPayment;
import com.company.onlinestore.product.category.BookCategory;
import com.company.onlinestore.product.item.Item;
import com.company.onlinestore.receipt.IReceipt;
import com.company.onlinestore.salestax.roundingpolicy.RoundUpPolicy;
import com.company.onlinestore.shoppingcart.ShoppingCart;
import com.company.onlinestore.shoppingcart.ShoppingCartItem;

/**
 * @author ATavanti
 *
 */
public class TestShoppingCart extends TestCase{
	
	
	public void testShoppingCart(){
		ShoppingCart shoppingCart = new ShoppingCart();
		assertNotNull(shoppingCart);
	}
	
	public void testShoppingCart_addProduct(){
		ShoppingCart shoppingCart = new ShoppingCart();
		Item bookItem = new Item("book",new BigDecimal("12.49"),false, new BookCategory());
		ShoppingCartItem shoppingCarItem = new ShoppingCartItem(bookItem,1);
		shoppingCart.addShoppingCartItem(shoppingCarItem);
		assertEquals(1, shoppingCart.getShoppingCartItemList().size());
	}

	public void testShoppingCart_checkOut(){
		OnlineStore store = new OnlineStore(new RoundUpPolicy());
		ShoppingCart shoppingCart = new ShoppingCart();
		Item bookItem = new Item("book",new BigDecimal("12.49"),false, new BookCategory());
		ShoppingCartItem shoppingCarItem = new ShoppingCartItem(bookItem,1);
		shoppingCart.addShoppingCartItem(shoppingCarItem);
		assertEquals(1, shoppingCart.getShoppingCartItemList().size());
		Order order = store.checkOut(shoppingCart);
		assertNotNull(order);
	}
	
	public void testShoppingCart_confirmCheckOut(){
		OnlineStore store = new OnlineStore(new RoundUpPolicy());
		ShoppingCart shoppingCart = new ShoppingCart();
		Item bookItem = new Item("book",new BigDecimal("12.49"),false, new BookCategory());
		ShoppingCartItem shoppingCarItem = new ShoppingCartItem(bookItem,1);
		shoppingCart.addShoppingCartItem(shoppingCarItem);
		assertEquals(1, shoppingCart.getShoppingCartItemList().size());
		Order order = store.checkOut(shoppingCart);
		assertNotNull(order);
		IReceipt receipt = store.confirmCheckOut(order, new PayPalPayment("test@gmail.com", "123"));
		assertNotNull(receipt);
	}
	
	
	
	

}

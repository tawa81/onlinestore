/**
 * 
 */
package com.company.onlinestore;

import java.math.BigDecimal;

import junit.framework.TestCase;

import com.company.onlinestore.order.Order;
import com.company.onlinestore.payment.PayPalPayment;
import com.company.onlinestore.product.category.BookCategory;
import com.company.onlinestore.product.category.CosmeticCategory;
import com.company.onlinestore.product.category.FoodCategory;
import com.company.onlinestore.product.category.MedicalCategory;
import com.company.onlinestore.product.category.MusicCategory;
import com.company.onlinestore.product.item.Item;
import com.company.onlinestore.receipt.IReceipt;
import com.company.onlinestore.salestax.policy.ImportDutyPolicy;
import com.company.onlinestore.salestax.roundingpolicy.RoundUpPolicy;
import com.company.onlinestore.shoppingcart.ShoppingCart;
import com.company.onlinestore.shoppingcart.ShoppingCartItem;

/**
 * @author ATavanti
 *
 */
public class TestStore extends TestCase{
	

	public void testShoppingCart_testCaseInput1(){
		OnlineStore store = new OnlineStore(new RoundUpPolicy(),new ImportDutyPolicy());
		ShoppingCart shoppingCart = new ShoppingCart();
		Item bookItem = new Item("book",new BigDecimal("12.49"),false,new BookCategory());
		Item musicItem = new Item("music CD",new BigDecimal("14.99"),false, new MusicCategory());
		Item chocolateBarItem = new Item("chocolate bar",new BigDecimal("0.85"),false,new FoodCategory());
		shoppingCart.addShoppingCartItem(new ShoppingCartItem(bookItem,1));
		shoppingCart.addShoppingCartItem(new ShoppingCartItem(musicItem,1));
		shoppingCart.addShoppingCartItem(new ShoppingCartItem(chocolateBarItem,1));
		Order order = store.checkOut(shoppingCart);
		assertNotNull(order);
		assertEquals(new BigDecimal("1.50"),order.getSalesTaxAmount());
		assertEquals(new BigDecimal("29.83"),order.getAmount());
		IReceipt receipt = store.confirmCheckOut(order, new PayPalPayment("test@gmail.com", "123"));
		assertNotNull(receipt);
		receipt.print();
	}
	
	public void testShoppingCart_testCaseInput2(){
		OnlineStore store = new OnlineStore(new RoundUpPolicy(),new ImportDutyPolicy());
		ShoppingCart shoppingCart = new ShoppingCart();
		Item chocolateBarItem = new Item("imported box of chocolate",new BigDecimal("10.0"),true, new FoodCategory());
		Item parfumeItem = new Item("imported bootle of parfum",new BigDecimal("47.50"),true,new CosmeticCategory());
		shoppingCart.addShoppingCartItem(new ShoppingCartItem(chocolateBarItem,1));
		shoppingCart.addShoppingCartItem(new ShoppingCartItem(parfumeItem,1));
		Order order = store.checkOut(shoppingCart);
		assertNotNull(order);
		assertEquals(new BigDecimal("7.65"),order.getSalesTaxAmount());
		assertEquals(new BigDecimal("65.15"),order.getAmount());
		IReceipt receipt = store.confirmCheckOut(order, new PayPalPayment("test@gmail.com", "123"));
		assertNotNull(receipt);
		receipt.print();
	}
	
	public void testShoppingCart_testCaseInput3(){
		OnlineStore store = new OnlineStore(new RoundUpPolicy(),new ImportDutyPolicy());
		ShoppingCart shoppingCart = new ShoppingCart();
		Item parfumeItem = new Item("imported bootle of parfum",new BigDecimal("27.99"),true,new CosmeticCategory());
		Item parfume2Item = new Item("bootle of parfum",new BigDecimal("18.99"),false,new CosmeticCategory());
		Item medicalItem = new Item("packet headache pills",new BigDecimal("9.75"),false,new MedicalCategory());
		Item chocolateItem = new Item("box imported chocolate",new BigDecimal("11.25"),true,new FoodCategory());
		shoppingCart.addShoppingCartItem(new ShoppingCartItem(parfumeItem,1));
		shoppingCart.addShoppingCartItem(new ShoppingCartItem(parfume2Item,1));
		shoppingCart.addShoppingCartItem(new ShoppingCartItem(medicalItem,1));
		shoppingCart.addShoppingCartItem(new ShoppingCartItem(chocolateItem,1));
		Order order = store.checkOut(shoppingCart);
		assertNotNull(order);
		assertEquals(new BigDecimal("6.70"),order.getSalesTaxAmount());
		assertEquals(new BigDecimal("74.68"),order.getAmount());
		IReceipt receipt = store.confirmCheckOut(order, new PayPalPayment("test@gmail.com", "123"));
		assertNotNull(receipt);
		receipt.print();
	}
	
	public void testShoppingCart_testCaseMultipleInput3(){
		OnlineStore store = new OnlineStore(new RoundUpPolicy(),new ImportDutyPolicy());
		ShoppingCart shoppingCart = new ShoppingCart();
		Item parfumeItem = new Item("imported bootle of parfum",new BigDecimal("27.99"),true,new CosmeticCategory());
		Item parfume2Item = new Item("bootle of parfum",new BigDecimal("18.99"),false,new CosmeticCategory());
		Item medicalItem = new Item("packet headache pills",new BigDecimal("9.75"),false,new MedicalCategory());
		Item chocolateItem = new Item("box imported chocolate",new BigDecimal("11.25"),true,new FoodCategory());
		shoppingCart.addShoppingCartItem(new ShoppingCartItem(parfumeItem,2));
		shoppingCart.addShoppingCartItem(new ShoppingCartItem(parfume2Item,2));
		shoppingCart.addShoppingCartItem(new ShoppingCartItem(medicalItem,2));
		shoppingCart.addShoppingCartItem(new ShoppingCartItem(chocolateItem,2));
		Order order = store.checkOut(shoppingCart);
		assertNotNull(order);
		assertEquals(new BigDecimal("13.40"),order.getSalesTaxAmount());
		assertEquals(new BigDecimal("149.36"),order.getAmount());
		IReceipt receipt = store.confirmCheckOut(order, new PayPalPayment("test@gmail.com", "123"));
		assertNotNull(receipt);
		receipt.print();
	}
	
	

}

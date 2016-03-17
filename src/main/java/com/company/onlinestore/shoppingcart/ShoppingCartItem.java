/**
 * 
 */
package com.company.onlinestore.shoppingcart;

import com.company.onlinestore.product.item.IItem;

/**
 * Class representing an element of the {@link ShoppingCart}.
 * Contains an {@link IItem} and the relative quantity
 * @author ATavanti
 *
 */
public class ShoppingCartItem {
	
	private IItem item;
	private int quantity;
	
	
	public ShoppingCartItem(IItem item, int quantity) {
		this.item=item;
		this.quantity=quantity;
	}
	
	public IItem getItem() {
		return item;
	}
	public void setItem(IItem item) {
		this.item = item;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}

/**
 * 
 */
package com.company.onlinestore.shoppingcart;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for shopping cart. It's composed by a list of {@link ShoppingCartItem}
 * @author ATavanti
 *
 */
public class ShoppingCart {
	
	private List<ShoppingCartItem> shoppingCartItemList;
	
	/**
	 * add an element to the cart
	 * @param shoppingCartItem
	 */
	public void addShoppingCartItem(ShoppingCartItem shoppingCartItem) {
		if(shoppingCartItemList==null){
			shoppingCartItemList=new ArrayList<ShoppingCartItem>();
		}
		if(shoppingCartItem!=null){
			shoppingCartItemList.add(shoppingCartItem);
		}
	}
	

	public List<ShoppingCartItem> getShoppingCartItemList() {
		return shoppingCartItemList;
	}

	public void setShoppingCartItemList(List<ShoppingCartItem> shoppingCartItemList) {
		this.shoppingCartItemList = shoppingCartItemList;
	}

}

/**
 * 
 */
package com.company.onlinestore.order;

import java.math.BigDecimal;
import java.util.List;

import com.company.onlinestore.salestax.SalesTaxCalculator;
import com.company.onlinestore.salestax.policy.ISalesTaxPolicy;
import com.company.onlinestore.salestax.roundingpolicy.IRoundingPolicy;
import com.company.onlinestore.shoppingcart.ShoppingCartItem;

/**
 * @author ATavanti
 *
 */
public class OrderDetail {
	
	private ShoppingCartItem shoppingCartItem;
	private BigDecimal cartItemTax;
	private BigDecimal cartItemTotalTax;
	private BigDecimal cartItemPrice;
	private BigDecimal cartItemTotalPrice;

	public OrderDetail(ShoppingCartItem shoppingCartItem,List<ISalesTaxPolicy> salesTaxPolicyList, IRoundingPolicy roundingTaxPolicy) {
		this.shoppingCartItem=shoppingCartItem;
		BigDecimal itemPrice = shoppingCartItem.getItem().getPrice();
		cartItemTax = SalesTaxCalculator.calculateTax(shoppingCartItem.getItem(),salesTaxPolicyList,roundingTaxPolicy);
		cartItemTotalTax=cartItemTax.multiply(new BigDecimal(shoppingCartItem.getQuantity()));
		cartItemPrice=itemPrice.add(cartItemTax);
		cartItemTotalPrice=cartItemPrice.multiply(new BigDecimal(shoppingCartItem.getQuantity()));
	}

	public ShoppingCartItem getShoppingCartItem() {
		return shoppingCartItem;
	}

	public void setShoppingCartItem(ShoppingCartItem shoppingCartItem) {
		this.shoppingCartItem = shoppingCartItem;
	}

	public BigDecimal getCartItemTax() {
		return cartItemTax;
	}

	public void setCartItemTax(BigDecimal cartItemTax) {
		this.cartItemTax = cartItemTax;
	}

	public BigDecimal getCartItemTotalTax() {
		return cartItemTotalTax;
	}

	public void setCartItemTotalTax(BigDecimal cartItemTotalTax) {
		this.cartItemTotalTax = cartItemTotalTax;
	}

	public BigDecimal getCartItemPrice() {
		return cartItemPrice;
	}

	public void setCartItemPrice(BigDecimal cartItemPrice) {
		this.cartItemPrice = cartItemPrice;
	}

	public BigDecimal getCartItemTotalPrice() {
		return cartItemTotalPrice;
	}

	public void setCartItemTotalPrice(BigDecimal cartItemTotalPrice) {
		this.cartItemTotalPrice = cartItemTotalPrice;
	}
	
	

}

/**
 * 
 */
package com.company.onlinestore.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.company.onlinestore.salestax.policy.ISalesTaxPolicy;
import com.company.onlinestore.salestax.roundingpolicy.IRoundingPolicy;
import com.company.onlinestore.shoppingcart.ShoppingCart;
import com.company.onlinestore.shoppingcart.ShoppingCartItem;

/**
 * Online store order. It's composed by a list of @see {@link OrderDetail}
 * @author ATavanti
 *
 */
public class Order {

	private OrderState state;
	private BigDecimal amount;
	private BigDecimal salesTaxAmount;
	private List<OrderDetail> orderDetailList;
		
	public Order(ShoppingCart shoppingCart,List<ISalesTaxPolicy> salesTaxPolicyList,IRoundingPolicy roundingTaxPolicy) {
		super();
		state=OrderState.CREATED;
		amount=new BigDecimal("0.0");
		salesTaxAmount=new BigDecimal("0.0");
		for (ShoppingCartItem shoppingCartItem : shoppingCart.getShoppingCartItemList()) {
			OrderDetail orderDetail = new OrderDetail(shoppingCartItem,salesTaxPolicyList,roundingTaxPolicy);
			addOrderDetail(orderDetail);
		}
	}
	
	private void addOrderDetail(OrderDetail orderDetail) {
		if(orderDetailList==null){
			orderDetailList=new ArrayList<OrderDetail>();
		}
		amount=amount.add(orderDetail.getCartItemTotalPrice());
		salesTaxAmount=salesTaxAmount.add(orderDetail.getCartItemTotalTax());		
		orderDetailList.add(orderDetail);
	}
	
	public OrderState getState() {
		return state;
	}
	public void setState(OrderState state) {
		this.state = state;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public BigDecimal getSalesTaxAmount() {
		return salesTaxAmount;
	}
	public void setSalesTaxAmount(BigDecimal salesTaxAmount) {
		this.salesTaxAmount = salesTaxAmount;
	}
	public List<OrderDetail> getOrderDetailList() {
		return orderDetailList;
	}
	public void setOrderDetailList(List<OrderDetail> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}
	
	
	
	
}

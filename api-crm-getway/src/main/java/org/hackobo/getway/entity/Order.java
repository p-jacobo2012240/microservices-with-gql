package org.hackobo.getway.entity;

public class Order {
	
	private Long idOrder;
	private Product product;
	private int quantity;
	
	public Order() {}
	
	public Order(Long idOrder, Product product, int quantity) {
		super();
		this.idOrder = idOrder;
		this.product = product;
		this.quantity = quantity;
	}
	public Long getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(Long idOrder) {
		this.idOrder = idOrder;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	
}

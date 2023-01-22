package org.example.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "products_order")
public class ProductOrder {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @Column(name = "unity_price")
   private BigDecimal unityPrice;
   private int quantity;
   @ManyToOne(fetch = FetchType.LAZY)
   private Order order;
   @ManyToOne(fetch = FetchType.LAZY)
   private Product product;

   public ProductOrder() {}

   public ProductOrder(int quantity, Order order, Product product) {
      this.quantity = quantity;
      this.order = order;
      this.product = product;
      this.unityPrice = product.getPrice();
   }

   public Long getId() {
      return id;
   }

   public BigDecimal getValue() {
      return this.unityPrice.multiply(new BigDecimal(this.quantity));
   }

   public BigDecimal getUnityPrice() {
      return unityPrice;
   }

   public void setUnityPrice(BigDecimal unityPrice) {
      this.unityPrice = unityPrice;
   }

   public int getQuantity() {
      return quantity;
   }

   public void setQuantity(int quantity) {
      this.quantity = quantity;
   }

   public Order getOrder() {
      return order;
   }

   public void setOrder(Order order) {
      this.order = order;
   }

   public Product getProduct() {
      return product;
   }

   public void setProduct(Product product) {
      this.product = product;
   }

   public void setId(Long id) {
      this.id = id;
   }
}

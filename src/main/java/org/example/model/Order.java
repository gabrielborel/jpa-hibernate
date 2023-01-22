package org.example.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private LocalDate date = LocalDate.now();
   @Column(name = "total_value")
   private BigDecimal totalValue = BigDecimal.ZERO;
   @ManyToOne(fetch = FetchType.LAZY)
   private Customer costumer;
   @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
   private List<ProductOrder> products = new ArrayList<>();

   public Order() {}

   public Order(Customer costumer) {
      this.costumer = costumer;
   }

   public List<ProductOrder> getProducts() {
      return products;
   }

   public void addProduct(ProductOrder productOrder) {
      productOrder.setOrder(this);
      this.products.add(productOrder);
      this.totalValue = this.totalValue.add(productOrder.getValue());
   }

   public LocalDate getDate() {
      return date;
   }

   public void setDate(LocalDate date) {
      this.date = date;
   }

   public BigDecimal getTotalValue() {
      return totalValue;
   }

   public void setTotalValue(BigDecimal totalValue) {
      this.totalValue = totalValue;
   }

   public Customer getCostumer() {
      return costumer;
   }

   public void setCostumer(Customer costumer) {
      this.costumer = costumer;
   }
}

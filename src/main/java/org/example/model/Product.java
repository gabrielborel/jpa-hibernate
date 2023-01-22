package org.example.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "products")
@NamedQuery(name = "Product.productsByCategory", query = "SELECT p FROM Product as p WHERE p.category.name = :name")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Product {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String name;
   private String description;
   private BigDecimal price;
   @Column(name = "created_at")
   private LocalDate createdAt = LocalDate.now();
   @ManyToOne(fetch = FetchType.LAZY)
   private Category category;

   public Product(String name, String description, BigDecimal price, Category category) {
      this.name = name;
      this.description = description;
      this.price = price;
      this.category = category;
   }

   public Product() {
   }

   public LocalDate getCreated_at() {
      return createdAt;
   }

   public void setCreated_at(LocalDate createdAt) {
      this.createdAt = createdAt;
   }

   public Category getCategory() {
      return category;
   }

   public void setCategory(Category category) {
      this.category = category;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public Long getId() {
      return id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public BigDecimal getPrice() {
      return price;
   }

   public void setPrice(BigDecimal price) {
      this.price = price;
   }
}

package org.example.model;

import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class Book extends Product {
   private String author;
   private Integer pagesAmount;

   public Book(String name, String description, BigDecimal price, Category category, String author, Integer pagesAmount) {
      super(name, description, price, category);
      this.author = author;
      this.pagesAmount = pagesAmount;
   }

   public Book() {}

   public Book(String author, Integer pagesAmount) {
      this.author = author;
      this.pagesAmount = pagesAmount;
   }

   public String getAuthor() {
      return author;
   }

   public void setAuthor(String author) {
      this.author = author;
   }

   public Integer getPagesAmount() {
      return pagesAmount;
   }

   public void setPagesAmount(Integer pagesAmount) {
      this.pagesAmount = pagesAmount;
   }
}

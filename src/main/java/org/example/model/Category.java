package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String name;

   public Category(String name) {
      this.name = name;
   }

   public Category() {}

   public String getName() {
      return this.name;
   }
}

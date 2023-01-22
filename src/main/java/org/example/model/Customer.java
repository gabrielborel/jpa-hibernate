package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "consumers")
public class Customer {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @Embedded
   private PersonalData personalData;

   public Customer() {
   }

   public Customer(String name, String cpf) {
      this.personalData = new PersonalData(name, cpf);
   }

   public void setId(Long id) {
      this.id = id;
   }

   public Long getId() {
      return id;
   }

   public PersonalData getPersonalData() {
      return personalData;
   }

   public String getName() {
      return this.personalData.getName();
   }
}

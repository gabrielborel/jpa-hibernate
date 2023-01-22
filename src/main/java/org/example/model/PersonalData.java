package org.example.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class PersonalData {
   private String name;
   private String cpf;

   public PersonalData(String name, String cpf) {
      this.name = name;
      this.cpf = cpf;
   }

   public PersonalData() {
   }

   public String getName() {
      return name;
   }

   public String getCpf() {
      return cpf;
   }

   public void setName(String name) {
      this.name = name;
   }

   public void setCpf(String cpf) {
      this.cpf = cpf;
   }
}

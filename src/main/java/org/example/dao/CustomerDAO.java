package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.model.Customer;

public class CustomerDAO {
   private final EntityManager entityManager;

   public CustomerDAO(EntityManager em) {
      this.entityManager = em;
   }

   public void save(Customer customer) {
      this.entityManager.persist(customer);
   }

   public Customer findById(Long id) {
      return this.entityManager.find(Customer.class, id);
   }
}

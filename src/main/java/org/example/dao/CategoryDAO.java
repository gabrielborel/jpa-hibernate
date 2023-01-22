package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.model.Category;

public class CategoryDAO {
   private EntityManager entityManager;

   public CategoryDAO(EntityManager em) {
      this.entityManager = em;
   }

   public void save(Category category) {
      this.entityManager.persist(category);
   }

   public void update(Category category) {
      this.entityManager.merge(category);
   }

   public void delete(Category category) {
     this.entityManager.remove(this.entityManager.merge(category));
   }
}

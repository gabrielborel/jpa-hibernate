package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.example.model.Product;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class ProductDAO {
   private final EntityManager entityManager;

   public ProductDAO(EntityManager em) {
      this.entityManager = em;
   }

   public void save(Product product) {
      this.entityManager.persist(product);
   }

   public Product findById(Long id) {
      return this.entityManager.find(Product.class, id);
   }

   public List<Product> findAll() {
      String jpqlQuery = "SELECT p FROM Product as p";
      return this.entityManager.createQuery(jpqlQuery, Product.class).getResultList();
   }

   public List<Product> findByName(String name) {
      String jpqlQuery = "SELECT p FROM Product as p WHERE p.name = :name";
      return this.entityManager
         .createQuery(jpqlQuery, Product.class)
         .setParameter("name", name)
         .getResultList();
   }

   public List<Product> findByCategoryName(String name) {
      // String jpqlQuery = "SELECT p FROM Product as p WHERE p.category.name = :name";
      return this.entityManager
         .createNamedQuery("Product.productsByCategory", Product.class)
         .setParameter("name", name)
         .getResultList();
   }

   public BigDecimal findPriceByName(String name) {
      String jpqlQuery = "SELECT p.price FROM Product as p WHERE p.name = :name";
      return this.entityManager
         .createQuery(jpqlQuery, BigDecimal.class)
         .setParameter("name", name)
         .getSingleResult();
   }

   public List<Product> findByParamsWithCriteria(String name, BigDecimal price, LocalDate createdAt) {
      CriteriaBuilder cBuilder = this.entityManager.getCriteriaBuilder();
      CriteriaQuery<Product> cQuery = cBuilder.createQuery(Product.class);
      Root<Product> from = cQuery.from(Product.class);

      Predicate filters = cBuilder.and();

      if (name != null && !name.trim().isEmpty()) {
         filters = cBuilder.and(filters, cBuilder.equal(from.get("name"), name));
      }

      if (price != null) {
         filters = cBuilder.and(filters, cBuilder.equal(from.get("price"), price));
      }

      if (createdAt != null) {
         filters = cBuilder.and(filters, cBuilder.equal(from.get("created_at"), createdAt));
      }

      cQuery.where(filters);
      return this.entityManager.createQuery(cQuery).getResultList();
   }
}

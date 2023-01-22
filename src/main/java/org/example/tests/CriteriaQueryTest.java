package org.example.tests;

import jakarta.persistence.EntityManager;
import org.example.dao.ProductDAO;
import org.example.model.Product;
import org.example.seed.DatabaseSeed;
import org.example.utils.JPAUtil;

import java.math.BigDecimal;
import java.util.List;

public class CriteriaQueryTest {
   public static void main(String[] args) {
      DatabaseSeed.run();

      EntityManager entityManager = JPAUtil.getEntityManager();
      ProductDAO productDAO = new ProductDAO(entityManager);

      List<Product> products = productDAO.findByParamsWithCriteria("iPhone 14", new BigDecimal(7400), null);
      products.forEach((p) -> System.out.println("Product name: " + p.getName()));
   }
}

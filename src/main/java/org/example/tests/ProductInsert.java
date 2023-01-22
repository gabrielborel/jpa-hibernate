package org.example.tests;

import jakarta.persistence.EntityManager;
import org.example.dao.CategoryDAO;
import org.example.dao.ProductDAO;
import org.example.model.Category;
import org.example.model.Product;
import org.example.seed.DatabaseSeed;
import org.example.utils.JPAUtil;

import java.math.BigDecimal;
import java.util.List;

public class ProductInsert {
   public static void main(String[] args) {
      DatabaseSeed.run();
      EntityManager entityManager = JPAUtil.getEntityManager();

      ProductDAO productDAO = new ProductDAO(entityManager);
      List<Product> productList = productDAO.findByCategoryName("cellphones");
      productList.forEach((p) -> System.out.println(p.getName()));
   }
}

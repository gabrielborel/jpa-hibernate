package org.example.seed;

import jakarta.persistence.EntityManager;
import org.example.dao.CategoryDAO;
import org.example.dao.CustomerDAO;
import org.example.dao.OrderDAO;
import org.example.dao.ProductDAO;
import org.example.model.*;
import org.example.utils.JPAUtil;

import java.math.BigDecimal;

public class DatabaseSeed {
   public static void run() {
      EntityManager entityManager = JPAUtil.getEntityManager();

      ProductDAO productDAO = new ProductDAO(entityManager);
      CategoryDAO categoryDAO = new CategoryDAO(entityManager);
      CustomerDAO customerDAO = new CustomerDAO(entityManager);
      OrderDAO orderDAO = new OrderDAO(entityManager);

      Category category = new Category("tvs");
      Category categoryTwo = new Category("food");
      Product productTwo = new Product("Hamburguer", "A Mac donalds", new BigDecimal(50), categoryTwo);
      Product product = new Product("iPhone 14", "an iPhone 14", new BigDecimal(7400), category);
      Customer customer = new Customer("Gabriel", "19252283714");
      Order order = new Order(customer);
      order.addProduct(new ProductOrder(5, order, product));
      order.addProduct(new ProductOrder(10, order, productTwo));

      entityManager.getTransaction().begin();

      customerDAO.save(customer);
      categoryDAO.save(category);
      categoryDAO.save(categoryTwo);
      productDAO.save(product);
      productDAO.save(productTwo);
      orderDAO.save(order);

      entityManager.getTransaction().commit();
      entityManager.close();
   }
}

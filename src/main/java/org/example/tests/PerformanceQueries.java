package org.example.tests;

import jakarta.persistence.EntityManager;
import org.example.dao.OrderDAO;
import org.example.model.Order;
import org.example.seed.DatabaseSeed;
import org.example.utils.JPAUtil;

public class PerformanceQueries {
   public static void main(String[] args) {
      DatabaseSeed.run();

      EntityManager entityManager = JPAUtil.getEntityManager();
      OrderDAO orderDAO = new OrderDAO(entityManager);

      Order order = orderDAO.findWithCostumer(1L);
      entityManager.close();

      System.out.println(order.getCostumer().getName());
   }
}

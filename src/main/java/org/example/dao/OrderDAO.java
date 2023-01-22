package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.model.Order;
import org.example.vo.SalesReportVO;

import java.math.BigDecimal;
import java.util.List;

public class OrderDAO {
   private final EntityManager entityManager;

   public OrderDAO(EntityManager em) {
      this.entityManager = em;
   }

   public void save(Order order) {
      this.entityManager.persist(order);
   }

   public BigDecimal totalAmountSold() {
      String jpqlQuery = "SELECT SUM(o.totalValue) FROM Order as o";
      return this.entityManager
         .createQuery(jpqlQuery, BigDecimal.class)
         .getSingleResult();
   }

   public List<SalesReportVO> salesReport() {
      String jpqlQuery = "SELECT new org.example.vo.SalesReportVO("
         + "p.name, "
         + "SUM(op.quantity), "
         + "MAX(o.date)) "
         + "FROM Order as o "
         + "JOIN o.products as op "
         + "JOIN op.product as p "
         + "GROUP BY p.name ";

      return this.entityManager
         .createQuery(jpqlQuery, SalesReportVO.class)
         .getResultList();
   }

   public Order findWithCostumer(Long id) {
      String jpqlQuery = "SELECT o FROM Order as o JOIN FETCH o.costumer WHERE o.id = :id";
      return this.entityManager
         .createQuery(jpqlQuery, Order.class)
         .setParameter("id", id)
         .getSingleResult();
   }
}

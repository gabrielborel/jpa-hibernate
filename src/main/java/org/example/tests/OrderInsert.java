package org.example.tests;

import jakarta.persistence.EntityManager;
import org.example.dao.CategoryDAO;
import org.example.dao.CustomerDAO;
import org.example.dao.OrderDAO;
import org.example.dao.ProductDAO;
import org.example.model.*;
import org.example.seed.DatabaseSeed;
import org.example.utils.JPAUtil;
import org.example.vo.SalesReportVO;

import java.math.BigDecimal;
import java.util.List;

public class OrderInsert {
   public static void main(String[] args) {
      DatabaseSeed.run();

      EntityManager entityManager = JPAUtil.getEntityManager();
      OrderDAO orderDAO = new OrderDAO(entityManager);

      List<SalesReportVO> report = orderDAO.salesReport();
      for (SalesReportVO saleReport : report) {
         System.out.println(saleReport.getProductName());
         System.out.println(saleReport.getQuantitySold());
         System.out.println(saleReport.getLastSoldDate());
      }
   }
}

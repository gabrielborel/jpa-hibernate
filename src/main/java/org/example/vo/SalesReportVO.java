package org.example.vo;

import java.time.LocalDate;

public class SalesReportVO {
   private final String productName;
   private final Long quantitySold;
   private final LocalDate lastSoldDate;

   public SalesReportVO(String productName, Long quantitySold, LocalDate lastSoldDate) {
      this.productName = productName;
      this.quantitySold = quantitySold;
      this.lastSoldDate = lastSoldDate;
   }

   public String getProductName() {
      return productName;
   }

   public Long getQuantitySold() {
      return quantitySold;
   }

   public LocalDate getLastSoldDate() {
      return lastSoldDate;
   }
}

package com.api.parking.domain;

public class Invoice {
  public static double issueParkingPrice(long totalPassedHours) {
    double totalParking = 0;
    double aditionalTax = 0;

    if(totalPassedHours > 0 && totalPassedHours <= 6) {
      totalParking = 300 * totalPassedHours;
    } else {
      long totalTimePassedAfterParkingLimit = totalPassedHours - 6;
      aditionalTax = 200 * totalTimePassedAfterParkingLimit;
      totalParking = (300 * 6) + aditionalTax;
    }

    return totalParking;
  }
}

package by.pvt.fedosevich.bookstore.bean;

import java.util.Objects;

public class Profit {
  private int countOfSoldBooks;
  private double totalPrice;

  public Profit(int countOfSoldBooks, double totalPrice) {
    this.countOfSoldBooks = countOfSoldBooks;
    this.totalPrice = totalPrice;
  }

  public int getCountOfSoldBooks() {
    return countOfSoldBooks;
  }

  public void setCountOfSoldBooks(int countOfSoldBooks) {
    this.countOfSoldBooks = countOfSoldBooks;
  }

  public double getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(double totalPrice) {
    this.totalPrice = totalPrice;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Profit profit = (Profit) o;
    return countOfSoldBooks == profit.countOfSoldBooks
        && Double.compare(profit.totalPrice, totalPrice) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(countOfSoldBooks, totalPrice);
  }

  @Override
  public String toString() {
    return "всего " + countOfSoldBooks +
        " книг(и) на сумму " + totalPrice;
  }
}

package by.pvt.fedosevich.bookstore.bean;

import java.util.Arrays;
import java.util.Objects;

public class Order {
  private long id;
  private long customerId;
  private long sellerId;
  private long[] books;

  public Order(long id, long customerId, long sellerId, long[] books) {
    this.id = id;
    this.customerId = customerId;
    this.sellerId = sellerId;
    this.books = books;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(long customerId) {
    this.customerId = customerId;
  }

  public long getSellerId() {
    return sellerId;
  }

  public void setSellerId(long sellerId) {
    this.sellerId = sellerId;
  }

  public long[] getBooks() {
    return books;
  }

  public void setBooks(long[] books) {
    this.books = books;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Order order = (Order) o;
    return id == order.id && customerId == order.customerId && sellerId == order.sellerId
        && Arrays.equals(books, order.books);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(id, customerId, sellerId);
    result = 31 * result + Arrays.hashCode(books);
    return result;
  }

  @Override
  public String toString() {
    return "Order{" +
        "id=" + id +
        ", customerId=" + customerId +
        ", sellerId=" + sellerId +
        ", books=" + Arrays.toString(books) +
        '}';
  }
}

package by.pvt.fedosevich.bookstore.repository.datasource;

import by.pvt.fedosevich.bookstore.bean.Book;
import by.pvt.fedosevich.bookstore.bean.Customer;
import by.pvt.fedosevich.bookstore.bean.Order;
import by.pvt.fedosevich.bookstore.bean.Seller;
import java.util.List;

public interface BookDataSource {
  List<Book> getBooks();
  List<Customer> getCustomers();
  List<Seller> getSellers();
  List<Order> getOrders();

}

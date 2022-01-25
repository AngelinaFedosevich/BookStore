package test.repository;

import static org.junit.jupiter.api.Assertions.*;

import by.pvt.fedosevich.bookstore.bean.Book;
import by.pvt.fedosevich.bookstore.bean.BookGenre;
import by.pvt.fedosevich.bookstore.bean.Customer;
import by.pvt.fedosevich.bookstore.bean.Order;
import by.pvt.fedosevich.bookstore.bean.Profit;
import by.pvt.fedosevich.bookstore.bean.Seller;
import by.pvt.fedosevich.bookstore.repository.BookRepository;
import by.pvt.fedosevich.bookstore.repository.BookRepositoryImpl;
import by.pvt.fedosevich.bookstore.repository.datasource.BookDataSource;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BookRepositoryImplTest {
  private final List<Order> orders = new ArrayList<>();
  private final List<Customer> customers = new ArrayList<>();
  private final List<Seller> sellers = new ArrayList<>();
  private final List<Book> books = new ArrayList<>();

  BookDataSource bookDataSource;
  BookRepository bookRepository;

  @BeforeEach
  void setUp(){
   bookDataSource = Mockito.mock(BookDataSource.class);
   bookRepository = new BookRepositoryImpl(bookDataSource);
   initTestData();
    Mockito.when(bookDataSource.getOrders()).thenReturn(orders);
    Mockito.when(bookDataSource.getCustomers()).thenReturn(customers);
    Mockito.when(bookDataSource.getSellers()).thenReturn(sellers);
    Mockito.when(bookDataSource.getBooks()).thenReturn(books);
  }

  @Test
  public void getProfitBySeller(){
    Profit profit = new Profit(1, 10.00);
    assertEquals(bookRepository.getProfitBySeller(158), profit);
  }

  private void initTestData(){
    orders.add(new Order(01012201, 15794, 158, new long[]{987451}));
    sellers.add(new Seller(158, "Иванова Валентина", 25));
    customers.add(new Customer(15794, "Данилюк Жанна", 22));
    books.add(new Book(987451, "Портрет Дориана Грея", "Оскар Уальд", 10.00, BookGenre.IMAGINATIVE_LITERATURE));
  }

}
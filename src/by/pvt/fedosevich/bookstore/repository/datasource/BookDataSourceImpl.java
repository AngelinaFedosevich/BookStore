package by.pvt.fedosevich.bookstore.repository.datasource;

import by.pvt.fedosevich.bookstore.bean.Book;
import by.pvt.fedosevich.bookstore.bean.BookGenre;
import by.pvt.fedosevich.bookstore.bean.Customer;
import by.pvt.fedosevich.bookstore.bean.Order;
import by.pvt.fedosevich.bookstore.bean.Seller;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BookDataSourceImpl implements BookDataSource {
  private List<Book> books = new ArrayList<>();
  private List<Customer> customers = new ArrayList<>();
  private List<Seller> sellers = new ArrayList<>();
  private List<Order> orders = new ArrayList<>();

  public BookDataSourceImpl(){initData();}

  private void initData(){
    sellers.add(new Seller(158, "Иванова Валентина", 25));
    sellers.add(new Seller(368, "Петров Владимир", 28));
    sellers.add(new Seller(851, "Сидорова Ольга", 20));
    customers.add(new Customer(15794, "Данилюк Жанна", 22));
    customers.add(new Customer(98751, "Берашевич Вадим", 18));
    customers.add(new Customer(31675, "Глинский Пётр", 33));
    customers.add(new Customer(54128, "Онищук Алина", 50));
    customers.add(new Customer(54111, "Заяц Валентина", 55));
    books.add(new Book(987451, "Портрет Дориана Грея", "Оскар Уальд", 10.00, BookGenre.IMAGINATIVE_LITERATURE));
    books.add(new Book(845711, "Маленький принц", "Антуан де Сент-Экзюпери", 11.81, BookGenre.IMAGINATIVE_LITERATURE));
    books.add(new Book(123453, "Подсознание может всё", "Джон Кехо", 18.00,BookGenre.PSYCHOLOGY));
    books.add(new Book(845715, "Как перестать беспокоиться и начать жить", "Дейл Карнеги", 16.00, BookGenre.PSYCHOLOGY));
    books.add(new Book(741254, "Совершенный код", "Макконнел Стив", 53.62, BookGenre.PROGRAMMING));
    books.add(new Book(357898, "Рефакторинг.Улучшение существующего кода", "Фаулер Мартин", 73.22, BookGenre.PROGRAMMING));
    books.add(new Book(845761, "Гарри Поттер и Филосовский камень", "Джоан Роулинг", 25.33, BookGenre.FANTASY));
    books.add(new Book(587421, "Игра престолов", "Джордж Мартин", 81.00, BookGenre.FANTASY));
    books.add(new Book(321654, "Дом на краю ночи", "Кэтрин Бэннер", 33.12, BookGenre.BEST_SELLING));
    books.add(new Book(987654, "Ход королевы", "Уолтер Тевис", 19.63, BookGenre.BEST_SELLING));
    orders.add(new Order(01012201, 15794, 158, new long[]{987451, 845711}));
    orders.add(new Order(01012202, 98751, 368, new long[]{123453, 845715, 987451}));
    orders.add(new Order(02012201, 31675, 158, new long[]{987654, 321654, 74125, 845715}));
    orders.add(new Order(03012201, 54128, 158, new long[]{845761, 321654}));
    orders.add(new Order(05012206, 54111, 851, new long[]{987451, 123453, 845715, 587421}));
  }

  public BookDataSourceImpl(List<Book> books, List<Customer> customers,
      List<Seller> sellers, List<Order> orders) {
    this.books = books;
    this.customers = customers;
    this.sellers = sellers;
    this.orders = orders;
  }

  @Override
  public List<Book> getBooks() {
    return books;
  }

  public void setBooks(List<Book> books) {
    this.books = books;
  }

  @Override
  public List<Customer> getCustomers() {
    return customers;
  }

  public void setCustomers(List<Customer> customers) {
    this.customers = customers;
  }

  @Override
  public List<Seller> getSellers() {
    return sellers;
  }

  public void setSellers(List<Seller> sellers) {
    this.sellers = sellers;
  }

  @Override
  public List<Order> getOrders() {
    return orders;
  }

  public void setOrders(List<Order> orders) {
    this.orders = orders;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BookDataSourceImpl that = (BookDataSourceImpl) o;
    return Objects.equals(books, that.books) && Objects.equals(customers,
        that.customers) && Objects.equals(sellers, that.sellers)
        && Objects.equals(orders, that.orders);
  }

  @Override
  public int hashCode() {
    return Objects.hash(books, customers, sellers, orders);
  }

  @Override
  public String toString() {
    return "BookDataSourceImpl{" +
        "books=" + books +
        ", customers=" + customers +
        ", sellers=" + sellers +
        ", orders=" + orders +
        '}';
  }
}

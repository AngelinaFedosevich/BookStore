package by.pvt.fedosevich.bookstore.repository;

import by.pvt.fedosevich.bookstore.bean.Book;
import by.pvt.fedosevich.bookstore.bean.BookAdditional;
import by.pvt.fedosevich.bookstore.bean.BookGenre;
import by.pvt.fedosevich.bookstore.bean.Customer;
import by.pvt.fedosevich.bookstore.bean.Order;
import by.pvt.fedosevich.bookstore.bean.Profit;
import by.pvt.fedosevich.bookstore.repository.datasource.BookDataSource;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class BookRepositoryImpl implements BookRepository{
  private final BookDataSource bookDataSource;

  public BookRepositoryImpl(
      BookDataSource bookDataSource) {
    this.bookDataSource = bookDataSource;
  }
  /**
   * Find the most popular genre with customers elder the #age
   * @param age required age
   * @return the most popular genre
   */
  public BookGenre getMostPopularGenreMoreThenAge(int age){
    ArrayList<Long> customersIds = new ArrayList<>();
    for (Customer customer : bookDataSource.getCustomers()) {
      if(customer.getAge() > age){
        customersIds.add(customer.getId());
      }
    }
    return getMostPopularBookGenre(customersIds);
  }
  /**
   * Find the most popular genre with customers younger the #age
   * @param age required age
   * @return the most popular genre
   */
  public BookGenre getMostPopularGenreLessThenAge(int age){
    ArrayList<Long> customersIds = new ArrayList<>();
    for (Customer customer : bookDataSource.getCustomers()) {
      if(customer.getAge() < age){
        customersIds.add(customer.getId());
      }
    }
    return getMostPopularBookGenre(customersIds);
  }
  /**
   * Find the most popular book genre with customers
   * @param customersIds customers id
   * @return genre
   */
  private BookGenre getMostPopularBookGenre(ArrayList<Long> customersIds) {
    int countOfImaginativeLiterature = 0;
    int countOfPsychology = 0;
    int countOfProgramming = 0;
    int countOfFantasy = 0;
    int countOfBestSelling = 0;
    for (Order order : bookDataSource.getOrders()) {
      if(customersIds.contains(order.getCustomerId())){
        countOfImaginativeLiterature += getCountOfSoldBooksByCertainGenre(order, BookGenre.IMAGINATIVE_LITERATURE);
        countOfPsychology += getCountOfSoldBooksByCertainGenre(order, BookGenre.PSYCHOLOGY);
        countOfProgramming += getCountOfSoldBooksByCertainGenre(order, BookGenre.PROGRAMMING);
        countOfFantasy += getCountOfSoldBooksByCertainGenre(order, BookGenre.FANTASY);
        countOfBestSelling += getCountOfSoldBooksByCertainGenre(order, BookGenre.BEST_SELLING);
      }
    }
    ArrayList<BookAdditional> result = new ArrayList<>();
    result.add(new BookAdditional(BookGenre.IMAGINATIVE_LITERATURE, countOfImaginativeLiterature));
    result.add(new BookAdditional(BookGenre.PSYCHOLOGY, countOfPsychology));
    result.add(new BookAdditional(BookGenre.PROGRAMMING, countOfProgramming));
    result.add(new BookAdditional(BookGenre.FANTASY, countOfFantasy));
    result.add(new BookAdditional(BookGenre.BEST_SELLING, countOfBestSelling));
    result.sort(new Comparator<BookAdditional>() {
      @Override
      public int compare(BookAdditional o1, BookAdditional o2) {
        return o2.getCount() - o1.getCount();
      }
    });
    return result.get(0).getGenre();
  }
  /**
   * Calculate how many books have been sold by each genre
   * @return count of sold books by each genre
   */
  public ArrayList<BookAdditional> getCountOfSoldBooksByGenre(){
    ArrayList<BookAdditional> result = new ArrayList<>();
    int countOfImaginativeLiterature = 0;
    int countOfPsychology = 0;
    int countOfProgramming = 0;
    int countOfFantasy = 0;
    int countOfBestSelling = 0;
    for (Order order : bookDataSource.getOrders()) {
      countOfImaginativeLiterature += getCountOfSoldBooksByCertainGenre(order, BookGenre.IMAGINATIVE_LITERATURE);
      countOfPsychology += getCountOfSoldBooksByCertainGenre(order, BookGenre.PSYCHOLOGY);
      countOfProgramming += getCountOfSoldBooksByCertainGenre(order, BookGenre.PROGRAMMING);
      countOfFantasy += getCountOfSoldBooksByCertainGenre(order, BookGenre.FANTASY);
      countOfBestSelling += getCountOfSoldBooksByCertainGenre(order, BookGenre.BEST_SELLING);
    }
    result.add(new BookAdditional(BookGenre.IMAGINATIVE_LITERATURE, countOfImaginativeLiterature));
    result.add(new BookAdditional(BookGenre.PSYCHOLOGY, countOfPsychology));
    result.add(new BookAdditional(BookGenre.PROGRAMMING, countOfProgramming));
    result.add(new BookAdditional(BookGenre.FANTASY, countOfFantasy));
    result.add(new BookAdditional(BookGenre.BEST_SELLING, countOfBestSelling));
    return result;
  }
  /**
   * Calculate how many books have been sold by certain genre
   * @param order order of books
   * @param genre genre of books
   * @return count of sold books by certain genre
   */
  public int getCountOfSoldBooksByCertainGenre(Order order, BookGenre genre){
    int count = 0;
    for (long bookId : order.getBooks()) {
      Book book = getBookById(bookId);
      if(book != null && book.getBookGenre() == genre)
        count++;
    }
    return count;
  }
  /**
   * Calculate the price of sold books by certain genre
   * @return the price of sold books by certain genre
   */
  public HashMap<BookGenre, Double> getPriceOfSoldBooksByCertainGenre(){
    HashMap<BookGenre, Double> result = new HashMap<>();
    double priceOfImaginativeLiterature = 0;
    double priceOfPsychology = 0;
    double priceOfProgramming = 0;
    double priceOfFantasy = 0;
    double priceOfBestSelling = 0;
    for (Order order : bookDataSource.getOrders()) {
      priceOfImaginativeLiterature += getPriceOfSoldBooksByCertainGenre(order, BookGenre.IMAGINATIVE_LITERATURE);
      priceOfPsychology += getPriceOfSoldBooksByCertainGenre(order, BookGenre.PSYCHOLOGY);
      priceOfProgramming += getPriceOfSoldBooksByCertainGenre(order, BookGenre.PROGRAMMING);
      priceOfFantasy += getPriceOfSoldBooksByCertainGenre(order, BookGenre.FANTASY);
      priceOfBestSelling += getPriceOfSoldBooksByCertainGenre(order, BookGenre.BEST_SELLING);
    }
    result.put(BookGenre.IMAGINATIVE_LITERATURE, priceOfImaginativeLiterature);
    result.put(BookGenre.PSYCHOLOGY, priceOfPsychology);
    result.put(BookGenre.PROGRAMMING, priceOfProgramming);
    result.put(BookGenre.FANTASY, priceOfFantasy);
    result.put(BookGenre.BEST_SELLING, priceOfBestSelling);
    return result;
  }
  /**
   * Calculate the total price of certain genre books in the order
   * @param order order of books
   * @param genre genre of book
   * @return price of books of a certain genre
   */
  public double getPriceOfSoldBooksByCertainGenre(Order order, BookGenre genre){
    double price = 0;
    for (long bookId : order.getBooks()) {
      Book book = getBookById(bookId);
      if (book != null && book.getBookGenre() == genre){
        price += book.getPrice();
      }
    }
    return price;
  }
  /**
   * Calculate count of sold books and total price for a seller
   * @param sellerId seller's unique number
   * @return count of sold books and total price for a seller
   */
  public Profit getProfitBySeller(long sellerId){
    int countOfSoldBooks = 0;
    double totalPrice = 0;
    for (Order order : bookDataSource.getOrders()) {
      if (order.getSellerId() == sellerId){
        totalPrice += getPriceOfSoldBooksInOrder(order);
        countOfSoldBooks += order.getBooks().length;
      }
    }
    return new Profit(countOfSoldBooks, totalPrice);
  }
  /**
   * Calculate the cost of all orders
   * @return cost of all orders
   */
  public double getAllPriceOfSoldBooks(){
    double price = 0;
    for (Order order : bookDataSource.getOrders()) {
      price += getPriceOfSoldBooksInOrder(order);
    }
    return price;
  }
  /**
   * Calculate the cost of the order
   * @param order is order to count the cost
   * @return cost of the order
   */
  public double getPriceOfSoldBooksInOrder(Order order){
    double price = 0;
    for (long bookId : order.getBooks()) {
      Book book = getBookById(bookId);
      if (book != null){
        price += book.getPrice();
      }
    }
    return price;
  }
  /**
   * Calculate how many books have been sold
   * @return count of sold books
   */
  public int getCountOfSoldBooks(){
    int count = 0;
    for (Order order : bookDataSource.getOrders()) {
      count += order.getBooks().length;
    }
    return count;
  }
  /**
   * Search book by unique number
   * @param id book's unique number
   * @return book
   */
  public Book getBookById(long id){
    Book current = null;
    for (Book book : bookDataSource.getBooks()) {
      if (book.getId() == id){
        current = book;
        break;
      }
    }
    return current;
  }
}

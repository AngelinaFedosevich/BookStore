package by.pvt.fedosevich.bookstore.ui;

import by.pvt.fedosevich.bookstore.bean.BookAdditional;
import by.pvt.fedosevich.bookstore.bean.BookGenre;
import by.pvt.fedosevich.bookstore.bean.Seller;
import by.pvt.fedosevich.bookstore.repository.BookRepository;
import by.pvt.fedosevich.bookstore.repository.datasource.BookDataSource;
import java.util.ArrayList;
import java.util.HashMap;

public class BookAdapter {
  private final BookRepository repository;
  private final BookDataSource bookDataSource;

  public BookAdapter(BookRepository repository,
      BookDataSource bookDataSource) {
    this.repository = repository;
    this.bookDataSource = bookDataSource;
  }
  public void show() {

    //задача 1 Получить общее количество проданных книг и их стоимость
    String booksInfo =
        String.format("Общее количество проданных книг %d на сумму %f", repository.getCountOfSoldBooks(), repository.getAllPriceOfSoldBooks());
    System.out.println(booksInfo);

    //задача 2 Получить количество и стоимость проданных книг по продавцам
    for (Seller seller : bookDataSource.getSellers()) {
      System.out.println(seller.getName() +" продал(а) "+ repository.getProfitBySeller(seller.getId()).toString());
    }

    //задача 3 Получить количество проданных книг и их стоимость по жанрам
    ArrayList<BookAdditional> soldBooksCount = repository.getCountOfSoldBooksByGenre();
    HashMap<BookGenre, Double> soldBooksPrice = repository.getPriceOfSoldBooksByCertainGenre();
    String soldBookStr = "По жанру: %s продано %d книг(и) общей стоимостью %f";
    for (BookAdditional bookAdditional : soldBooksCount){
      double price = soldBooksPrice.get(bookAdditional.getGenre());
      System.out.println(
          String.format(
              soldBookStr,
              bookAdditional.getGenre().name(),
              bookAdditional.getCount(),
              price));
    }

    //задача 4 Какой жанр популярен среди покупателей в возрасте до 30 лет
    int age = 30;
    String analyzeGenreStr = "Покупатели младше %d лет выбирают жанр %s";
    System.out.println(String.format(analyzeGenreStr, 30, repository.getMostPopularGenreLessThenAge(30)));

    // задача 5 Какой жанр популярен среди покупателей в возрасте после 30 лет
    String analyzeGenreStr2 = "Покупатели старше %d лет выбирают жанр %s";
    System.out.println(String.format(analyzeGenreStr2, 30, repository.getMostPopularGenreMoreThenAge(30)));
  }
}

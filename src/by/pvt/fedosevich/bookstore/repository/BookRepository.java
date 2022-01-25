package by.pvt.fedosevich.bookstore.repository;

import by.pvt.fedosevich.bookstore.bean.BookAdditional;
import by.pvt.fedosevich.bookstore.bean.BookGenre;
import by.pvt.fedosevich.bookstore.bean.Profit;
import java.util.ArrayList;
import java.util.HashMap;

public interface BookRepository {
  int getCountOfSoldBooks();
  double getAllPriceOfSoldBooks();
  Profit getProfitBySeller(long sellerId);
  ArrayList<BookAdditional> getCountOfSoldBooksByGenre();
  HashMap<BookGenre, Double> getPriceOfSoldBooksByCertainGenre();
  BookGenre getMostPopularGenreLessThenAge(int age);
  BookGenre getMostPopularGenreMoreThenAge(int age);


}

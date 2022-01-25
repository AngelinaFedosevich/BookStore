package by.pvt.fedosevich.bookstore.ui;

import by.pvt.fedosevich.bookstore.repository.BookRepository;
import by.pvt.fedosevich.bookstore.repository.BookRepositoryImpl;
import by.pvt.fedosevich.bookstore.repository.datasource.BookDataSource;
import by.pvt.fedosevich.bookstore.repository.datasource.BookDataSourceImpl;

public class BookBase {

  public static void main(String[] args) {
    BookDataSource bookDataSource = new BookDataSourceImpl();
    BookRepository bookRepository = new BookRepositoryImpl(bookDataSource);
    BookAdapter bookAdapter = new BookAdapter(bookRepository, bookDataSource);
    bookAdapter.show();

  }
}

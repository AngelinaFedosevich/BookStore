package by.pvt.fedosevich.bookstore.service;

import by.pvt.fedosevich.bookstore.bean.Book;
import by.pvt.fedosevich.bookstore.service.exception.ServiceException;

public interface LibraryService {
  void addNewBook(Book book) throws ServiceException;
  void addEditedBook(Book book) throws ServiceException;

}

package by.pvt.fedosevich.bookstore.dao;

import by.pvt.fedosevich.bookstore.bean.Book;
import by.pvt.fedosevich.bookstore.dao.exception.DAOException;

public interface BookDAO {
  void addBook(Book book) throws DAOException;
  void deleteBook(long id) throws DAOException;
  void delete(Book book) throws DAOException;
}

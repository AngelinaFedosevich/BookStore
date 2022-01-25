package by.pvt.fedosevich.bookstore.dao;

import by.pvt.fedosevich.bookstore.bean.Customer;
import by.pvt.fedosevich.bookstore.dao.exception.DAOException;

public interface CustomerDAO {
  boolean signIn(String login, String password) throws DAOException;
  void registration (Customer customer) throws DAOException;


}

package by.pvt.fedosevich.bookstore.service;

import by.pvt.fedosevich.bookstore.bean.Customer;
import by.pvt.fedosevich.bookstore.dao.exception.DAOException;
import by.pvt.fedosevich.bookstore.service.exception.ServiceException;

public interface CustomerService {
  void signIn(String login, String password) throws DAOException, ServiceException;
  void signOut(String login) throws ServiceException;
  void registration(Customer customer) throws ServiceException;
}

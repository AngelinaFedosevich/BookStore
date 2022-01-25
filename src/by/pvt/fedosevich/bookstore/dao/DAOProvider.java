package by.pvt.fedosevich.bookstore.dao;

import by.pvt.fedosevich.bookstore.dao.impl.SQLBookDAO;
import by.pvt.fedosevich.bookstore.dao.impl.SQLCustomerDAO;

public final class DAOProvider {
  private static final DAOProvider instance = new DAOProvider();

  private CustomerDAO customerDAO = new SQLCustomerDAO();
  private BookDAO bookDAO = new SQLBookDAO();


  private DAOProvider(){}

  public static DAOProvider getInstance(){
    return instance;
  }

  public CustomerDAO getCustomerDAO() {
    return customerDAO;
  }

  public void setCustomerDAO(CustomerDAO customerDAO) {
    this.customerDAO = customerDAO;
  }

  public BookDAO getBookDAO() {
    return bookDAO;
  }

  public void setBookDAO(BookDAO bookDAO) {
    this.bookDAO = bookDAO;
  }

}

package by.pvt.fedosevich.bookstore.dao.factory;

import by.pvt.fedosevich.bookstore.dao.BookDAO;
import by.pvt.fedosevich.bookstore.dao.CustomerDAO;
import by.pvt.fedosevich.bookstore.dao.impl.SQLBookDAO;
import by.pvt.fedosevich.bookstore.dao.impl.SQLCustomerDAO;

public final class DAOFactory {
  private static final DAOFactory instance = new DAOFactory();

  private final BookDAO sqlBookImpl = new SQLBookDAO();
  private final CustomerDAO sqlCustomerImpl = new SQLCustomerDAO();

  private DAOFactory(){}

  public static DAOFactory getInstance(){
    return instance;
  }

  public BookDAO getBookDAO(){
    return sqlBookImpl;
  }

  public CustomerDAO getCustomerDAO(){
    return sqlCustomerImpl;
  }

}

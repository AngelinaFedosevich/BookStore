package by.pvt.fedosevich.bookstore.dao;

import by.pvt.fedosevich.bookstore.dao.impl.SQLBookDAO;
import by.pvt.fedosevich.bookstore.dao.impl.SQLCustomerDAO;

public class DAOFactory {
  private static final DAOFactory instance = new DAOFactory();
  private final BookDAO sqlBookImpl = new SQLBookDAO();
  private final CustomerDAO sqlCustomerIMPL = new SQLCustomerDAO();

  private DAOFactory(){}

  public static DAOFactory getInstance(){
    return instance;
  }
  public BookDAO getBookDAO(){
    return sqlBookImpl;
  }
  public CustomerDAO getCustomerDAO(){
    return sqlCustomerIMPL;
  }

// добавить книгу в базу
  DAOFactory daoObjectFactory = DAOFactory.getInstance();
  BookDAO bookDAO = daoObjectFactory.getBookDAO();
  //bookDAO.addBook(book);//TODO complite
}

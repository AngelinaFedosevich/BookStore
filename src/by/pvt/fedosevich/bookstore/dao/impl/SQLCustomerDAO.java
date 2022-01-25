package by.pvt.fedosevich.bookstore.dao.impl;

import by.pvt.fedosevich.bookstore.bean.Customer;
import by.pvt.fedosevich.bookstore.dao.CustomerDAO;
import by.pvt.fedosevich.bookstore.dao.exception.DAOException;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class SQLCustomerDAO implements CustomerDAO {


  @Override
  public boolean signIn(String login, String password) throws DAOException {
    try {
      FileReader reader = new FileReader("t.txt");
    } catch (FileNotFoundException e) {
      throw new DAOException(e);
    }
    return false;
  }

  @Override
  public void registration(Customer customer) throws DAOException {
    }
}

package by.pvt.fedosevich.bookstore.service.impl;

import by.pvt.fedosevich.bookstore.bean.Customer;
import by.pvt.fedosevich.bookstore.dao.exception.DAOException;
import by.pvt.fedosevich.bookstore.service.CustomerService;
import by.pvt.fedosevich.bookstore.service.exception.ServiceException;

public class CustomerServiceImpl implements CustomerService {

  @Override
  public void signIn(String login, String password) throws DAOException, ServiceException {

  }

  @Override
  public void signOut(String login) throws ServiceException {

  }

  @Override
  public void registration(Customer customer) throws ServiceException {

  }

//  @Override
//  public void signIn(String login, String password) throws ServiceException {
//    if (login == null || login.isEmpty()){
//      throw new ServiceException("Incorrect login");
//    }
//    try{
//      DAOFactory daoFactory = DAOFactory.getInstance();
//      //CustomerDAO customerDAO = daoObjectFactory.getCustomerDAO();
//      //customerDAO.signIn(login,password);
//    }//catch (DAOException e){
//      //throw new ServiceException(e);
//    }
//
////  }
//
//  @Override
//  public void signOut(String login) throws ServiceException {
//
//  }
//
//  @Override
//  public void registration(Customer customer) throws ServiceException {
//
  }


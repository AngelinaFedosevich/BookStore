package by.pvt.fedosevich.bookstore.controller.command.impl;

import by.pvt.fedosevich.bookstore.controller.command.Command;
import by.pvt.fedosevich.bookstore.dao.exception.DAOException;
import by.pvt.fedosevich.bookstore.service.CustomerService;
import by.pvt.fedosevich.bookstore.service.exception.ServiceException;
import by.pvt.fedosevich.bookstore.service.factory.ServiceFactory;

public class SignIn implements Command {

  @Override
  public String execute(String request) {
    String login = null;
    String password = null;
    String response = null;
    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    CustomerService customerService = serviceFactory.getCustomerService();
    try{
      customerService.signIn(login, password);
      response = "Welcome";
    }catch (ServiceException e){
      //TODO write log
      response = "Error during login procedure";
    } catch (DAOException e) {
      e.printStackTrace();
    }
    return response;
  }
}

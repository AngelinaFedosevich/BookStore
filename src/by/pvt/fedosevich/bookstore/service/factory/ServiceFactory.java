package by.pvt.fedosevich.bookstore.service.factory;

import by.pvt.fedosevich.bookstore.service.CustomerService;
import by.pvt.fedosevich.bookstore.service.LibraryService;
import by.pvt.fedosevich.bookstore.service.impl.CustomerServiceImpl;
import by.pvt.fedosevich.bookstore.service.impl.LibraryServiceImpl;

public final class ServiceFactory {
  private static final ServiceFactory instance = new ServiceFactory();

  private final CustomerService customerService = new CustomerServiceImpl();
  private final LibraryService libraryService = new LibraryServiceImpl();

  private ServiceFactory(){}

  public static ServiceFactory getInstance(){
    return instance;
  }

  public CustomerService getCustomerService(){
    return customerService;
  }

  public LibraryService getLibraryService(){
    return libraryService;
  }
}

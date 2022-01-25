package by.pvt.fedosevich.bookstore.service;

import by.pvt.fedosevich.bookstore.service.impl.CustomerServiceImpl;
import by.pvt.fedosevich.bookstore.service.impl.LibraryServiceImpl;

public final class ServiceProvider {
  private static final ServiceProvider instance = new ServiceProvider();
  private ServiceProvider(){}
  public static ServiceProvider getInstance(){
    return instance;
  }

  private final CustomerService customerService = new CustomerServiceImpl();
  private final LibraryService libraryService = new LibraryServiceImpl();

  public CustomerService getCustomerService() {
    return customerService;
  }

  public LibraryService getLibraryService() {
    return libraryService;
  }
}

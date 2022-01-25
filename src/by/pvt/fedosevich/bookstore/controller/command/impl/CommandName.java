package by.pvt.fedosevich.bookstore.controller.command.impl;

import by.pvt.fedosevich.bookstore.controller.command.Command;

public class CommandName implements Command {

  public static CommandName SIGN_IN;
  public static CommandName REGISTRATION;
  public static CommandName ADD_BOOK;
  public static CommandName WRONG_REQUEST;

  @Override
  public String execute(String request) {
    return null;
  }
}

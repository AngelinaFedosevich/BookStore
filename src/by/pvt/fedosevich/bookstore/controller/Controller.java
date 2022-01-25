package by.pvt.fedosevich.bookstore.controller;

import by.pvt.fedosevich.bookstore.controller.command.Command;

public class Controller {

  private final CommandProvider provider = new CommandProvider();
  private final char paramDelimeter = ' ';

  public String executeTask(String request) {
    String commandName;
    Command executionCommand;

    commandName = request.substring(0, request.indexOf(paramDelimeter));
    executionCommand = provider.getCommand(commandName);
    String response = null;
    response = executionCommand.execute(request);
    return response;
  }
}



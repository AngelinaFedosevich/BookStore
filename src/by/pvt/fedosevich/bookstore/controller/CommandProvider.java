package by.pvt.fedosevich.bookstore.controller;

import by.pvt.fedosevich.bookstore.controller.command.Command;
import by.pvt.fedosevich.bookstore.controller.command.impl.CommandName;
import by.pvt.fedosevich.bookstore.controller.command.impl.WrongRequest;
import by.pvt.fedosevich.bookstore.controller.command.impl.AddBook;
import by.pvt.fedosevich.bookstore.controller.command.impl.Register;
import by.pvt.fedosevich.bookstore.controller.command.impl.SignIn;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

final class CommandProvider {
  private final Map<CommandName, Command> repository = new HashMap<>();
  CommandProvider(){
    repository.put(CommandName.SIGN_IN, new SignIn());
    repository.put(CommandName.REGISTRATION, new Register());
    repository.put(CommandName.ADD_BOOK, new AddBook());
    repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
  }
  Command getCommand(String name){
    CommandName commandName = null;
    Command command = null;
    try{
     // commandName = CommandName.valueOf(name.toUpperCase());//TODO complete
      command = repository.get(commandName);
    }catch (IllegalArgumentException | NullPointerException e){
     // Logger.log(e);
      //TODO write log
      command = repository.get(CommandName.WRONG_REQUEST);
    }
    return command;
  }
}

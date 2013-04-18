package by.bsu.command.command;

import by.bsu.command.bean.ParametrWrapper;

public interface AbstractCommand {
   
  
    public abstract String execute(ParametrWrapper parametrWrapper);
}


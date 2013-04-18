package by.bsu.command.commandmap;

import java.util.HashMap;

import by.bsu.command.command.AbstractCommand;
import by.bsu.command.command.CancelLastOrder;
import by.bsu.command.command.FindProductCommand;
import by.bsu.command.command.MakeOrderCommand;
import by.bsu.command.command.NoCommand;
import by.bsu.command.command.RemoveOrderCommand;

public final class RequestHelper {

    private final static RequestHelper instance = new RequestHelper();
    private HashMap<String, AbstractCommand> commands = new HashMap<String, AbstractCommand>();

    private RequestHelper() {
        commands.put("makeOrder", new MakeOrderCommand());
        commands.put("findProduct", new FindProductCommand());
        commands.put("removeOrder", new RemoveOrderCommand());
        commands.put("cancelOrder", new CancelLastOrder());
       
    }

    public static RequestHelper getInstance() {
        return instance;
    }

    public AbstractCommand getCommand(String action) {
        AbstractCommand command = commands.get(action);
        if (command == null) {
            command = new NoCommand();
        }
        return command;
    }
}
package by.bsu.command.command;

import by.bsu.command.bean.Order;
import by.bsu.command.bean.ParametrWrapper;
import by.bsu.command.logic.MakeOrderLogic;

public class RemoveOrderCommand implements AbstractCommand{

	@Override
	public String execute(ParametrWrapper parametrWrapper) {
		MakeOrderLogic orderLogic=MakeOrderLogic.getInstance();
		Order order=parametrWrapper.getOrder();
		parametrWrapper.setRemoveOrder(true);
		parametrWrapper.saveToMemento();
		orderLogic.removeOrder(order);
		
		return null;
	}
}

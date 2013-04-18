package by.bsu.command.command;

import by.bsu.command.bean.Order;
import by.bsu.command.bean.ParametrWrapper;
import by.bsu.command.logic.MakeOrderLogic;

public final class MakeOrderCommand implements AbstractCommand{

	@Override
	public String execute(ParametrWrapper parametrWrapper) {
		MakeOrderLogic orderLogic=MakeOrderLogic.getInstance();
		Order order=parametrWrapper.getOrder();
		parametrWrapper.setRemoveOrder(false);
		parametrWrapper.saveToMemento();
		orderLogic.makeOrder(order);
		return null;
	}

}

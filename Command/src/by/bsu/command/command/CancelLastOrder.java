package by.bsu.command.command;

import by.bsu.command.bean.Order;
import by.bsu.command.bean.ParametrWrapper;
import by.bsu.command.logic.MakeOrderLogic;

public class CancelLastOrder implements AbstractCommand {

	@Override
	public String execute(ParametrWrapper parametrWrapper) {
		MakeOrderLogic orderLogic = MakeOrderLogic.getInstance();
		parametrWrapper.restoreFromMemento();
		System.out.println(parametrWrapper.isRemoveOrder());
		Order order=parametrWrapper.getOrder();
		if (parametrWrapper.isRemoveOrder()) {
			orderLogic.makeOrder(order);
			parametrWrapper.setRemoveOrder(false);
			
		} else{
			orderLogic.removeOrder(order);
			parametrWrapper.setRemoveOrder(true);
		}
		return null;
	}
}

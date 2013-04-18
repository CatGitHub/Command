package by.bsu.command.command;


import by.bsu.command.bean.Product;
import by.bsu.command.bean.ParametrWrapper;
import by.bsu.command.logic.MakeOrderLogic;


public class FindProductCommand implements AbstractCommand{

	@Override
	public String execute(ParametrWrapper parametrWrapper) {
		int code=parametrWrapper.getCodeOfProduct();
		MakeOrderLogic makeOrder=MakeOrderLogic.getInstance();
		Product p=makeOrder.findProduct(code);
		parametrWrapper.setProduct(p);
		return null;
	}
}

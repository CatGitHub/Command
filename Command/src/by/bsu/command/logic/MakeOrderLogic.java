package by.bsu.command.logic;

import by.bsu.command.bean.Order;
import by.bsu.command.bean.Product;

import by.bsu.command.database.MarketDAO;

public final class MakeOrderLogic {
	private MakeOrderLogic() {
	}

	private final static MakeOrderLogic instance = new MakeOrderLogic();

	public static MakeOrderLogic getInstance() {
		return instance;
	}

	public void makeOrder(Order order) {
		MarketDAO marketDAO = MarketDAO.getInstance();
		marketDAO.makeOrder(order);

	}
	
	public boolean removeOrder(Order order) {
		MarketDAO marketDAO = MarketDAO.getInstance();
		return marketDAO.removeOrder(order);

	}

	public Product findProduct(int code) {
		MarketDAO marketDAO = MarketDAO.getInstance();
		Product p = marketDAO.findProductById(code);

		return p;

	}

}

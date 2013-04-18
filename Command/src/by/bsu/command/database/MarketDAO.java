package by.bsu.command.database;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import by.bsu.command.bean.Order;
import by.bsu.command.bean.Product;

public class MarketDAO {
	private final static MarketDAO instance = new MarketDAO();
	private List<Order> orderStoring = new ArrayList<Order>();
	private List<Product> productStoring = new ArrayList<Product>();

	private MarketDAO() {
		Product p = new Product();
		p.setCode(1);
		p.setName("table");
		p.setPrice(22);
		productStoring.add(p);
		p = new Product();
		p.setCode(1);
		p.setName("chair");
		p.setPrice(123);
		productStoring.add(p);

	}

	public static MarketDAO getInstance() {
		return instance;
	}

	public void makeOrder(Order order) {
		orderStoring.add(order);
	}

	public Product findProductById(int id) {
		Iterator<Product> it = productStoring.iterator();
		Product p = null;
		int i = 0;
		while (it.hasNext() && (i == 0)) {
			p = it.next();
			if (p.getCode() == id) {
				i = 1;
			}
		}
		return p;
	}
	
	public boolean removeOrder(Order order) {
		return orderStoring.remove(order);
	}

}

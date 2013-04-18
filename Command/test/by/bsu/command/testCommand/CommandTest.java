package by.bsu.command.testCommand;

import static org.junit.Assert.*;
import org.junit.Test;
import by.bsu.command.bean.Order;
import by.bsu.command.bean.ParametrWrapper;

import by.bsu.command.command.AbstractCommand;
import by.bsu.command.commandmap.RequestHelper;

public class CommandTest {

	@Test
	public void findProduct() {

		RequestHelper requestHelper = RequestHelper.getInstance();
		AbstractCommand abstractCommand = requestHelper.getCommand("findProduct");
		ParametrWrapper parametrWrapper=ParametrWrapper.getInstance();
		parametrWrapper.setCodeOfProduct(1);
		abstractCommand.execute(parametrWrapper);
		System.out.println( parametrWrapper.getProduct().getName());
		assertEquals("table", parametrWrapper.getProduct().getName());

	}
	
	@Test
	public void makeOrderTest() {

		RequestHelper requestHelper = RequestHelper.getInstance();
		ParametrWrapper parametrWrapper=ParametrWrapper.getInstance();
		AbstractCommand abstractCommand = requestHelper.getCommand("makeOrder");
		Order order=new Order();
		order.setProduct(parametrWrapper.getProduct());
		order.setNumberOfProducts(3);
		parametrWrapper.setOrder(order);
		abstractCommand.execute(parametrWrapper);
		
		assertFalse(parametrWrapper.isRemoveOrder());

	}
	
	@Test
	public void removeOrderTest() {

		RequestHelper requestHelper = RequestHelper.getInstance();
		ParametrWrapper parametrWrapper=ParametrWrapper.getInstance();
		AbstractCommand abstractCommand = requestHelper.getCommand("removeOrder");
		
		abstractCommand.execute(parametrWrapper);
		
		assertTrue(parametrWrapper.isRemoveOrder());

	}
	
	@Test
	public void cancelOrderTest() {

		RequestHelper requestHelper = RequestHelper.getInstance();
		ParametrWrapper parametrWrapper=ParametrWrapper.getInstance();
		AbstractCommand abstractCommand = requestHelper.getCommand("cancelOrder");
		
		abstractCommand.execute(parametrWrapper);
		
		assertFalse(parametrWrapper.isRemoveOrder());

	}

}
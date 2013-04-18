package by.bsu.command.bean;

public class ParametrWrapper {

	private final static ParametrWrapper instance = new ParametrWrapper();

	private ParametrWrapper() {
	}

	public static ParametrWrapper getInstance() {
		return instance;
	}

	private Order order;
	private int codeOfProduct;
	private Product product;
	private boolean removeOrder;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public int getCodeOfProduct() {
		return codeOfProduct;
	}

	public void setCodeOfProduct(int codeOfProduct) {
		this.codeOfProduct = codeOfProduct;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public boolean isRemoveOrder() {
		return removeOrder;
	}

	public void setRemoveOrder(boolean removeOrder) {
		this.removeOrder = removeOrder;
	}

	public void saveToMemento() {

		undo = new Memento(order, removeOrder);
	}

	private Memento undo;

	public void restoreFromMemento() {
		order = undo.getSavedState();
		removeOrder = undo.isRemoving();

	}

	private class Memento {
		private final Order state;
		private final boolean removeOrder;

		public Memento(Order stateToSave, boolean removing) {
			state = stateToSave;
			removeOrder = removing;
		}

		public Order getSavedState() {
			return state;
		}

		public boolean isRemoving() {
			return removeOrder;
		}
	}

}

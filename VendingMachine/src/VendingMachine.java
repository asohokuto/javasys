
public class VendingMachine {
	private int total;

	public VendingMachine() {
		total = 0;
	}

	public void put(int i) {

		total += i;

	}

	public int getTotal() {
		return total;
	}

}

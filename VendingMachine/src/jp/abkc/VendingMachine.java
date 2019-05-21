package jp.abkc;
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

	public int getNotmoney() {
		return getNotmoney();
	}

	public int refund() {//使えないお金を投入されても加算しない
		return 0;
	}

}

package jp.abkc;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
	private int total;
	private List<Juice> Juices = new ArrayList<>();



	public VendingMachine() {
		total = 0;
		for(int i = 0;i < 5;i++) {
			Juices.add(new Juice("コーラ",120));
		}
	}
	public void put(int i) {
	    // 10円・50円・100円・500円・1000円だけ受け付ける
	    if (i == 10 ||
	        i == 50 ||
	        i == 100 ||
	        i == 500 ||
	        i == 1000) {
	        total += i;
	    }
	}

	public int getTotal() {
		return total;
	}

	public int getNotmoney() {
		return getNotmoney();
	}

	public int refund() {//使えないお金を投入されても加算しない
	    int refund = total;
	    total = 0;
	    return refund;
	}


	public int getJuicePrice() {//ジュースの値段
		return 120;
	}

	public int getJuiceStock() {//ジュースの在庫
		return Juices.size();
	}

	public String getJuiceName() {//ジュースの名称
		return "コーラ";
	}

	public boolean canbuy(String name) {//ジュースが買えるかどうか
		return total >= getJuicePrice();
	}

	public Juice buy(String name) {
		if(!canbuy(name))return null;
		Juice j = Juices.remove(0);
		total -= j.getPrice();
		return j;
	}
	public int getSales() {//売り上げ金額を返す
		return sales;
	}



}

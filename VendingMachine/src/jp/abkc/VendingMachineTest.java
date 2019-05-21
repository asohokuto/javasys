package jp.abkc;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

class VendingMachineTest {

	@Test
	void お金を投入する() {
		VendingMachine vm = new VendingMachine();
		vm.put(10);
		int total = vm.getTotal();
		assertThat(total,is(10));

		vm.put(50);
		total = vm.getTotal();
		assertThat(total,is(60));

		vm.put(100);
		total = vm.getTotal();
		assertThat(total,is(160));
	}
	@Test
	void 投入できないお金() {
	    VendingMachine vm = new VendingMachine();
	    vm.put(1);
	    int total = vm.getTotal();
	    assertThat(total, is(0));
	    vm.put(5);
	    total = vm.getTotal();
	    assertThat(total, is(0));
	    vm.put(20);
	    total = vm.getTotal();
	    assertThat(total, is(0));
	    vm.put(5000);
	    total = vm.getTotal();
	    assertThat(total, is(0));
	}
	@Test
    void 返金する() {
        VendingMachine vm = new VendingMachine();
        vm.put(1000);
        int total = vm.getTotal();
        assertThat(total, is(1000));
        int refund = vm.refund();
        total = vm.getTotal();
        assertThat(total, is(0));
        assertThat(refund, is(1000));
    }
	@Test
	void ジュースを格納できる() {
		VendingMachine vm = new VendingMachine();
		String name = vm.getJuiceName();
		assertThat(name,is("コーラ"));
		int price = vm.getJuicePrice();
		assertThat(price,is(120));
		int stock = vm.getJuiceStock();
		assertThat(stock,is(5));
	}
	@Test
	void ジュースの購入() {
		VendingMachine vm = new VendingMachine();
		boolean b = vm.canbuy("コーラ");
		assertThat(b,is(false));
		vm.put(500);;
		b = vm.canbuy("コーラ");
		assertThat(b,is(true));
		Juice juice = vm.buy("コーラ");
		assertThat(juice.getName(),is("コーラ"));
		int stock = vm.getJuiceStock();
		assertThat(stock,is(4));
		int total = vm.getTotal();
		assertThat(total,is(380));
	}
	@Test
	void 金額不足でジュースを購入できない() {
		VendingMachine vm = new VendingMachine();
		Juice j = vm.buy("コーラ");
		assertThat(j,is(nullValue()));
	}
	@Test
	void 在庫不足でジュースを購入できない() {
		VendingMachine vm = new VendingMachine();
		vm.put(1000);
		for(int i = 0; i < 5; i++) {
			Juice j = vm.buy("コーラ");
			assertThat(j.getName(),is("コーラ"));
		}
//		boolean b = vm.canbuy("コーラ");
//		assertThat(b,is(false));
		Juice j = vm.buy("コーラ");
		assertThat(j,is(nullValue()));
	}
	@Test
	void 現在の売り上げ金額を取得できる() {
		VendingMachine vm = new VendingMachine();
		 int sales = vm.getSales();
		 assertThat(sales,is(0));
		 vm.put(1000);
		 Juice j = vm.buy("コーラ");
		 sales = vm.getSales();
		 assertThat(sales,is(120));
	}

}

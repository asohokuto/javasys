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
}

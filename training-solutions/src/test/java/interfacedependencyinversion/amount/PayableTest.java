package interfacedependencyinversion.amount;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PayableTest {

    @Test
    void testAmount() {
        Payable payable = new Amount();

        assertEquals(15468, payable.getPayableAmount(15468));
    }

    @Test
    void testCash() {
        Payable payable = new Cash();

        assertEquals(15460, payable.getPayableAmount(15460));
        assertEquals(15460, payable.getPayableAmount(15462));
        assertEquals(15465, payable.getPayableAmount(15463));
        assertEquals(15465, payable.getPayableAmount(15467));
        assertEquals(15470, payable.getPayableAmount(15469));
    }

    @Test
    void testBankAtm() {
        Payable payable = new BankAtm();

        assertEquals(16000, payable.getPayableAmount(15468));
        assertEquals(16000, payable.getPayableAmount(16000));
    }
}
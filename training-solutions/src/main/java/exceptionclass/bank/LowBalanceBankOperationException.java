package exceptionclass.bank;

public class LowBalanceBankOperationException extends InvalidBankOperationException {

    public LowBalanceBankOperationException(String message) {
        super(message);
    }
}

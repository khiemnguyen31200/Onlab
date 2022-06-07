package vn.techmaster.bankingapplicantion.exception;

public class TransferException extends RuntimeException {
    public TransferException(String message){
        super(message);
    }
}

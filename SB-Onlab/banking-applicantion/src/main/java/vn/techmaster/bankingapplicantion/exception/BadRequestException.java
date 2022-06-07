package vn.techmaster.bankingapplicantion.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message){
        super(message);
    }
}

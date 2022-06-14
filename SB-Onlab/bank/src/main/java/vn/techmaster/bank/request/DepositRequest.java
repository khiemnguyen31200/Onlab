package vn.techmaster.bank.request;

    public record DepositRequest (String userID, String accountID, Long amount){

}

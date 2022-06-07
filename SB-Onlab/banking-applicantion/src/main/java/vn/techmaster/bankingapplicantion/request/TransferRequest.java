package vn.techmaster.bankingapplicantion.request;

public record TransferRequest(String idA, String idB, Long amount) {}

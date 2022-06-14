package vn.techmaster.bank.response;

import vn.techmaster.bank.model.TypeGiveInterest;

import java.util.UUID;

public record CloseSaver(String saverID, String userID, String accountID , TypeGiveInterest typeSave) {
}

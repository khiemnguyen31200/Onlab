package vn.techmaster.bank.request;

import vn.techmaster.bank.model.TypeGiveInterest;

import java.util.UUID;

public record CloseSaverRequest(String userID, String accountID, String saverID, TypeGiveInterest typeSave) {
}

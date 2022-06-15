package vn.techmaster.bank.response;

import vn.techmaster.bank.model.TypeGiveInterest;

import java.util.UUID;

public record OpenSaver(String saverID, String userID, String accountID , double interest, long amount, TypeGiveInterest typeSave, String displayDate) {
}

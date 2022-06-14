package vn.techmaster.bank.request;

import vn.techmaster.bank.model.MonthSaver;
import vn.techmaster.bank.model.TypeGiveInterest;

public record OpenSaverRequest(String userID, String accountID, String interestID, Long amount, TypeGiveInterest typeSave) {
}

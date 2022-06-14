package vn.techmaster.bank.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.techmaster.bank.request.DepositRequest;
import vn.techmaster.bank.response.AccountInfo;
import vn.techmaster.bank.service.BankService;

@RestController
@RequestMapping("/api")
public class CommandController {

    @Autowired private BankService bankService;
    @PostMapping("/deposit")
    @Operation(summary = "Deposit account")
    public ResponseEntity<AccountInfo> deposit(@RequestBody DepositRequest depositRequest){
        return ResponseEntity.ok(bankService.deposit(depositRequest));
    }

}

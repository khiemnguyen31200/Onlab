package vn.techmaster.bankingapplicantion.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import vn.techmaster.bankingapplicantion.model.Account;
import vn.techmaster.bankingapplicantion.repository.AccountRepo;
import vn.techmaster.bankingapplicantion.repository.UserRepo;
import vn.techmaster.bankingapplicantion.request.TransferRequest;
import vn.techmaster.bankingapplicantion.request.WithDrawDepositRequest;
import vn.techmaster.bankingapplicantion.service.AccountService;

import java.util.List;


@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired private AccountRepo accountRepo;
    @Autowired private UserRepo userRepo;
    @Autowired private AccountService accountService;

    @GetMapping(value = "/{id}")
    @Operation(summary = "Show name by account bank")
    public ResponseEntity<String> showAccountById(@PathVariable String id) {
        return ResponseEntity.ok(accountRepo.findById(id).get().getUser().getName());
    }

    @GetMapping(value = "/listaccount/{userid}")
    @Operation(summary = "List account by id")
    public ResponseEntity<List<Account>> accountByID(@PathVariable Long userid) {
        return ResponseEntity.ok(userRepo.findById(userid).get().getAccountList());
    }

    @PostMapping("/transfer")
    @Operation(summary = "Transfer money")
    public ResponseEntity<String> transfer (@RequestBody TransferRequest TransferRequest){
       return ResponseEntity.ok(accountService.Transfer(TransferRequest.idA(),TransferRequest.idB(),TransferRequest.amount()));
    }

    @PostMapping("/withdraw")
    @Operation(summary = "Withdraw money")
    public ResponseEntity<String> withDraw (@RequestBody WithDrawDepositRequest request){
        return ResponseEntity.ok(accountService.Withdraw(request.acc(),request.amount()));
    }
    @PostMapping("/deposit")
    @Operation(summary = "Deposit money")

    public ResponseEntity<String> deposit (@RequestBody WithDrawDepositRequest request){
        return ResponseEntity.ok(accountService.Deposit(request.acc(),request.amount()));
    }

}

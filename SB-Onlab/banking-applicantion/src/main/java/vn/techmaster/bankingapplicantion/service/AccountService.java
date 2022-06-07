package vn.techmaster.bankingapplicantion.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.bankingapplicantion.exception.NotFoundException;
import vn.techmaster.bankingapplicantion.exception.TransferException;
import vn.techmaster.bankingapplicantion.model.Account;

import vn.techmaster.bankingapplicantion.repository.AccountRepo;
import vn.techmaster.bankingapplicantion.repository.UserRepo;

import java.util.Optional;


@Service
public class AccountService {


    @Autowired private AccountRepo accountRepo;

    public String Transfer (String idA, String idB ,Long amount){
        Optional<Account> accA =accountRepo.findById(idA);
        Optional<Account> accB =accountRepo.findById(idB);
        if(accA.isEmpty()){
            throw new NotFoundException("Not found Sender");
        }
        if(accB.isEmpty()){
            throw new NotFoundException("Not found Receiver");
        }

        if(accA.get().getBalance() > amount-50000L){
            accB.get().setBalance(accB.get().getBalance()+amount);
            accA.get().setBalance(accA.get().getBalance()-amount);
            accountRepo.save(accB.get());
            accountRepo.save(accA.get());
        }else {
            throw new TransferException("Not enough balance");
        }

        return accA.get().getUser().getName() +" da chuyen khoan den " +accB.get().getUser().getName() + " " + amount;
    }

    public String Withdraw ( String idA ,Long amount){
        Optional<Account> accA =accountRepo.findById(idA);
        if(accA.isEmpty()){
            throw new NotFoundException("Not found Account");
        }
        if(accA.get().getBalance() > amount-50000L){
            accA.get().setBalance(accA.get().getBalance()-amount);
            accountRepo.save(accA.get());
        }else {
            throw new TransferException("Not enough balance");
        }
        return "Successfully withdraw " + amount;
    }

    public String Deposit(String idA ,Long amount){
        Optional<Account> accA =accountRepo.findById(idA);
        if(accA.isEmpty()){
            throw new NotFoundException("Not found Account");
        }
            accA.get().setBalance(accA.get().getBalance()+amount);
            accountRepo.save(accA.get());
        return "Successfully Deposit " + amount;
    }
}

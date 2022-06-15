package vn.techmaster.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.bank.exception.CommandException;
import vn.techmaster.bank.exception.RecordNotFoundException;
import vn.techmaster.bank.model.*;
import vn.techmaster.bank.repository.AccountRepo;
import vn.techmaster.bank.repository.CommandRepo;
import vn.techmaster.bank.repository.UserRepo;
import vn.techmaster.bank.request.DepositRequest;
import vn.techmaster.bank.response.AccountInfo;

@Service
public class BankService {
    @Autowired private UserRepo userRepo;
    @Autowired private AccountRepo accountRepo;

    @Autowired private CommandRepo commandRepo;


    public AccountInfo deposit(DepositRequest depositRequest){
        User user = userRepo.findById(depositRequest.userID()).orElseThrow(() ->  new RecordNotFoundException("user", depositRequest.userID()));
        Account account = accountRepo.findById(depositRequest.accountID()).orElseThrow(() ->  new RecordNotFoundException("user", depositRequest.accountID()));

       if(!account.getUser().getId().equals(depositRequest.userID())){
           throw  new CommandException("Requester is not ownew of account");
       }
       account.setBalance(account.getBalance()+depositRequest.amount());
        Deposit deposit = new Deposit(user,account,depositRequest.amount());
       try{
           accountRepo.save(account);
           deposit.setStatus(CommandStatus.SUCCESS);
           commandRepo.save(deposit);
       }catch (Exception e){
           deposit.setStatus(CommandStatus.FAILED);
           commandRepo.save(deposit);
           var commandException  =  new CommandException("Deposit error");
           commandException.initCause(e);
           throw commandException;
       }
       return new AccountInfo(account.getId(),account.getBank().getName(), account.getBalance());
    }
  
}

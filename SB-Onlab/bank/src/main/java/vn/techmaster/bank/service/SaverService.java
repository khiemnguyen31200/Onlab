package vn.techmaster.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.bank.exception.CommandException;
import vn.techmaster.bank.exception.RecordNotFoundException;
import vn.techmaster.bank.model.*;
import vn.techmaster.bank.repository.*;
import vn.techmaster.bank.request.CloseSaverRequest;
import vn.techmaster.bank.request.OpenSaverRequest;
import vn.techmaster.bank.response.OpenSaver;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
public class SaverService {

    @Autowired private UserRepo userRepo;

    @Autowired private AccountRepo accountRepo;

    @Autowired private AccountSaverRepo saverAccount;

    @Autowired private InterestRepo interestRepo;

    public OpenSaver deposit(OpenSaverRequest saverRequest) {
        String displayDate ;
        User user = userRepo.findById(saverRequest.userID())
                .orElseThrow(() -> new RecordNotFoundException("users", saverRequest.userID()));

        Account account = accountRepo.findById(saverRequest.accountID())
                .orElseThrow(() -> new RecordNotFoundException("account", saverRequest.accountID()));

        Interest interest = interestRepo.findById(saverRequest.interestID())
                .orElseThrow(() -> new RecordNotFoundException("interest", saverRequest.interestID()));
        if(saverRequest.amount() > account.getBalance()){
            throw new CommandException("Not Enough Balance");
        }
        account.setBalance(account.getBalance()-saverRequest.amount());
        var newSaver = SaverAcc.builder()
                .startBalance(saverRequest.amount())
                .id(UUID.randomUUID().toString()).startAt(LocalDate.now())
                .interest(interest).typeGiveInterest(saverRequest.typeSave())
                .build();
        if(interest.getMonths().label==0L){
            newSaver.setFinishAt(null);
            displayDate = "Kh??ng c?? k?? h???n";
        }else {
            newSaver.setFinishAt(newSaver.getStartAt().plusMonths(interest.getMonths().label));
            displayDate = newSaver.getFinishAt().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
        saverAccount.save(newSaver);
        return new OpenSaver(newSaver.getId(), saverRequest.userID(), saverRequest.accountID(), interest.getInterest(), saverRequest.amount(), saverRequest.typeSave(),displayDate);
    }


    public String close(CloseSaverRequest saverRequest) {

        User user = userRepo.findById(saverRequest.userID())
                .orElseThrow(() -> new RecordNotFoundException("users", saverRequest.userID()));

        Account account = accountRepo.findById(saverRequest.accountID())
                .orElseThrow(() -> new RecordNotFoundException("account", saverRequest.accountID()));

        SaverAcc saver = saverAccount.findById(saverRequest.saverID())
                .orElseThrow(() -> new RecordNotFoundException("saver", saverRequest.saverID()));

        saver.setCloseAt(LocalDate.now());

        long interestMoney = 0L;
        String message = "";
        //L??i su???t kh??ng th???i h???n
            if(saver.getInterest().getMonths().label == 0){
                //T??nh th???i gian g???i
                int countOfMonth = Period.between(saver.getStartAt(), saver.getCloseAt()).getMonths();

                if (saver.getTypeGiveInterest().equals(TypeGiveInterest.PER_MONTH)) {
                    interestMoney = (long) (saver.getStartBalance() * saver.getInterest().getInterest()* countOfMonth / 12 * 0.8);
                }else{
                    interestMoney = (long) (saver.getStartBalance() * saver.getInterest().getInterest()* countOfMonth / 12 );
                }
                message = "S??? th??ng b???n ???? g???i l?? : "+countOfMonth+" S??? d?? c???a b???n l???n l?????t l?? TKTK,TKTT  ";

            }else {
                //L??i su???t c?? th???i han
                if (saver.getCloseAt().compareTo(saver.getStartAt()) <= 3) {
                    interestMoney = (long) (saver.getStartBalance()*0.95);
                    message = "T??i kho???n b??? ph???t do ????ng qu?? s???m. S??? d?? c???a b???n l???n l?????t l?? TKTK,TKTT  :";
                } else if (saver.getFinishAt().compareTo(LocalDate.now()) != 0) {
                    message = "T??i kho???n kh??ng c?? l??i ????ng s???m. S??? d?? c???a b???n l???n l?????t l?? TKTK,TKTT  ";
                } else {
                    if (saver.getTypeGiveInterest().equals(TypeGiveInterest.PER_MONTH)) {
                        interestMoney = (long) (saver.getStartBalance() * saver.getInterest().getInterest()* saver.getInterest().getMonths().label / 12 * 0.8);
                    }else{
                        interestMoney = (long) (saver.getStartBalance() * saver.getInterest().getInterest()* saver.getInterest().getMonths().label / 12 );
                    }
                    message = "S??? d?? c???a b???n l???n l?????t l?? TKTK,TKTT  ";
                }
            }
            saver.setEndBalance(saver.getStartBalance() + interestMoney);
            long accountMoney = account.getBalance() + saver.getEndBalance();
            account.setBalance(accountMoney);
            String fullMessage = message + saver.getEndBalance() +" , "+ accountMoney;
            try {
                accountRepo.save(account);
                saverAccount.delete(saver);
            }catch (Exception e){
                throw new RuntimeException(e);
            }
            return fullMessage;
    }
}

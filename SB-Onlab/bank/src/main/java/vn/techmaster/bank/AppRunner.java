package vn.techmaster.bank;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import vn.techmaster.bank.exception.RecordNotFoundException;
import vn.techmaster.bank.model.*;
import vn.techmaster.bank.repository.*;


@Component
@Transactional
@AllArgsConstructor
public class AppRunner implements ApplicationRunner{

  private UserRepo userRepo;
  private AccountRepo accountRepo;
  private BankRepo bankRepo;



  private InterestRepo interestRepo;
  private void generateAccount() {
    Bank vcb = bankRepo.findById("vcb")
            .orElseThrow(() -> new RecordNotFoundException("bank", "vcb"));

    Bank acb = bankRepo.findById("acb")
            .orElseThrow(() -> new RecordNotFoundException("bank", "acb"));

    Bank vp = bankRepo.findById("vp")
            .orElseThrow(() -> new RecordNotFoundException("bank", "vp"));

    User bob = userRepo.findById("0001")
            .orElseThrow(() -> new RecordNotFoundException("users", "0001"));

    User alice = userRepo.findById("0002")
            .orElseThrow(() -> new RecordNotFoundException("users", "0002"));

    User tom = userRepo.findById("0003")
            .orElseThrow(() -> new RecordNotFoundException("users", "0003"));

    Account bob_vcb_1 = new Account("00012", vcb, bob, 1000L);
    accountRepo.save(bob_vcb_1);

    Account bob_vcb_2 = new Account("00013", vcb, bob, 0L);
    accountRepo.save(bob_vcb_2);

    Account alice_acb = new Account("78912", acb, alice, 500L);
    accountRepo.save(alice_acb);

    Account tom_acb = new Account("8901233", acb, tom, 50000000L);
    Account tom_vcb = new Account("1212155", vcb, tom, 200L);
    accountRepo.save(tom_acb);
    accountRepo.save(tom_vcb);

    Interest inter1 = Interest.builder().id("30722").interest(0.03).months(MonthSaver.ONE).build();
    Interest inter3 = Interest.builder().id("30723").interest(0.04).months(MonthSaver.THREE).build();
    Interest inter6 = Interest.builder().id("30724").interest(0.05).months(MonthSaver.SIX).build();
    Interest inter9 = Interest.builder().id("30725").interest(0.06).months(MonthSaver.NINE).build();
    Interest inter12 = Interest.builder().id("30725").interest(0.07).months(MonthSaver.TWELVE).build();
    Interest interno = Interest.builder().id("30726").interest(0.01).months(MonthSaver.UNLIMITED).build();


    interestRepo.save(inter1);
    interestRepo.save(inter3);
    interestRepo.save(inter6);
    interestRepo.save(inter9);
    interestRepo.save(inter12);
    interestRepo.save(interno);
  }
  @Override
  public void run(ApplicationArguments args) throws Exception {
    generateAccount();
  }
}

package vn.techmaster.bankingapplicantion;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import vn.techmaster.bankingapplicantion.model.Account;
import vn.techmaster.bankingapplicantion.repository.AccountRepo;
import vn.techmaster.bankingapplicantion.repository.UserRepo;
import vn.techmaster.bankingapplicantion.service.AccountService;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AllArgsConstructor
public class AccountTest {

      AccountService accountService;
      AccountRepo accountRepo;
      UserRepo userRepo;

    @Test
    void showAccountById(){
        String user = accountRepo.findById("012345").get().getUser().getName();
        assertThat(user).isEqualTo("Bob");
    }

    @Test
    void accountByID(){
        List<Account> accountList = userRepo.findById(1L).get().getAccountList();
        assertThat(accountList.size()).isGreaterThan(3);
    }


}

package vn.techmaster.bankingapplicantion;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vn.techmaster.bankingapplicantion.model.Account;
import vn.techmaster.bankingapplicantion.model.User;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@SpringBootApplication
@AllArgsConstructor
public class BankingApplicantionApplication implements CommandLineRunner {
    private EntityManager entityManager;

    public static void main(String[] args) {
        SpringApplication.run(BankingApplicantionApplication.class, args);
    }


    @Override
    @Transactional
    public void run(String... args) throws Exception {
          var user1 = User.builder().name("Bob").build();
          var user2 = User.builder().name("Alice").build();
          var user3 = User.builder().name("Tom").build();
          var user4 = User.builder().name("Sara").build();

          var acc1 = Account.builder().id("012345").user(user1).balance(100000000L).build();
        var acc2 = Account.builder().id("012346").user(user1).balance(100000000L).build();
        var acc3 = Account.builder().id("012347").user(user1).balance(100000000L).build();
        var acc4 = Account.builder().id("012348").user(user1).balance(100000000L).build();

        var acc5 = Account.builder().id("012357").user(user2).balance(100000000L).build();
        var acc6 = Account.builder().id("012358").user(user2).balance(100000000L).build();
        var acc7 = Account.builder().id("012359").user(user2).balance(100000000L).build();
        var acc8 = Account.builder().id("012360").user(user2).balance(100000000L).build();

        var acc9 = Account.builder().id("012361").user(user3).balance(500000000L).build();
        var acc10 = Account.builder().id("012362").user(user3).balance(500000000L).build();
        var acc11 = Account.builder().id("012363").user(user3).balance(500000000L).build();
        var acc12 = Account.builder().id("012352").user(user3).balance(500000000L).build();

        var acc13 = Account.builder().id("012353").user(user4).balance(1000000000L).build();
        var acc14 = Account.builder().id("012354").user(user4).balance(1000000000L).build();
        var acc15 = Account.builder().id("012355").user(user4).balance(1000000000L).build();
        var acc16 = Account.builder().id("012356").user(user4).balance(1000000000L).build();


        entityManager.persist(user1);
        entityManager.persist(user2);
        entityManager.persist(user3);
        entityManager.persist(user4);

        entityManager.persist(acc1);
        entityManager.persist(acc2);
        entityManager.persist(acc3);
        entityManager.persist(acc4);
        entityManager.persist(acc5);
        entityManager.persist(acc6);
        entityManager.persist(acc7);
        entityManager.persist(acc8);
        entityManager.persist(acc9);
        entityManager.persist(acc10);
        entityManager.persist(acc11);
        entityManager.persist(acc12);
        entityManager.persist(acc13);
        entityManager.persist(acc14);
        entityManager.persist(acc15);
        entityManager.persist(acc16);




        entityManager.flush();
    }
}

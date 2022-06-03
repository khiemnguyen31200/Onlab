package vn.techmaster;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vn.techmaster.model.Employer;
import vn.techmaster.model.Job;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import javax.transaction.Transactional;

@SpringBootApplication
public class HijpaApplication implements CommandLineRunner {
    @Autowired private EntityManager em;
    public static void main(String[] args) {
        SpringApplication.run(HijpaApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Faker faker = new Faker();
//        for (int i = 0; i < 100; i++) {
//            var employer = Employer.builder().name(faker.company().name())
//                    .email(faker.internet().emailAddress())
//                    .website("https://" + faker.internet().domainName()).build();
//            em.persist(employer);
//        }
//        em.flush();
        for (int i = 0; i < 100; i++) {
            var employer = Job.builder().title(faker.company().name())
                    .description(faker.lordOfTheRings().character()).build();
            em.persist(employer);
        }
        em.flush();
    }
}

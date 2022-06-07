package vn.techmaster.bankingapplicantion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.bankingapplicantion.model.Account;

public interface AccountRepo extends JpaRepository<Account, String> {
}

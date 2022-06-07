package vn.techmaster.bankingapplicantion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.bankingapplicantion.model.User;

public interface UserRepo extends JpaRepository<User,Long> {
}

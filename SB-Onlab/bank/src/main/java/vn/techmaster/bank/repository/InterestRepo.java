package vn.techmaster.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.bank.model.Interest;

public interface InterestRepo extends JpaRepository<Interest,String> {
}

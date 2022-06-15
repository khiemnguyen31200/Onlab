package vn.techmaster.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.techmaster.bank.model.SaverAcc;

import java.util.UUID;


@Repository
public interface AccountSaverRepo extends JpaRepository<SaverAcc,String> {
}

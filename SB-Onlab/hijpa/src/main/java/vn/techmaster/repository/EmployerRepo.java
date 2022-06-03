package vn.techmaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.techmaster.model.Employer;

import java.util.List;

@Repository
public interface EmployerRepo extends JpaRepository<Employer, Long> {

}

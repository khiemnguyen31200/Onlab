package vn.techmaster.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.bank.model.Command;

import java.util.UUID;

public interface CommandRepo extends JpaRepository<Command, UUID> {
}

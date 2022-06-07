package vn.techmaster.bankingapplicantion.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.techmaster.bankingapplicantion.model.User;
import vn.techmaster.bankingapplicantion.repository.UserRepo;



@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired private UserRepo userRepo;

    @GetMapping(value = "/{id}")
    @Operation(summary = "Find User By ID")
    public ResponseEntity<User> showUserByID(@PathVariable Long id) {
        return ResponseEntity.ok(userRepo.findById(id).get());
    }



}

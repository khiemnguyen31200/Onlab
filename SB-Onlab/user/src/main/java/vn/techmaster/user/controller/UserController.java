package vn.techmaster.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.techmaster.user.dto.UserDto;
import vn.techmaster.user.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/users")
    public ResponseEntity<?>getUsers(){
        List<UserDto> userDtos = userService.getUsers();
        return ResponseEntity.ok(userDtos);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id){
        UserDto userDto = userService.getUsersByID(id);
        return ResponseEntity.ok(userDto);
    }


}

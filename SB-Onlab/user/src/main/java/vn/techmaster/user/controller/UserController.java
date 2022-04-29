package vn.techmaster.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techmaster.user.dto.UserDto;
import vn.techmaster.user.request.UserRequest;
import vn.techmaster.user.request.UserRequestUpdate;
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

    @GetMapping("/users/search")
    public ResponseEntity<?>searchUsers(@RequestParam String name){
        List<UserDto> userDtos = userService.searchUser(name);
        return ResponseEntity.ok(userDtos);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id){
        UserDto userDto = userService.getUsersByID(id);
        return ResponseEntity.ok(userDto);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id){
         userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody UserRequest request){
        UserDto userDto = userService.createUser(request);
        return ResponseEntity.ok(userDto);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id , @RequestBody UserRequestUpdate request){
        UserDto userDto = userService.updateUser(id,request);
        return ResponseEntity.ok(userDto);
    }



}

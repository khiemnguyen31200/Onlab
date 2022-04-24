package vn.techmaster.user.service;

import org.springframework.stereotype.Service;
import vn.techmaster.user.dto.UserDto;
import vn.techmaster.user.exception.NotFoundException;
import vn.techmaster.user.mapper.UserMapper;
import vn.techmaster.user.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private List<User> users = new ArrayList<>();

    public UserService(){
        users.add(new User(1,"Khiêm","khiem@gmail.com","","Hà Nội",null,""));
        users.add(new User(2,"Khiêmng","khiem123@gmail.com","","Nam Định",null,""));
    }

    public List<UserDto> getUsers() {
        return users
                .stream()
                .map(user -> UserMapper.toUserDto(user))
                .collect(Collectors.toList());
    }

    public UserDto getUsersByID(int id) {
        Optional<User> userOptional = findById(id);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            return UserMapper.toUserDto(user);
        }
          throw  new NotFoundException("User with id " + id + " not found");
    }
    public Optional<User> findById(int id){
        return users.stream().filter(user -> user.getId()==id).findFirst();
    }
    public Optional<User> findByEmail(String email){
        return users.stream().filter(user -> user.getEmail().equals(email)).findFirst();
    }
    public void deleteUser(int id){
        Optional<User> userOptional = findById(id);
        if(userOptional.isEmpty()){
            throw new NotFoundException("user id " +id +" not found");
        }

        users.removeIf(user -> user.getId()==id);
    }
}

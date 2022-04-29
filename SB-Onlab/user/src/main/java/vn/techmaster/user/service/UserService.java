package vn.techmaster.user.service;

import org.springframework.stereotype.Service;
import vn.techmaster.user.dto.UserDto;
import vn.techmaster.user.exception.BadRequestException;
import vn.techmaster.user.exception.NotFoundException;
import vn.techmaster.user.mapper.UserMapper;
import vn.techmaster.user.model.User;
import vn.techmaster.user.request.UserRequest;
import vn.techmaster.user.request.UserRequestUpdate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {

    private List<User> users = new ArrayList<>();

    public UserService(){
        users.add(new User(1,"Khiêm","khiem@gmail.com","0936439200","Thành phố Hà Nội",null,"abcxyz"));
        users.add(new User(2,"Khiêmng","khiem123@gmail.com","0936439200","Tỉnh Nam Định",null,"abc123"));
    }

    public List<UserDto> getUsers() {
        return users
                .stream()
                .map(user -> UserMapper.toUserDto(user))
                .collect(Collectors.toList());
    }

    public List<UserDto> searchUser(String name) {
        return users
                .stream()
                .filter(user -> user.getName().toLowerCase().contains(name.toLowerCase()))
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

    public UserDto createUser(UserRequest request) {

        if(findByEmail(request.getEmail()).isPresent()){
            throw  new BadRequestException("email : " + request.getEmail()+" is existed");
        }
        Random rd = new Random();
        User user = new User();
        user.setId(rd.nextInt(100));
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setAddress(request.getAddress());
        user.setPassword(request.getPassword());

        users.add(user);

        return UserMapper.toUserDto(user);
    }

    public UserDto updateUser(int id, UserRequestUpdate request) {
        Optional<User> userOptional = findById(id);
        if(userOptional.isEmpty()){
            throw new NotFoundException("user id " +id +" not found");
        }

        User user = userOptional.get();
        user.setName(request.getName());
        user.setPhone(request.getPhone());
        user.setAddress(request.getAddress());

        return UserMapper.toUserDto(user);
    }
}

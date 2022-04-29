package vn.techmaster.demosession.repository;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;


import org.springframework.stereotype.Repository;

import vn.techmaster.demosession.model.State;
import vn.techmaster.demosession.model.User;


@Repository
public class UserRepository {
    private ConcurrentHashMap<String, User> users = new ConcurrentHashMap<>();

    public User addUser(String fullName, String email, String haskPassword, State state) {
        String id = UUID.randomUUID().toString();
        User user = User.builder().id(id).fullName(fullName).email(email).haskPassWord(haskPassword).state(state)
                .build();
        users.put(id, user);
        return user;
    }

    public boolean isEmailExist(String email) {
        return users.values().stream().filter(user -> user.getEmail().equalsIgnoreCase(email)).count() > 0;
    }

    public User addUser(String fullName, String email, String haskpass) {
        return addUser(fullName, email, haskpass, State.PENDING);
    }

    public Optional<User> findByEmail(String Email) {
        return users.values().stream().filter(user -> user.getEmail().equalsIgnoreCase(Email)).findFirst();
    }

    public void update(User user){
        users.put(user.getId(),user);
    }

}

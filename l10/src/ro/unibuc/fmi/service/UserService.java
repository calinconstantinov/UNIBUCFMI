package ro.unibuc.fmi.service;

import ro.unibuc.fmi.model.User;
import ro.unibuc.fmi.repository.UserRepository;

import java.util.Date;

public class UserService {

    private static UserService instance;

    private final UserRepository userRepository = UserRepository.getInstance();

    private UserService() {
    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }

        return instance;
    }

    public User saveUser(String email, String name, Date registeredDateTime) {
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setRegisteredDateTime(registeredDateTime);

        return userRepository.saveUser(user);
    }

    public User findUser(String email) {
        return userRepository.findUser(email);
    }

    public User updateUser(User user) {
        return userRepository.updateUser(user);
    }

    public boolean deleteUser(User user) {
        return userRepository.deleteUser(user.getEmail());
    }

    public User findNewestMember() {
        return userRepository.findNewestMember();
    }
}

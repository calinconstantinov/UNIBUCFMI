package ro.unibuc.fmi;

import ro.unibuc.fmi.model.User;
import ro.unibuc.fmi.service.UserService;

import java.util.Date;

public class DatabaseExample {

    private static final UserService userService = UserService.getInstance();

    public static void main(String[] args) throws InterruptedException {
        User userToSave = userService.saveUser("test@domain.com", "Calin", new Date());
        System.out.println(userToSave);

        User userToFind = userService.findUser("test@domain.com");
        System.out.println(userToFind);

        User userToUpdate = new User("test@domain.com", "Constantinov", new Date());
        userToUpdate = userService.updateUser(userToUpdate);
        System.out.println(userToUpdate);

        User userToDelete = new User("test@domain.com", null, null);
        boolean result = userService.deleteUser(userToDelete);
        System.out.println(result);

        userService.saveUser("testA@domain.com", "A", new Date());
        Thread.sleep(1000);
        userService.saveUser("testB@domain.com", "B", new Date());
        Thread.sleep(2000);
        userService.saveUser("testC@domain.com", "C", new Date());

        User newestMember = userService.findNewestMember();
        System.out.println(newestMember);
    }
}

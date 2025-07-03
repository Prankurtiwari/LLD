package problems.splitwise.controller;

import problems.splitwise.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserController {

    private static UserController userController;
    private final List<User> list;

    private UserController() {
        this.list = new ArrayList<>();
    }

    public static UserController getInstance() {
        if(userController == null) {
            synchronized (UserController.class) {
                if (userController == null) {
                    userController = new UserController();
                }
            }
        }
        return userController;
    }


    public void addUser(User user) {
        list.add(user);
    }

    public User getUser(String id) {
        for (User user : list) {
            if(user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public List<User> getUserList() {
        return list;
    }
}

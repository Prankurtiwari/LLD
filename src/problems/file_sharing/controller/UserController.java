package problems.file_sharing.controller;

import problems.file_sharing.model.User;
import problems.file_sharing.repository.UserRepository;

public class UserController {
    private static volatile UserController instance;
    private final UserRepository userRepository = UserRepository.getInstance();

    private UserController() {}

    public static UserController getInstance() {
        if (instance == null) {
            synchronized (UserController.class) {
                if (instance == null) {
                    instance = new UserController();
                }
            }
        }
        return instance;
    }

    public void followUser(User follower, User followee) {
        follower.addFollowing(followee);
        followee.addFollower(follower);
    }
}

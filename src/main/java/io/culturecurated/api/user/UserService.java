package io.culturecurated.api.user;

import io.culturecurated.api.userlists.UserLists;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository USER_REPOSITORY;

    public UserService(UserRepository user_repository) {
        this.USER_REPOSITORY = user_repository;
    }

    public User getUserById(UUID id) {
        return USER_REPOSITORY.findById(id).orElse(null);
    }

    public User getUserByUsername(String username) {
        return USER_REPOSITORY.findByUsername(username);
    }

    public User getUserByEmail(String email) {
        return USER_REPOSITORY.findByEmail(email);
    }

    public User createUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setProfilePicture(userDTO.getProfilePicture());
        user.setBiography(userDTO.getBiography());
        return USER_REPOSITORY.save(user);
    }

    public String deleteUser(UUID id) {
        if (USER_REPOSITORY.existsById(id)) {
            USER_REPOSITORY.deleteById(id);
            return "User Successfully Deleted";
        } else {
            return "User Id not found";
        }
    }

    public List<UserLists> getUserListsByUserId(UUID userId) {
        return USER_REPOSITORY.findUserListsById(userId);
    }
}

package io.culturecurated.api.user;

import io.culturecurated.api.userlists.UserLists;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository user_repository) {
        this.userRepository = user_repository;
    }

    public User getUserById(UUID id) {
        return userRepository.findById(id).orElse(null);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User createUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setProfilePicture(userDTO.getProfilePicture());
        user.setBiography(userDTO.getBiography());
        return userRepository.save(user);
    }

    public String deleteUser(UUID id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return "User Successfully Deleted";
        } else {
            return "User Id not found";
        }
    }

    public List<UserLists> getUserListsByUserId(UUID userId) {
        return userRepository.findUserListsById(userId);
    }
}

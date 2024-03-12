package io.culturecurated.api.user;

import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserRepository USER_REPOSITORY;


    public UserController(UserRepository user_repository) {
        this.USER_REPOSITORY = user_repository;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable UUID id){
        return USER_REPOSITORY.findById(id).get();
    }

    @GetMapping("/user/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return USER_REPOSITORY.findByUsername(username);
    }

    @GetMapping("/email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return USER_REPOSITORY.findByEmail(email);
    }

    @PostMapping
    public User createUser(@RequestBody UserDTO userDTO){
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setProfilePicture(userDTO.getProfilePicture());
        user.setBiography(userDTO.getBiography());
        return USER_REPOSITORY.save(user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable UUID id){
        try{
            USER_REPOSITORY.findById(id).get();
            USER_REPOSITORY.deleteById(id);
            return "User Successfully Deleted";
        } catch (Exception e ){
            return "User Id not found";
        }
    }
}

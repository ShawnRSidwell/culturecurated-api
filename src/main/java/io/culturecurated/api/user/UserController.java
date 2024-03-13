package io.culturecurated.api.user;

import io.culturecurated.api.userlists.UserLists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable UUID id){
        return userService.getUserById(id);
    }

    @GetMapping("/user/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @GetMapping("/email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @GetMapping("/{userId}/lists")
    public List<UserLists> getUserListsByUserId(@PathVariable UUID userId){
        return userService.getUserListsByUserId(userId);
    }

    @PostMapping
    public User createUser(@RequestBody UserDTO userDTO){
        return userService.createUser(userDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable UUID id){
        return userService.deleteUser(id);
    }


}

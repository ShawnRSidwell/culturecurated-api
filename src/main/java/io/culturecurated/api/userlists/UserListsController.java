package io.culturecurated.api.userlists;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/lists")
public class UserListsController {
    Logger logger = LoggerFactory.getLogger(UserListsController.class);

    private final UserListsService userService;

    public UserListsController(UserListsService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public List<UserLists> getUserListsByUserId(@PathVariable UUID userId){
        return userService.getUserListsByUserId(userId);
    }
}

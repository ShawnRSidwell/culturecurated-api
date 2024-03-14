package io.culturecurated.api.userlists;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/category/{category}")
    public List<UserLists> getUserListsByCategory(@PathVariable ItemCategory category,  @RequestParam(defaultValue = "1") int page){
        return userService.getListsByCategory(category, page -1);
    }
    @GetMapping()
    public List<UserLists> getListsByTitle(@RequestParam String title,  @RequestParam(defaultValue = "1") int page){
        return userService.getListsByTitle(title, page -1);
    }
}

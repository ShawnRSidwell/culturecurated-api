package io.culturecurated.api.userlists;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserListsService {
    private final UserListsRepository USER_LIST_REPOSITORY;


    public UserListsService(UserListsRepository userListsRepository) {
        this.USER_LIST_REPOSITORY = userListsRepository;
    }

    public List<UserLists> getUserListsByUserId(UUID userId) {
        return USER_LIST_REPOSITORY.findByUserId(userId);
    }
}

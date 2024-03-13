package io.culturecurated.api.userlists;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

@Service
public class UserListsService {
    private final UserListsRepository userListsRepository;


    public UserListsService(UserListsRepository userListsRepository) {
        this.userListsRepository = userListsRepository;
    }

    public List<UserLists> getUserListsByUserId(UUID userId) {
        return userListsRepository.findByUserId(userId);
    }

    public List<UserLists> getListsByCategory(ItemCategory category, int page) {
        return userListsRepository.findFirst10ByCategory(category, PageRequest.of(page, 10
        ));
    }

//    public List<UserLists> getListsByTitle(String title){
//        return userListsRepository.findByTitle(title);
//    }
//    public UserLists getListById(BigInteger id){
//        return userListsRepository.findById(id);
//    }
}

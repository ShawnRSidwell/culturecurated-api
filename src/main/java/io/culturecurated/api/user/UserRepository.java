package io.culturecurated.api.user;

import io.culturecurated.api.userlists.UserLists;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
interface  UserRepository  extends JpaRepository<User, UUID> {
    User findByUsername(String username);

    User findByEmail(String email);

    List<UserLists> findUserListsById(UUID userId);
}

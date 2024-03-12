package io.culturecurated.api.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
interface  UserRepository  extends JpaRepository<User, UUID> {
    User findByUsername(String username);

    User findByEmail(String email);
}

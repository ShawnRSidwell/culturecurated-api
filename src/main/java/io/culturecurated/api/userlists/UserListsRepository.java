package io.culturecurated.api.userlists;


import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

interface UserListsRepository extends JpaRepository<UserLists, BigInteger> {

    List<UserLists> findByUserId(UUID userId);

}

package io.culturecurated.api.userlists;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

@Repository
interface UserListsRepository extends PagingAndSortingRepository<UserLists, BigInteger> {

    List<UserLists> findByUserId(UUID userId);

    UserLists findById(BigInteger id);

    List<UserLists> findFirst10ByTitle(String title, Pageable pageable);


    List<UserLists> findFirst10ByCategory( ItemCategory category, Pageable pageable);

}

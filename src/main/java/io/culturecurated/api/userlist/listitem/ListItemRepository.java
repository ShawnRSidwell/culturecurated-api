package io.culturecurated.api.userlist.listitem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
interface ListItemRepository extends JpaRepository<ListItem, BigInteger> {
}

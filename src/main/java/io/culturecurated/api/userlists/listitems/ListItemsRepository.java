package io.culturecurated.api.userlists.listitems;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
interface ListItemsRepository extends JpaRepository<ListItems, BigInteger> {
}

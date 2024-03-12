package io.culturecurated.api.userlist;

import io.culturecurated.api.userlist.listitem.ItemCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name="user_lists")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserList {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;

    @Column(name = "user_id")
    private UUID userId;
    private String title;
    private String image;
    private String description;

    @Column(name = "item_category")
    private ItemCategory itemCategory;

    @Column(name = "date_created")
    private LocalDateTime dateCreated;

}

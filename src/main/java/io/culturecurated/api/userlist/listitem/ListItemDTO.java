package io.culturecurated.api.userlist.listitem;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.UUID;

public class ListItemDTO {



    private UUID userId;

    private String title;
    private String image;
    private String description;
    private ItemCategory itemCategory;

    private LocalDateTime dateCreated;

}

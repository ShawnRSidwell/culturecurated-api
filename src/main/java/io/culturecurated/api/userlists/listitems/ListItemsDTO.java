package io.culturecurated.api.userlists.listitems;

import io.culturecurated.api.userlists.ItemCategory;

import java.time.LocalDateTime;
import java.util.UUID;

public class ListItemsDTO {



    private UUID userId;

    private String title;
    private String image;
    private String description;
    private ItemCategory itemCategory;

    private LocalDateTime dateCreated;

}

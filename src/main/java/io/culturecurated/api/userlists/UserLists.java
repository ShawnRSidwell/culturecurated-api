package io.culturecurated.api.userlists;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.culturecurated.api.user.User;
import io.culturecurated.api.userlists.listitems.ListItems;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(name="user_lists")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLists {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;

    private String title;
    private String image;
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false)
    private ItemCategory category;

    @Column(name = "date_created")
    private LocalDateTime dateCreated;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "userLists")
    @OrderBy("subcategory, listItem")
    private List<ListItems> listItems = new ArrayList<>();
}

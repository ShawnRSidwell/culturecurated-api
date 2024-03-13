package io.culturecurated.api.userlists.listitems;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.culturecurated.api.user.User;
import io.culturecurated.api.userlists.UserLists;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "list_items")
public class ListItems {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;

    @Column(name = "list_item")
    private String listItem;

    private String image;

    private String description;

    private String link;

    private String subcategory;


    @ManyToOne
    @JoinColumn(name = "list_id")
    @JsonIgnore
    private UserLists userLists;



}

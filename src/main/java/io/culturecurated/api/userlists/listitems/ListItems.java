package io.culturecurated.api.userlists.listitems;

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

    @Column(name = "list_id")
    private BigInteger listId;

    private String image;

    private String description;

    private String link;

    private String subcategory;


}

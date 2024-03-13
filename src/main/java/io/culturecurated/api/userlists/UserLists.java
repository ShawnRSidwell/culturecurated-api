package io.culturecurated.api.userlists;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.culturecurated.api.user.User;
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
public class UserLists {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;

    private String title;
    private String image;
    private String description;

    @Enumerated(EnumType.STRING)
    private ItemCategory category;

    @Column(name = "date_created")
    private LocalDateTime dateCreated;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("userLists")
    private User user;
}

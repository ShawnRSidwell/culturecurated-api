package io.culturecurated.api.user;

import io.culturecurated.api.userlists.UserLists;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String username;

    private String password;

    private String email;

    @Column(name="profile_picture")
    private String profilePicture;

    private String biography;

    @OneToMany(mappedBy = "user")
    private List<UserLists> userLists = new ArrayList<>();

    public void addUserList(UserLists userLists) {
        this.userLists.add(userLists);
    }

    public void removeUserList(UserLists userLists) {
        this.userLists.remove(userLists);
    }



}

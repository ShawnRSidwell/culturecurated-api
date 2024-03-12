package io.culturecurated.api.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class UserDTO {
    private String username;

    private String password;

    private String email;

    private String profilePicture;

    private String biography;
}

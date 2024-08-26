package org.tc.backend.responses;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.tc.backend.models.User;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterResponse {
    @JsonProperty("message")
    private String message;

    @JsonProperty("user")
    private User user;


}

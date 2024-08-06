

package com.hotelhub.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserRespDTO {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String role;
    private String token;
    }


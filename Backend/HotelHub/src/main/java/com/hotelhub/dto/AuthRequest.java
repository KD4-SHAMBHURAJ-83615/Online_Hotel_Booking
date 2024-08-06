package com.hotelhub.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuthRequest {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;
    
    
}

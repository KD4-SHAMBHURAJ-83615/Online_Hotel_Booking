package com.hotelhub.dto;

import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.hotelhub.entity.Role;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserRegisterDTO extends BaseDTO {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Email
    @NotBlank
    private String email;

    
    @NotBlank
    private String password;

    @NotBlank
    private String phoneNo;

    @NotBlank
    private Role role; // CUSTOMER or OWNER

}

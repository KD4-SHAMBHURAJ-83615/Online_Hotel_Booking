package com.hotelhub.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddressDTO {

    private String addressLine;

    private String city;

    private String pincode;

    private String state;

    private String country;
}
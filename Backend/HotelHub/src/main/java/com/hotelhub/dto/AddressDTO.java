package com.hotelhub.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddressDTO extends BaseDTO{

    private String addressLine;

    private String city;

    private int pincode;

    private String state;

    private String country;
   
    private Long id;
}

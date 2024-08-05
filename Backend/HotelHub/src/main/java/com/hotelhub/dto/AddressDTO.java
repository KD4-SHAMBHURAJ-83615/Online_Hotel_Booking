package com.hotelhub.dto;

import lombok.Data;

@Data
public class AddressDTO extends BaseDTO{

    private String addressLine;
    private String city;
    private Integer pincode;
    private String state;
    private String country;
}


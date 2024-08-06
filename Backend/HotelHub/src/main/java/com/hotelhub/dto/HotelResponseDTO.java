package com.hotelhub.dto;

import lombok.Data;

@Data
public class HotelResponseDTO extends BaseDTO {
   
    private String hotelName;
    private String contactDetails;
    private byte[] image;
    private boolean swimmingPool;
    private boolean restaurant;
    private boolean gym;
    private boolean parking;
    private boolean wifi;
    private boolean powerbackup;
    private Long userId;
    private Long addressId;
}


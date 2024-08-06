package com.hotelhub.entity;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "hotel")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Hotel extends Base{

    @Column(name = "hotel_name", nullable = false, length = 50)
    private String hotelName;

    @Column(name = "contact_details", nullable = false, length = 20)
    private String contactDetails;

    @Column(name = "image")
    private byte[] image;

    @Column(name = "swimming_pool", nullable = false)
    private boolean swimmingPool;

    @Column(name = "restaurant", nullable = false)
    private boolean restaurant;

    @Column(name = "gym", nullable = false)
    private boolean gym;

    @Column(name = "parking", nullable = false)
    private boolean parking;

    @Column(name = "wifi", nullable = false)
    private boolean wifi;

    @Column(name = "powerbackup", nullable = false)
    private boolean powerbackup;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;
}


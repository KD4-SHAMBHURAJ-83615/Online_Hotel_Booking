package com.hotelhub.entity;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address extends Base {

    @Column(name = "address_line", nullable = false)
    private String addressLine;

    @Column(name = "city", length = 50)
    private String city;

    @Column(name = "pincode", length = 10)
    private int pincode;

    @Column(name = "state", length = 50)
    private String state;

    @Column(name = "country", length = 50)
    private String country;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

	
	
    
}

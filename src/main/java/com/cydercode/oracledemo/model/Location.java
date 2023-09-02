package com.cydercode.oracledemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "LOCATIONS")
@Data
public class Location {

    @Id
    @Column(name = "LOCATION_ID")
    private Integer locationId;

    @Column(name = "LOCATION_ADDRESS")
    private String streetAddress;

    @Column(name = "POSTAL_CODE")
    private String postalCode;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE_PROVINCE")
    private String stateProvince;

    @OneToOne
    @JoinColumn(name = "COUNTRY_ID")
    private Country country;
    
}

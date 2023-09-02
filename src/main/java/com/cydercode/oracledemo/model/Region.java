package com.cydercode.oracledemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "REGIONS")
@Data
public class Region {
    @Id
    @Column(name = "REGION_ID")
    private Integer regionId;

    @Column(name = "REGION_NAME")
    private String regionName;
}

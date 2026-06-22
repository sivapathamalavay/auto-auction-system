package com.autoauction.entity;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDateTime;

@Entity
@Table(name="vehicle")
@Data
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String vehicleName;
    private String brand;
    private String model;

    private Integer year;

    private String fuelType;

    private String startingPrice;

    private String currentBid;

    @Column(length = 1000)
    private String description;

    private String auctionEndTime;
}

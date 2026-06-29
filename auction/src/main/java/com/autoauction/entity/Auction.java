package com.autoauction.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import  com.autoauction.entity.AuctionStatus;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long auctionId;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private BigDecimal startingPrice;

    @Enumerated(EnumType.STRING)
    private AuctionStatus status;

}

package com.autoauction.dto;

import lombok.Data;

@Data
public class BidRequest {

    private Long userId;
    private Long vehicleId;
    private Double bidAmount;

}

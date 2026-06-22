package com.autoauction.dto;

import lombok.Data;

@Data
public class HighestBidResponseDTO {
    private Long vehicleId;
    private String vehicleName;
    private Double highestBidAmt;
    private Long userId;
    private String userName;
}

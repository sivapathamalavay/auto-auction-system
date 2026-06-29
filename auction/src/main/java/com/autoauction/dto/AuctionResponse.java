package com.autoauction.dto;

import com.autoauction.entity.Vehicle;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@JsonPropertyOrder({
        "auctionId",
        "vehicleId",
        "statTime",
        "endTime",
        "startingPrice",
        "status"
})
@Data
@Builder
public class AuctionResponse {
    private Long vehicleId;
    private Long auctionId;
    private LocalDateTime statTime;
    private LocalDateTime endTime;
    private BigDecimal startingPrice;
    private String status;
}

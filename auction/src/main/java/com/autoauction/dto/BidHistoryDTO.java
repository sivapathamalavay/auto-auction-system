package com.autoauction.dto;

import lombok.Data;

@Data
public class BidHistoryDTO {
    private Long bidderId;
    private String bidderName;
    private Double bidAmount;
}

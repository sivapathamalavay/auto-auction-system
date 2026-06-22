package com.autoauction.controller;

import com.autoauction.dto.BidHistoryDTO;
import com.autoauction.dto.BidRequest;
import com.autoauction.dto.HighestBidResponseDTO;
import com.autoauction.entity.Bid;
import com.autoauction.entity.BidDetail;
import com.autoauction.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bids")
public class BidController {

        @Autowired
        private BidService service;

        @PostMapping("/place")
        public Bid PlaceBid(@RequestBody BidRequest request){
            return service.placeBid(request);
        }

        @GetMapping("/highest/{vehicleId}")
        public ResponseEntity<HighestBidResponseDTO> getHighestBid(@PathVariable Long vehicleId) {
            return ResponseEntity.ok(service.getHighestBidDtl(vehicleId));
        }

        @GetMapping("/history/{vehicleId}")
        public ResponseEntity<List<BidHistoryDTO>> getBidHistory(Long vehicleId){
            return ResponseEntity.ok(service.getBidHistory(vehicleId));
        }

}

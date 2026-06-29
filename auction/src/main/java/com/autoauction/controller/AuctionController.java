package com.autoauction.controller;

import com.autoauction.dto.AuctionResponse;
import com.autoauction.dto.CreateAuctionRequest;
import com.autoauction.entity.Auction;
import com.autoauction.service.AuctionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auctions")
@RequiredArgsConstructor
public class AuctionController {
    @Autowired
    private AuctionService service;
    @PostMapping
    public ResponseEntity<Auction> createAuction(@RequestBody CreateAuctionRequest request){
        Auction auction = service.createAuction(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(auction);
    }

    @GetMapping("/all")
    public List<Auction> getAllAuctions(){
        return service.getAllAuctions();
    }

    @GetMapping("/{auctionId}")
    public AuctionResponse getAuction(@PathVariable Long auctionId){
        return service.getAuction(auctionId);
    }
}

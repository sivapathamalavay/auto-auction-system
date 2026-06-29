package com.autoauction.service;

import com.autoauction.dto.AuctionResponse;
import com.autoauction.dto.CreateAuctionRequest;
import com.autoauction.entity.Auction;
import com.autoauction.entity.AuctionStatus;
import com.autoauction.entity.Vehicle;
import com.autoauction.repository.AuctionRepository;
import com.autoauction.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuctionService {

    private final AuctionRepository auctionRepository;
    private final VehicleRepository vehicleRepository;

    public Auction createAuction(CreateAuctionRequest request){
        Vehicle vehicle = vehicleRepository.findById(request.getVehicleId())
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));
        Auction auction = Auction.builder()
                .vehicle(vehicle)
                .startTime(request.getStartTime())
                .endTime(request.getEndTime())
                .startingPrice(request.getStartingPrice())
                .status(AuctionStatus.valueOf(request.getStatus()))
                .build();

        return auctionRepository.save(auction);
    }

    public List<Auction> getAllAuctions(){return auctionRepository.findAll();}

    public AuctionResponse getAuction(Long auctionId){
        Auction auction = auctionRepository.findById(auctionId)
                .orElseThrow(()-> new RuntimeException("Auction not found"));
        AuctionResponse auctionResponse = AuctionResponse.builder()
                .vehicleId(auction.getVehicle().getId())
                .auctionId(auctionId)
                .statTime(auction.getStartTime())
                .endTime(auction.getEndTime())
                .startingPrice(auction.getStartingPrice())
                .status(auction.getStatus()!=null ? auction.getStatus().toString() : null)
                .build();
        return auctionResponse;}
}

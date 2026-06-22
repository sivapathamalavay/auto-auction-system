package com.autoauction.service;

import com.autoauction.dto.BidHistoryDTO;
import com.autoauction.dto.BidRequest;
import com.autoauction.dto.HighestBidResponseDTO;
import com.autoauction.entity.Bid;
import com.autoauction.entity.User;
import com.autoauction.entity.Vehicle;
import com.autoauction.repository.BidRepository;
import com.autoauction.repository.UserRepository;
import com.autoauction.repository.VehicleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BidService {

    private BidRepository repository;
    private UserRepository userRepository;
    private VehicleRepository vehicleRepository;

    public BidService(BidRepository repository,
                      UserRepository userRepository,
                      VehicleRepository vehicleRepository) {

        this.repository = repository;
        this.userRepository = userRepository;
        this.vehicleRepository = vehicleRepository;
    }
    public Bid placeBid(BidRequest request){

        User user = userRepository.findById(request.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        Vehicle vehicle = vehicleRepository.findById(request.getVehicleId()).orElseThrow(() -> new RuntimeException("Vehicle not found"));

       Bid highestBid = repository.findTopByVehicleIdOrderByBidAmountDesc(request.getVehicleId())
               .orElse(null);

        if(highestBid != null &&
                request.getBidAmount() <= highestBid.getBidAmount()) {

            throw new RuntimeException(
                    "Bid must be higher than current highest bid"
            );
        }
        Bid bid = new Bid();
        bid.setBidAmount(request.getBidAmount());
        bid.setUser(user);
        bid.setVehicle(vehicle);
        bid.setBidTime(LocalDateTime.now());

        return repository.save(bid);
    }

    public HighestBidResponseDTO getHighestBidDtl(Long vehicleId){
        Bid highestBid = repository
                .findTopByVehicleIdOrderByBidAmountDesc(vehicleId)
                .orElseThrow(()-> new RuntimeException("Vehicle not found"));
        HighestBidResponseDTO response = new HighestBidResponseDTO();

        response.setVehicleId(highestBid.getVehicle().getId());
        response.setVehicleName(highestBid.getVehicle().getVehicleName());
        response.setHighestBidAmt(highestBid.getBidAmount());
        response.setUserId(highestBid.getUser().getId());
        response.setUserName(highestBid.getUser().getName());
        return response;
    }

    public List<BidHistoryDTO> getBidHistory(Long vehicleId) {
        List<Bid> bids = repository
                .findByVehicleIdOrderByBidAmountDesc(vehicleId);
        List<BidHistoryDTO> response = new ArrayList<>();
        for (Bid bid : bids) {
            BidHistoryDTO bidDTO = new BidHistoryDTO();
            bidDTO.setBidderId(bid.getUser().getId());
            bidDTO.setBidderName(bid.getUser().getName());
            bidDTO.setBidAmount(bid.getBidAmount());
            response.add(bidDTO);
        }
        return response;
    }
    public Bid getHighestBid(Long vehicleId) {
        return repository
                .findTopByVehicleIdOrderByBidAmountDesc(vehicleId)
                .orElse(null);
    }
}

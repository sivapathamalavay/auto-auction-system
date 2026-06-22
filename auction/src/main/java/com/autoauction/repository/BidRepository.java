package com.autoauction.repository;

import com.autoauction.entity.Bid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BidRepository
        extends JpaRepository<Bid, Long>{
    Optional<Bid> findTopByVehicleIdOrderByBidAmountDesc(Long vehicleId);
    List<Bid> findByVehicleIdOrderByBidAmountDesc(Long vehicleId);

}



//package com.autoauction.repository;
//
//import com.autoauction.entity.Bid;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//
//@Repository
//public interface  BidRepository1  extends JpaRepository<Bid, Long> {
//    Bid findTopByVehicleVehicleIdOrderByBidAmountDesc(Long vehicleId);
//}

package com.example.IRCTC.Mock.Repository;

import com.example.IRCTC.Mock.Model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger,Integer> {

}

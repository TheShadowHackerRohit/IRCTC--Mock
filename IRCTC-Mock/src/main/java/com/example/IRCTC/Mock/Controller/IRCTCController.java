package com.example.IRCTC.Mock.Controller;


import com.example.IRCTC.Mock.DTO.PassengerRequestDto.TrainRequestDto;
import com.example.IRCTC.Mock.DTO.PassengerResponseDto.PassengerResponseDto;
import com.example.IRCTC.Mock.Enum.Station;
import com.example.IRCTC.Mock.Service.PassengerService;
import com.example.IRCTC.Mock.Service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/irctc")
public class IRCTCController {




    /*


    Create an IRCTC system ,

    Train = TrainNo ,Source ,Destination
    Passenger = TicketId ,TrainId ,Date.,Age,gender
    FoodOrder = TicketId,TrainId ,price

    POST API - Add a Passenger with ticketId , trainId ,Date,age,gender
    POST API - Add a Train with trainNo , source ,destination .

    GET API - Find the Number of passengers traveling from City X and City Y on Date D
    GET API - Find total No of female passengers of age between X and Y(X < = Y) who ended their destination at city C.
    GET API - Get the TrainId which received the maximum number of orders on Date D..

     */

    @Autowired
    PassengerService passengerService;

    @Autowired
    TrainService trainService;

    @PostMapping("/add-passenger")
    public ResponseEntity addPassenger(@RequestBody PassengerResponseDto passengerRequestDto){

        String response = passengerService.addPassenger(passengerRequestDto);
        return new ResponseEntity<>(response,  HttpStatus.CREATED);
    }

    @PostMapping("/add-train")
    public ResponseEntity addTrain(@RequestBody TrainRequestDto trainRequestDto){
        String response = trainService.addTrain(trainRequestDto);
        return  new ResponseEntity(response,HttpStatus.CREATED);
    }

// GET API - Find the Number of passengers traveling from City X and City Y on Date D

    @GetMapping("/find passenger for route")
    public ResponseEntity findPassengerForRoute(@RequestParam String source, @RequestParam String destination, @RequestParam Date date ){

     int count = passengerService.findPassengerForRoute(source,destination,date);
     return new ResponseEntity<>(count,HttpStatus.FOUND);
    }

//    GET API - Find total No of female passengers of age between X and Y(X < = Y) who ended their destination at city C.

    @GetMapping("/find female passenger ")
    public ResponseEntity findFemalePassengerForAge(@RequestParam int x, @RequestParam String destination, @RequestParam int y ){

        int count = passengerService.findFemalePassengerForAge(x,destination,y);
        return new ResponseEntity<>(count,HttpStatus.FOUND);
    }
//    GET API - Get the TrainId which received the maximum number of orders on Date D..


    @GetMapping("/find train maximum order ")
    public ResponseEntity findTrainMaximumOrder(@RequestParam Date date){

        int trainId = trainService.findTrainMaximumOrder(date);
        return new ResponseEntity<>(trainId,HttpStatus.FOUND);
    }
}


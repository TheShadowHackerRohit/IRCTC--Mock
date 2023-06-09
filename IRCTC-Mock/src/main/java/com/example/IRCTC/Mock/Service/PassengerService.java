package com.example.IRCTC.Mock.Service;

import com.example.IRCTC.Mock.DTO.PassengerResponseDto.PassengerResponseDto;
import com.example.IRCTC.Mock.Enum.Gender;
import com.example.IRCTC.Mock.Model.Passenger;
import com.example.IRCTC.Mock.Model.Ticket;
import com.example.IRCTC.Mock.Model.Train;
import com.example.IRCTC.Mock.Repository.FoodOrderRepository;
import com.example.IRCTC.Mock.Repository.PassengerRepository;
import com.example.IRCTC.Mock.Repository.TicketRepository;
import com.example.IRCTC.Mock.Repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Service
public class PassengerService {


//
//    GET API - Find the Number of passengers traveling from City X and City Y on Date D
//    GET API - Find total No of female passengers of age between X and Y(X < = Y) who ended their destination at city C.
//    GET API - Get the TrainId which received the maximum number of orders on Date D..
//            */
    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    TrainRepository trainRepository;

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    FoodOrderRepository foodOrderRepository;


    public String addPassenger(PassengerResponseDto passengerRequestDto) {
        Passenger passenger = new Passenger();

        Train train = trainRepository.findById(passengerRequestDto.getTrainId()).get();
        Ticket ticket = ticketRepository.findById(passengerRequestDto.getTicketId()).get();

        passenger.setAge(passengerRequestDto.getAge());
        passenger.setDate(passengerRequestDto.getDate());
        passenger.setGender(passengerRequestDto.getGender());
        passenger.setTrain(train);
        passenger.setTicket(ticket);


        Passenger savedPassenger = passengerRepository.save(passenger);

        return  "passenger successfully added with passenger id:"+ savedPassenger.getPassengerId() ;

    }
    // GET API - Find the Number of passengers traveling from City X and City Y on Date D

    public int findPassengerForRoute(String source, String destination, Date date) {
        List<Passenger> passengerList = passengerRepository.findAll();

        int count = 0;
        for (Passenger passenger : passengerList){
            Train train = passenger.getTrain();
            if(train.getSource().equals(source) && train.getDestination().equals(destination) && passenger.getDate().equals(date) ){
                count++;
            }
        }
        return count;
    }
//    GET API - Find total No of female passengers of age between X and Y(X < = Y) who ended their destination at city C.
    public int findFemalePassengerForAge(int x, String destination, int y) {
        List<Passenger> passengerList = passengerRepository.findAll();

        int count = 0;
        for (Passenger passenger : passengerList){
            Train train = passenger.getTrain();
            if(train.getDestination().equals(destination) && passenger.getGender().equals(Gender.FEMALE) && passenger.getAge() >= x && passenger.getAge() <= y  ){
                count++;
            }
        }
        return count;
    }
}

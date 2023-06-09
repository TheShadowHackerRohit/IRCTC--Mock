package com.example.IRCTC.Mock.Model;


import com.example.IRCTC.Mock.Enum.Station;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int trainId;

    int trainNo;

    @Enumerated(EnumType.STRING)
    Station source;

    @Enumerated(EnumType.STRING)
    Station destination;


    @OneToMany(mappedBy = "train",cascade = CascadeType.ALL)
    List<Ticket> ticketList = new ArrayList<>();


    @OneToMany(mappedBy = "train",cascade = CascadeType.ALL)
    List<Passenger> passengerList = new ArrayList<>();

    @OneToMany(mappedBy = "train",cascade = CascadeType.ALL)
    List<FoodOrder> foodOrderList= new ArrayList<>();

}


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
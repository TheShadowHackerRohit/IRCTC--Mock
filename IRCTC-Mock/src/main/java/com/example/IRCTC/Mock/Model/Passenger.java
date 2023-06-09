package com.example.IRCTC.Mock.Model;


import com.example.IRCTC.Mock.Enum.Gender;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int passengerId;

    @Timestamp
    Date date;

    int age;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @OneToOne(mappedBy = "passenger",cascade = CascadeType.ALL)
    Ticket ticket;// passenger is parent, ticket is child

    @ManyToOne
    @JoinColumn
    Train train;// train is parent, passenger is child

//    @OneToOne(mappedBy = "passenger",cascade = CascadeType.ALL)
//    FoodOrder foodOrder;
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
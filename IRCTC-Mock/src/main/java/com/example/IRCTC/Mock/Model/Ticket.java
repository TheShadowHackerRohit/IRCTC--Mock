package com.example.IRCTC.Mock.Model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int ticketId;

    @OneToOne
    @JoinColumn
    Passenger passenger;// ticket is child, passenger is parent.

    @ManyToOne
    @JoinColumn
    Train train;//ticket is child, train is parent.

    @OneToOne(mappedBy = "ticket",cascade = CascadeType.ALL)
    FoodOrder foodOrder;


}

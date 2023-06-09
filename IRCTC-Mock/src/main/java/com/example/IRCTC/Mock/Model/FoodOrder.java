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
public class FoodOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int foodOrderId;

    int price;

    @OneToOne
    @JoinColumn
    Ticket ticket;

    @ManyToOne
    @JoinColumn
    Train train;



}
//FoodOrder = TicketId,TrainId ,price
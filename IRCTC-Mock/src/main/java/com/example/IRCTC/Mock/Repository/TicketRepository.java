package com.example.IRCTC.Mock.Repository;

import com.example.IRCTC.Mock.Model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {
}

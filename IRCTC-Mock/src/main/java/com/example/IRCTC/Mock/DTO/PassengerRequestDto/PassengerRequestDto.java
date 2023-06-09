package com.example.IRCTC.Mock.DTO.PassengerRequestDto;

import com.example.IRCTC.Mock.Enum.Gender;
import com.example.IRCTC.Mock.Enum.Station;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class PassengerRequestDto {
//    POST API - Add a Train with trainNo , source ,destination .

//    POST API - Add a Passenger with ticketId , trainId ,Date,age,gender
//    POST API - Add a Train with trainNo , source ,destination .

    int ticketId;

    int trainId;

    Date date;

    Gender gender;

    int age;


}

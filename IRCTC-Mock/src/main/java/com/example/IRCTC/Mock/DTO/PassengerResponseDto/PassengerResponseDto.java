package com.example.IRCTC.Mock.DTO.PassengerResponseDto;

import com.example.IRCTC.Mock.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class PassengerResponseDto {

    int ticketId;

    int trainId;

    Date date;

    Gender gender;


    int age;

//    public int getTicketId() {
//        return ticketId;
//    }
//
//    public void setTicketId(int ticketId) {
//        this.ticketId = ticketId;
//    }
//
//    public int getTrainId() {
//        return trainId;
//    }
//
//    public void setTrainId(int trainId) {
//        this.trainId = trainId;
//    }
//
//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
//
//    public Gender getGender() {
//        return gender;
//    }
//
//    public void setGender(Gender gender) {
//        this.gender = gender;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
}

package com.example.IRCTC.Mock.DTO.PassengerRequestDto;

import com.example.IRCTC.Mock.Enum.Station;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class TrainRequestDto {

//    Add a Train with trainNo , source ,destination .

    int trainNo;

    Station source;

    Station destination;
}

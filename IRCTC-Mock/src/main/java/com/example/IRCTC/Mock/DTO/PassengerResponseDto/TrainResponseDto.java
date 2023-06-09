package com.example.IRCTC.Mock.DTO.PassengerResponseDto;

import com.example.IRCTC.Mock.Enum.Station;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class TrainResponseDto {

    int trainNo;

    Station source;

    Station destination;
}

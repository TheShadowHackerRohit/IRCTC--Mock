package com.example.IRCTC.Mock.Service;

import com.example.IRCTC.Mock.DTO.PassengerRequestDto.TrainRequestDto;
import com.example.IRCTC.Mock.Model.Train;
import com.example.IRCTC.Mock.Repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TrainService {

    @Autowired
    TrainRepository trainRepository;

    public String addTrain(TrainRequestDto trainRequestDto) {
        Train train = new Train();
        train.setTrainNo(trainRequestDto.getTrainNo());
        train.setSource(trainRequestDto.getSource());
        train.setDestination(trainRequestDto.getDestination());

        Train savedTrain = trainRepository.save(train);

        return "train is add with train id: "+ savedTrain.getTrainId();
    }

    public int findTrainMaximumOrder(Date date) {
        List<Train> trainList = trainRepository.findAll();
        int trainId = 0;
        int max = -1;

        for (Train train : trainList){
            if (train.getFoodOrderList().size()>max){
                trainId = train.getTrainId();
                max = train.getFoodOrderList().size();
            }
        }
        return trainId;
    }
}

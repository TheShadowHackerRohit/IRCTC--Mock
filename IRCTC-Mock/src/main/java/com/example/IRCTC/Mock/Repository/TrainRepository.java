package com.example.IRCTC.Mock.Repository;

import com.example.IRCTC.Mock.Model.Train;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepository extends JpaRepository<Train,Integer> {

}

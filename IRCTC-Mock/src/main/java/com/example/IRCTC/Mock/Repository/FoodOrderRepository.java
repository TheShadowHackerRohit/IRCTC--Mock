package com.example.IRCTC.Mock.Repository;

import com.example.IRCTC.Mock.Model.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodOrderRepository extends JpaRepository<FoodOrder,Integer> {
}

package com.points.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.points.model.Points;

@Repository
public interface PointsRepository extends CrudRepository<Points, Long>{

	List<Points> findByCustomerName(String customerName);
}

package com.points.service;

import java.util.List;

import com.points.dto.CustomerPointsDTO;
import com.points.model.Points;

public interface PointsService {

	void insertData(List<Points> list);

	CustomerPointsDTO getRewardPoints(String customerName);
}

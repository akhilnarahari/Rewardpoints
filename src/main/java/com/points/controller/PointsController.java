package com.points.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.points.dto.CustomerPointsDTO;
import com.points.service.PointsService;
import com.points.util.PointsUtil;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PointsController {
	@Autowired
	private PointsService rewardsService;
	
	@GetMapping("/createSampleData")
	public String createSampleData() throws ParseException{
		rewardsService.insertData(PointsUtil.getDataSet());
		return "Sample Data is inserted";
	}
	@GetMapping("/getRewardPoints")
	public CustomerPointsDTO getRewardPoints(@RequestParam("customerName") String customerName) throws ParseException{
		return rewardsService.getRewardPoints(customerName);
	}
}

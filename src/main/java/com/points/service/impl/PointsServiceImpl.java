package com.points.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.points.dto.CustomerPointsDTO;
import com.points.dto.PointsDTO;
import com.points.model.Points;
import com.points.repository.PointsRepository;
import com.points.service.PointsService;

@Service
public class PointsServiceImpl implements PointsService{
	
	@Autowired
	private PointsRepository repositoy;

	@Override
	public CustomerPointsDTO getRewardPoints(String customerName) {
		List<Points> rewards = repositoy.findByCustomerName(customerName);
		Map<Object, Long> months = rewards.stream()
				.collect(Collectors.groupingBy(element -> element.getCreatedDate().getMonth(),Collectors.summingLong(element->element.getPoints())));

		List<PointsDTO> rewardsDTO = new ArrayList<PointsDTO>(); 
		Long total = 0l;
		for (Entry<Object, Long> entry : months.entrySet()) {
			PointsDTO dto = new PointsDTO();
			dto.setMonth(((Integer)entry.getKey()+1));
			Long monthTotal = entry.getValue();
			total += monthTotal;
			dto.setMonthPoints(monthTotal);
			
			rewardsDTO.add(dto);
		}
		
		CustomerPointsDTO customerDetails = new CustomerPointsDTO();
		customerDetails.setTotalPoints(total);
		customerDetails.setRewards(rewardsDTO);
		return customerDetails;
	}
	
	private Integer getPoints(Points r) {
		Integer amount = r.getPurchaseAmount();
		if(amount<=50){
			return 0;
		}else if(amount<=100){
			 return (amount-50)*1;
		}else{
			return 50+(amount%100)*2;
		}
	}

	@Override
	public void insertData(List<Points> list) {
		for(Points r :  list){
			Integer points = getPoints(r);
			r.setPoints(points);
			repositoy.save(r);
		}
	}
}

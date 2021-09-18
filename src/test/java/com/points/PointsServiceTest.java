package com.points;

import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.points.dto.CustomerPointsDTO;
import com.points.dto.PointsDTO;
import com.points.model.Points;
import com.points.service.PointsService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PointsServiceTest {

	@Autowired
	private PointsService rewardsService;
	
	@Before
	public void before() throws ParseException{

	}
	
	@Test
	public void getRewardPointsForCutomer1() throws ParseException {
		insertCustomer1Data();
		CustomerPointsDTO  customerDetails = rewardsService.getRewardPoints("customer1");
		assertTrue(customerDetails.getTotalPoints() == 50);
		assertTrue(customerDetails.getRewards().size() == 2);
		List<PointsDTO> rewards = customerDetails.getRewards();
		assertTrue(rewards.get(0).getMonth() == 1);
		assertTrue(rewards.get(0).getMonthPoints() == 50);
	}
	
	private void insertCustomer1Data() throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
		
		Points reward1 = new Points();
		reward1.setCustomerName("customer1");
		reward1.setPurchaseAmount(100);
		reward1.setCreatedDate(sdf.parse("13/01/2021"));
		
		Points reward2 = new Points();
		reward2.setCustomerName("customer1");
		reward2.setPurchaseAmount(40);
		reward2.setCreatedDate(sdf.parse("01/02/2021"));
		List<Points> list = new ArrayList<>();
		list.add(reward1);
		list.add(reward2);
		rewardsService.insertData(list);
	}
	@Test
	public void getRewardPointsForCutomer2() throws ParseException{
		insertCustomer2Data();
		CustomerPointsDTO  customerDetails = rewardsService.getRewardPoints("customer2");
		assertTrue(customerDetails.getTotalPoints() == 200);
		assertTrue(customerDetails.getRewards().size() == 2);
		List<PointsDTO> rewards = customerDetails.getRewards();
		assertTrue(rewards.get(0).getMonth() == 1);
		assertTrue(rewards.get(0).getMonthPoints() == 90);
	}
	
	private void insertCustomer2Data() throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
		// 2nd Customer
		Points c1 = new Points();
		c1.setCustomerName("customer2");
		c1.setPurchaseAmount(120);
		c1.setCreatedDate(sdf.parse("11/01/2021"));
		
		Points c2 = new Points();
		c2.setCustomerName("customer2");
		c2.setPurchaseAmount(130);
		c2.setCreatedDate(sdf.parse("01/02/2021"));
		
		List<Points> list = new ArrayList<>();
		list.add(c1);
		list.add(c2);
		
		rewardsService.insertData(list);
	}
}

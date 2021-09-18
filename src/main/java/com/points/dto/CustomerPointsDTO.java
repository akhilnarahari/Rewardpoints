package com.points.dto;

import java.util.List;

public class CustomerPointsDTO {
	private Long totalPoints;
	private List<PointsDTO> rewards;
	
	
	public Long getTotalPoints() {
		return totalPoints;
	}
	public void setTotalPoints(Long totalPoints) {
		this.totalPoints = totalPoints;
	}
	public List<PointsDTO> getRewards() {
		return rewards;
	}
	public void setRewards(List<PointsDTO> rewards) {
		this.rewards = rewards;
	}
	
	

}

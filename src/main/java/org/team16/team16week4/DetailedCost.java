package org.team16.team16week4;

public class DetailedCost {
	private double additionalLineCost;
	private double overExcessMinutesCost;
	private double totalCost;
	private User userData;
	
	public DetailedCost(User userData){
		this.userData = userData;
		this.calculateAdditionalLineCost();
		this.calculateOverExcessMinutesCost();
		this.calculateTotalCost();
	}
	
	public double getTotalCost(){
		return this.totalCost;
	}
	
	public double getOverExcessMinutesCost(){
		return this.overExcessMinutesCost;
	}
	
	public double getAdditionalLineCost(){
		return this.additionalLineCost;
	}
	
	private void calculateAdditionalLineCost(){
		if(this.userData.getNumberOfLines() == 1 || this.userData.getNumberOfLines()==2 ){
			this.additionalLineCost =  (this.userData.getNumberOfLines()-1)*this.userData.getUserPlan().getAdditionalLineRate();
		}
		else if(this.userData.getNumberOfLines() > 2){
			this.additionalLineCost =  2*this.userData.getUserPlan().getAdditionalLineRate() + (this.userData.getNumberOfLines()-3)*5;
		}
		else{
			System.out.println("뭐여 어째서 추가 라인수가 "+this.userData.getNumberOfLines()+"이여");
		}
		
	}
	
	private void calculateOverExcessMinutesCost(){
		if(this.userData.getUsedMinutes() < this.userData.getUserPlan().getIncludeMinutes()){
			this.overExcessMinutesCost = 0;
		}
		else{
			this.overExcessMinutesCost = (this.userData.getUsedMinutes() - this.userData.getUserPlan().getIncludeMinutes())*this.userData.getUserPlan().getRatePerExcessMinute();
		}
	}
	
	private void calculateTotalCost(){
		this.totalCost = this.userData.getUserPlan().getBasicMonthlyRate() + this.overExcessMinutesCost + this.additionalLineCost;
	}
	
	public String getTotalCostEvaluation(){
		return null;
	}
	
	public String getOverExcessMinutesCostEvaluation(){
		return null;
	}
	
	public String getAdditionalLineCostEvaluation(){
		return null;
	}
}
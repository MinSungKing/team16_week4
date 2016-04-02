package org.team16.team16week4;

public class PrintExpectedBill {

	private DetailedCost detailedCost;
	
	public PrintExpectedBill(DetailedCost aDetailedCost){
		this.detailedCost = aDetailedCost;
	}
	
	public String printTotalCostEvaluation(){
		StringBuilder expression = new StringBuilder(this.detailedCost.getUserData().getUserPlan().getBasicMonthlyRate() + "");
		
		String excessMinuteForm = printOverExcessMinutesCostEvaluation();
		if (excessMinuteForm != null)
			expression.append(excessMinuteForm);
		
		String additionalLineForm = printAdditionalLineCostEvaluation();
		if (additionalLineForm != null)
			expression.append(additionalLineForm);
	
		return expression.toString() + " = " + String.format("%.2f", this.detailedCost.getTotalCost());
	}
	
	public String printOverExcessMinutesCostEvaluation(){
		if(this.detailedCost.getUserData().getUsedMinutes() > this.detailedCost.getUserData().getUserPlan().getIncludeMinutes())
			return " + (" + (this.detailedCost.getUserData().getUsedMinutes()-this.detailedCost.getUserData().getUserPlan().getIncludeMinutes()) + "*" + this.detailedCost.getUserData().getUserPlan().getRatePerExcessMinute() + ")";
		return null;
	}
	
	public String printAdditionalLineCostEvaluation(){
		if(this.detailedCost.getUserData().getNumberOfLines() == 1)
			return null;
		if(this.detailedCost.getUserData().getFamilyDiscount()){
			if(this.detailedCost.getUserData().getNumberOfLines()==4)
				return " + (" + 2 + "*" + this.detailedCost.getUserData().getUserPlan().getAdditionalLineRate() + ")" + " + " + this.detailedCost.getUserData().getUserPlan().getFamilyDiscountFee();
			else
				return " + (" + 2 + "*" + this.detailedCost.getUserData().getUserPlan().getAdditionalLineRate() + ") + (" + (this.detailedCost.getUserData().getNumberOfLines()-3) + "*" + this.detailedCost.getUserData().getUserPlan().getFamilyDiscountFee() + ")";
		}
		else{
			if(this.detailedCost.getUserData().getNumberOfLines()==2)
				return " + " + this.detailedCost.getUserData().getUserPlan().getAdditionalLineRate();
			else
				return " + (" + this.detailedCost.getUserData().getNumberOfLines() + "*" + this.detailedCost.getUserData().getUserPlan().getAdditionalLineRate() + ")"; 
		}
	}
}
package com.project.trade.constants;

public enum ExpiryConstants {
	EXPIRED('Y'), NOT_EXPIRED('N');
	
	private Character isExpired;
	
	public Character getIsExpired() {
		return isExpired;
	}
	private ExpiryConstants(Character isExpired) {
		this.isExpired = isExpired;
		
	}

}

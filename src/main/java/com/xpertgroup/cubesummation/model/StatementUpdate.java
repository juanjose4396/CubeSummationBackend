package com.xpertgroup.cubesummation.model;

public class StatementUpdate extends Statement {
	
	private int value;
	
	@Override
	public boolean isValid() {
		if(x1 >= 0 && y1 >= 0 && z1 >= 0) {
			return true;
		}
		return false;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
}

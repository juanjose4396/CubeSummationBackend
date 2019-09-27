package com.xpertgroup.cubesummation.model;

public class StatementQuery extends Statement{

	private int x2;
	
	private int y2;
	
	private int z2;

	@Override
	public boolean isValid() {
		if(x1 >= 0 && x2 >= 0 && y1 >= 0 && y2 >= 0 && z1 >= 0 && z2 >= 0) {
			return true;
		}
		
		if(x1 < x2 && y1 < y2 && z1 < z2) {
			return true;
		}
		return false;
	}
	
	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public int getZ2() {
		return z2;
	}

	public void setZ2(int z2) {
		this.z2 = z2;
	}
	
}

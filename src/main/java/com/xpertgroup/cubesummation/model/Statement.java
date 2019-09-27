package com.xpertgroup.cubesummation.model;

public abstract class Statement {
	
	protected int x1;
	
	protected int y1;
	
	protected int z1;
	
	public abstract boolean isValid();

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getZ1() {
		return z1;
	}

	public void setZ1(int z1) {
		this.z1 = z1;
	}
	
}

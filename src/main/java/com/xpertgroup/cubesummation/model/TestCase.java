package com.xpertgroup.cubesummation.model;

import java.util.List;

public class TestCase {

	private int sizeMatriz;
	
	private int numberOfOperations;
	
	private List<Operation> operations;
	
	public boolean isValid() {
		return sizeMatriz <= 100 && numberOfOperations <= 1000 ? true : false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numberOfOperations;
		result = prime * result + ((operations == null) ? 0 : operations.hashCode());
		result = prime * result + sizeMatriz;
		return result;
	}

	public int getSizeMatriz() {
		return sizeMatriz;
	}

	public void setSizeMatriz(int sizeMatriz) {
		this.sizeMatriz = sizeMatriz;
	}

	public int getNumberOfOperations() {
		return numberOfOperations;
	}

	public void setNumberOfOperations(int numerOfOperations) {
		this.numberOfOperations = numerOfOperations;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	
}

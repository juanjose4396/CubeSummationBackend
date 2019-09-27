package com.xpertgroup.cubesummation.repository;

import java.util.ArrayList;
import java.util.List;

import com.xpertgroup.cubesummation.model.Operation;
import com.xpertgroup.cubesummation.model.TestCase;

public class TestCaseRepositoryTest {
		
	public List<TestCase> construirTestCase() {
		List<TestCase> testsCase = new ArrayList<>();
		
		TestCase testCaseOne = new TestCase();
		testCaseOne.setSizeMatriz(4);
		testCaseOne.setNumberOfOperations(5);
		
		List<Operation> operationsTestCaseOne = construirOperacionesTestCaseOne();
		
		testCaseOne.setOperations(operationsTestCaseOne);
		
		TestCase testCaseTwo = new TestCase();		
		testCaseTwo.setSizeMatriz(2);
		testCaseTwo.setNumberOfOperations(4);
		
		List<Operation> operationsTestCaseTwo = construirOperacionesTestCaseTwo();
		
		testCaseTwo.setOperations(operationsTestCaseTwo);
		
		testsCase.add(testCaseOne);
		testsCase.add(testCaseTwo);
		
		return testsCase;
	}
	
	public List<Operation> construirOperacionesTestCaseOne() {
		List<Operation> operationsTestCaseOne = new ArrayList<>();
		Operation operationOne = new Operation();
		Operation operationTwo = new Operation();
		Operation operationThree = new Operation();
		Operation operationFour = new Operation();
		Operation operationFive = new Operation();
		
		operationsTestCaseOne.add(operationOne);
		operationsTestCaseOne.add(operationTwo);
		operationsTestCaseOne.add(operationThree);
		operationsTestCaseOne.add(operationFour);
		operationsTestCaseOne.add(operationFive);
		
		return operationsTestCaseOne;
		
	}
	
	public static List<Operation> construirOperacionesTestCaseTwo() {
		List<Operation> operationsTestCaseTwo = new ArrayList<>();

		Operation operationSix = new Operation();
		Operation operationSeven = new Operation();
		Operation operationEight = new Operation();
		Operation operationNine = new Operation();
		
		operationsTestCaseTwo.add(operationSix);
		operationsTestCaseTwo.add(operationSeven);
		operationsTestCaseTwo.add(operationEight);
		operationsTestCaseTwo.add(operationNine);
		
		return operationsTestCaseTwo;
	}
	
	public String[] contruirArrayValuesStatementUpdate() {
		String[] arrayValues = new String[5];
		arrayValues[0] = "UPDATE";
		arrayValues[1] = "2";
		arrayValues[2] = "2";
		arrayValues[3] = "2";
		arrayValues[4] = "4";
		return arrayValues;
	}
}

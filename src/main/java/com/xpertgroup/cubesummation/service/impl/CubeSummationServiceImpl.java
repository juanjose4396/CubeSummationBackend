package com.xpertgroup.cubesummation.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xpertgroup.cubesummation.exception.NotFoundOperationsException;
import com.xpertgroup.cubesummation.exception.StatementMalformedException;
import com.xpertgroup.cubesummation.exception.TestCaseInvalidException;
import com.xpertgroup.cubesummation.model.Operation;
import com.xpertgroup.cubesummation.model.StatementQuery;
import com.xpertgroup.cubesummation.model.StatementUpdate;
import com.xpertgroup.cubesummation.model.TestCase;
import com.xpertgroup.cubesummation.repository.MatrixRepository;
import com.xpertgroup.cubesummation.service.CubeSummationService;
import com.xpertgroup.cubesummation.service.mapper.StatementMapper;

@Service
public class CubeSummationServiceImpl implements CubeSummationService {
	
	private final static String TYPE_UPDATE = "UPDATE";
	
	private final static String TYPE_QUERY = "QUERY";
	
	private final static int MAX_NUMBER_TEST_CASE = 50;

	@Autowired
	private MatrixRepository matrixRepository;
	
	@Autowired
	private StatementMapper statementMapper;
	
	@Override
	public List<Integer> solucionar(List<TestCase> testsCase) throws StatementMalformedException, TestCaseInvalidException, NotFoundOperationsException {
		validarNumberTestCase(testsCase.size());
		
		List<Integer> operationsResult = new ArrayList<Integer>();	
		for (TestCase tc : testsCase) {
			validateTestCase(tc);

			validateNumberOperations(tc.getOperations());
			
			matrixRepository.construirMatrix(tc.getSizeMatriz());
			List<Integer> result = ejecutarOperations(tc.getOperations());
			operationsResult.addAll(result);
		}
		return operationsResult;
	}
	
	public void validarNumberTestCase(int numberOfTestCase) throws TestCaseInvalidException {
		if (numberOfTestCase > MAX_NUMBER_TEST_CASE) {
			throw new TestCaseInvalidException();
		}
	}
	
	public void validateTestCase(TestCase testcase) throws TestCaseInvalidException {
		if (!testcase.isValid()) {
			throw new TestCaseInvalidException();
		}
	}
	
	public void validateNumberOperations(List<Operation> operations) throws NotFoundOperationsException {
		if(operations == null || operations.isEmpty()) {
			throw new NotFoundOperationsException();
		}
	}
	
	public List<Integer> ejecutarOperations(List<Operation> operations) throws StatementMalformedException {
		List<Integer> operationsResult = new ArrayList<Integer>();
		for (Operation op : operations) {
			Integer result = procesarStatement(op.getStatement());
			if(result > -1) {
				operationsResult.add(result);
			}
		}
		return operationsResult;
	}
	
	public Integer procesarStatement(String statement) throws StatementMalformedException {
		String[] statementsValues = statement.split(" ");
		String typeStatement = statementsValues[0];
		Integer result = ejecutarStatement(typeStatement, statementsValues);
		return result;	
	}
	
	public Integer ejecutarStatement(String typeStatement, String[] statementsValues) throws StatementMalformedException {
		if(TYPE_UPDATE.equalsIgnoreCase(typeStatement)) {
			ejecutarStatementUpdate(statementsValues);
			return -1;
		} 
		if(TYPE_QUERY.equalsIgnoreCase(typeStatement)) {
			Integer result = ejecutarStatementQuery(statementsValues);
			return result; 
		}
		
		throw new StatementMalformedException();
	}
	
	public Integer ejecutarStatementQuery(String[] statementsValues) throws StatementMalformedException {
		StatementQuery statament = statementMapper.mapToStatementQuery(statementsValues);
		int suma = matrixRepository.query(statament.getX1(), statament.getX2(), statament.getY1(), statament.getY2(), statament.getZ1(), statament.getZ2());
		return suma;
	}
	
	public void ejecutarStatementUpdate(String[] statementsValues) throws StatementMalformedException {
		StatementUpdate statament = statementMapper.mapToStatementUpdate(statementsValues);
		matrixRepository.update(statament.getX1(), statament.getY1(), statament.getZ1(), statament.getValue());
	}

}

package com.xpertgroup.cubesummation.service;

import java.util.List;

import com.xpertgroup.cubesummation.exception.NotFoundOperationsException;
import com.xpertgroup.cubesummation.exception.StatementMalformedException;
import com.xpertgroup.cubesummation.exception.TestCaseInvalidException;
import com.xpertgroup.cubesummation.model.TestCase;

public interface CubeSummationService {

	public List<Integer> solucionar(List<TestCase> testsCase) throws StatementMalformedException, TestCaseInvalidException, NotFoundOperationsException;
	
}

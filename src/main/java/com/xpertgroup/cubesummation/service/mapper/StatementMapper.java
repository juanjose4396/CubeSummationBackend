package com.xpertgroup.cubesummation.service.mapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.xpertgroup.cubesummation.exception.StatementMalformedException;
import com.xpertgroup.cubesummation.model.StatementQuery;
import com.xpertgroup.cubesummation.model.StatementUpdate;

@Component
public class StatementMapper {
	
	private final int INDEX_TYPE_STATEMENT = 0;
	
	public StatementQuery mapToStatementQuery(String[] statementValues) throws StatementMalformedException{
		StatementQuery statement = new StatementQuery();
		List<Integer> statementValueList = convertToValuesFormatStatement(statementValues);
		try {
			statement.setX1(statementValueList.get(0));
			statement.setY1(statementValueList.get(1));
			statement.setZ1(statementValueList.get(2));
			statement.setX2(statementValueList.get(3));
			statement.setY2(statementValueList.get(4));
			statement.setZ2(statementValueList.get(5));
			
			if(!statement.isValid()) {
				throw new StatementMalformedException();
			}
		}catch (IndexOutOfBoundsException e) {
			throw new StatementMalformedException();
		}
		return statement;
	}
	
	public StatementUpdate mapToStatementUpdate(String[] statementValues) throws StatementMalformedException{
		StatementUpdate statement = new StatementUpdate();
		List<Integer> statementValueList = convertToValuesFormatStatement(statementValues);
		try {
			statement.setX1(statementValueList.get(0));
			statement.setY1(statementValueList.get(1));
			statement.setZ1(statementValueList.get(2));
			statement.setValue(statementValueList.get(3) + 1);
			
			if(!statement.isValid()) {
				throw new StatementMalformedException();
			}
		}catch (IndexOutOfBoundsException e) {
			throw new StatementMalformedException();
		}
		return statement;
	}
	
	public List<Integer> convertToValuesFormatStatement(String[] statementValues) {
		List<Integer> values = new ArrayList<>();
		List<String> statementValuesList = new ArrayList<>(Arrays.asList(statementValues));
		statementValuesList.remove(INDEX_TYPE_STATEMENT);
		values = statementValuesList.stream().map(Integer::valueOf).map(value -> value - 1).collect(Collectors.toList());
		return values;
	}
	
}

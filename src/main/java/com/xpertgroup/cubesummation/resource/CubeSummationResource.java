package com.xpertgroup.cubesummation.resource;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xpertgroup.cubesummation.exception.NotFoundOperationsException;
import com.xpertgroup.cubesummation.exception.StatementMalformedException;
import com.xpertgroup.cubesummation.exception.TestCaseInvalidException;
import com.xpertgroup.cubesummation.model.TestCase;
import com.xpertgroup.cubesummation.service.CubeSummationService;
import com.xpertgroup.cubesummation.util.LogMessageConstant;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class CubeSummationResource {
	
	private final Logger logger = LoggerFactory.getLogger(CubeSummationResource.class);
	
	@Autowired
	private CubeSummationService cubeSummationService;

	@PostMapping("/solucionar")
	public ResponseEntity<?> solucionar(@RequestBody List<TestCase> testsCase) {
		logger.info(LogMessageConstant.SOLUTION_MESSAGE_LOG);
		List<Integer> result = new ArrayList<>();
		try {
			result = cubeSummationService.solucionar(testsCase);
		} catch (StatementMalformedException e) {
			return ResponseEntity.badRequest().body(StatementMalformedException.MESSAGE);
		} catch (TestCaseInvalidException e) {
			return ResponseEntity.badRequest().body(TestCaseInvalidException.MESSAGE);
		} catch (NotFoundOperationsException e) {
			return ResponseEntity.badRequest().body(NotFoundOperationsException.MESSAGE);
		}
		return ResponseEntity.ok(result);
	}
	
}

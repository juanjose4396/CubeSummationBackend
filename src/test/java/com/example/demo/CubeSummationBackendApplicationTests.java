package com.example.demo;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xpertgroup.cubesummation.CubeSummationBackendApplication;
import com.xpertgroup.cubesummation.model.TestCase;
import com.xpertgroup.cubesummation.repository.TestCaseRepositoryTest;
import com.xpertgroup.cubesummation.service.mapper.StatementMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = CubeSummationBackendApplication.class)
public class CubeSummationBackendApplicationTests {

	private static final Logger logger = LoggerFactory.getLogger(CubeSummationBackendApplicationTests.class);

	@Autowired
	private MockMvc mockMvc;

	private String apiRootPath = "http://localhost/api/solucionar";

	@MockBean
	private TestCaseRepositoryTest testCaseRepositoryTest;
	
	@Autowired
	private StatementMapper statementMapper;

	@Test
	public void testIntegration() {	
		try {
			List<TestCase> testsCase = testCaseRepositoryTest.construirTestCase();

			mockMvc.perform( MockMvcRequestBuilders
					.post(apiRootPath)
					.contentType(MediaType.APPLICATION_JSON)
					.content(asJsonString(testsCase))
					.accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk());
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}

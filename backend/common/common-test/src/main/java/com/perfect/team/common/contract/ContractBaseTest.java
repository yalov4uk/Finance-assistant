package com.perfect.team.common.contract;

import static java.util.Collections.emptyList;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@AutoConfigureWireMock(port = 0)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public abstract class ContractBaseTest {

  private static final String BEARER_TYPE = "Bearer ";

  @Autowired
  private ObjectMapper objectMapper;
  @Autowired
  private WebApplicationContext webApplicationContext;

  @Before
  public void setUp() throws Exception {
    RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
  }

  @After
  public void tearDown() throws Exception {
    RestAssuredMockMvc.reset();
  }

  protected String getAuthorizationHeader() throws JsonProcessingException {
    Map<String, Object> userContext = new HashMap<>();
    userContext.put("userId", "1");
    userContext.put("roles", emptyList());
    return BEARER_TYPE + objectMapper.writeValueAsString(userContext);
  }
}

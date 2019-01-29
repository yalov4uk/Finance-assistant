package com.perfect.team.edge.filter;

import com.netflix.zuul.context.RequestContext;
import com.perfect.team.auth.api.dto.TokenRequest;
import com.perfect.team.auth.api.dto.TokenResponse;
import com.perfect.team.auth.client.TokenClient;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

@RunWith(MockitoJUnitRunner.class)
public class AuthFilterTest {

  private final static String FIRST_PART = "1";
  private final static String SECOND_PART = "2";
  private final static String TOKEN = "token";

  @Mock
  private TokenClient tokenClient;
  @InjectMocks
  private AuthFilter authFilter;

  @Before
  public void setUp() throws Exception {
    RequestContext context = new RequestContext();
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addHeader(HttpHeaders.AUTHORIZATION, FIRST_PART + " " + SECOND_PART);
    context.setRequest(request);
    RequestContext.testSetCurrentContext(context);
  }

  @After
  public void tearDown() throws Exception {
    RequestContext.getCurrentContext().clear();
  }

  @Test
  public void run() throws Exception {
    TokenRequest tokenRequest = new TokenRequest(SECOND_PART);
    TokenResponse tokenResponse = new TokenResponse(TOKEN);
    Mockito.when(tokenClient.decrypt(tokenRequest)).thenReturn(ResponseEntity.ok(tokenResponse));

    authFilter.run();

    Assert.assertEquals(FIRST_PART + " " + TOKEN, RequestContext.getCurrentContext()
        .getZuulRequestHeaders()
        .get(HttpHeaders.AUTHORIZATION
            .toLowerCase()));
  }
}

package com.perfect.team.auth.client;

import com.perfect.team.auth.api.controller.TokenController;
import com.perfect.team.common.client.config.CommonClientConfig;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "auth-service", contextId = "tokenClient",
    configuration = CommonClientConfig.class)
public interface TokenClient extends TokenController {

}
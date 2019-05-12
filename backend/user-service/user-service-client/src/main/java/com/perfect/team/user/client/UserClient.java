package com.perfect.team.user.client;

import com.perfect.team.common.client.config.CommonClientConfig;
import com.perfect.team.user.api.controller.UserController;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "user-service", contextId = "userClient", configuration = CommonClientConfig.class)
public interface UserClient extends UserController {

}

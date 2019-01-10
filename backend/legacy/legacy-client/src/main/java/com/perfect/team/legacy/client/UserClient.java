package com.perfect.team.legacy.client;

import com.perfect.team.common.client.config.CommonClientConfig;
import com.perfect.team.legacy.api.UserResource;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "user", configuration = CommonClientConfig.class)
public interface UserClient extends UserResource {

}

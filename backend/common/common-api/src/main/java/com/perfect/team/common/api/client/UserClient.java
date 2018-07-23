package com.perfect.team.common.api.client;

import com.perfect.team.common.api.rest.UserResource;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("user")
public interface UserClient extends UserResource {

}

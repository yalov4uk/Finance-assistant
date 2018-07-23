package com.perfect.team.common.api.client;

import com.perfect.team.common.api.rest.AuthResource;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("auth")
public interface AuthClient extends AuthResource {

}

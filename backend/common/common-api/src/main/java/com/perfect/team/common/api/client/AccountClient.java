package com.perfect.team.common.api.client;

import com.perfect.team.common.api.rest.AccountResource;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("account")
public interface AccountClient extends AccountResource {

}

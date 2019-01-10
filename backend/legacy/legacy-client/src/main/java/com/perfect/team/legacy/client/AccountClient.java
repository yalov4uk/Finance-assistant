package com.perfect.team.legacy.client;


import com.perfect.team.common.client.config.CommonClientConfig;
import com.perfect.team.legacy.api.AccountResource;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "account", configuration = CommonClientConfig.class)
public interface AccountClient extends AccountResource {

}

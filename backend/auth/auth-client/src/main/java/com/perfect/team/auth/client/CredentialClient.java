package com.perfect.team.auth.client;

import com.perfect.team.auth.api.controller.CredentialController;
import com.perfect.team.common.client.config.CommonClientConfig;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "auth", configuration = CommonClientConfig.class)
public interface CredentialClient extends CredentialController {

}

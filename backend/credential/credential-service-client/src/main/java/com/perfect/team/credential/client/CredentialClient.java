package com.perfect.team.credential.client;

import com.perfect.team.common.client.config.CommonClientConfig;
import com.perfect.team.credential.api.controller.CredentialController;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "credential-service", contextId = "credentialClient",
    configuration = CommonClientConfig.class)
public interface CredentialClient extends CredentialController {

}

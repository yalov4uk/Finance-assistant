package com.perfect.team.legacy.client;

import com.perfect.team.common.client.config.CommonClientConfig;
import com.perfect.team.legacy.api.ConfirmationResource;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "confirmation", configuration = CommonClientConfig.class)
public interface ConfirmationClient extends ConfirmationResource {

}

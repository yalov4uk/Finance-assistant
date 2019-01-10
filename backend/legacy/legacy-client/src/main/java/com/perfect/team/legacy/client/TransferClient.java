package com.perfect.team.legacy.client;

import com.perfect.team.common.client.config.CommonClientConfig;
import com.perfect.team.legacy.api.TransferResource;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "transfer", configuration = CommonClientConfig.class)
public interface TransferClient extends TransferResource {

}

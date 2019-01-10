package com.perfect.team.legacy.client;

import com.perfect.team.common.client.config.CommonClientConfig;
import com.perfect.team.legacy.api.TransactionResource;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "transaction", configuration = CommonClientConfig.class)
public interface TransactionClient extends TransactionResource {

}

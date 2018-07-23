package com.perfect.team.common.api.client;

import com.perfect.team.common.api.rest.TransactionResource;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("transaction")
public interface TransactionClient extends TransactionResource {

}

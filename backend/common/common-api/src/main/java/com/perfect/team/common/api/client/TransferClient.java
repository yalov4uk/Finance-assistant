package com.perfect.team.common.api.client;

import com.perfect.team.common.api.rest.TransferResource;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("transfer")
public interface TransferClient extends TransferResource {

}

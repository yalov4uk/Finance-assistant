package com.perfect.team.common.api.client;

import com.perfect.team.common.api.rest.ConfirmationResource;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("confirmation")
public interface ConfirmationClient extends ConfirmationResource {

}

package com.perfect.team.legacy.client;

import com.perfect.team.common.client.config.CommonClientConfig;
import com.perfect.team.legacy.api.CategoryResource;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "category", configuration = CommonClientConfig.class)
public interface CategoryClient extends CategoryResource {

}

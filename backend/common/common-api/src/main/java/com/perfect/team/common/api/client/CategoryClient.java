package com.perfect.team.common.api.client;

import com.perfect.team.common.api.rest.CategoryResource;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("category")
public interface CategoryClient extends CategoryResource {

}

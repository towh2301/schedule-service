package com.shadcn.scheduleservice.repository.httpClient;

import org.springframework.cloud.openfeign.FeignClient;

import com.shadcn.scheduleservice.configuration.AuthenticationRequestInterceptor;
import com.shadcn.scheduleservice.exception.RetreiveMessageErrorDecoder;

@FeignClient(
        name = "course",
        url = "${app.services.course}",
        configuration = {AuthenticationRequestInterceptor.class, RetreiveMessageErrorDecoder.class})
public interface CourseClient {}

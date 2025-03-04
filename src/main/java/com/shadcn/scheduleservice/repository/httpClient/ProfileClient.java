package com.shadcn.scheduleservice.repository.httpClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.shadcn.scheduleservice.configuration.AuthenticationRequestInterceptor;
import com.shadcn.scheduleservice.dto.response.ApiResponse;
import com.shadcn.scheduleservice.dto.response.StudentProfileResponse;
import com.shadcn.scheduleservice.dto.response.TeacherProfileResponse;
import com.shadcn.scheduleservice.exception.RetreiveMessageErrorDecoder;

@FeignClient(
        name = "profile",
        url = "${app.services.profile}",
        configuration = {AuthenticationRequestInterceptor.class, RetreiveMessageErrorDecoder.class})
public interface ProfileClient {
    @GetMapping(value = "/api/v1/users/students/ids", produces = MediaType.APPLICATION_JSON_VALUE)
    ApiResponse<List<StudentProfileResponse>> getPublicStudentProfile(@RequestParam long[] studentIds);

    @GetMapping(value = "/api/v1/users/teachers/ids", produces = MediaType.APPLICATION_JSON_VALUE)
    ApiResponse<List<TeacherProfileResponse>> getPublicTeacherProfile(@RequestParam long[] teacherIds);

    @GetMapping(value = "/users/students/student-entity-id/{studentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ApiResponse<StudentProfileResponse> getStudentProfileByStudentEntityId(@PathVariable String studentId);
}

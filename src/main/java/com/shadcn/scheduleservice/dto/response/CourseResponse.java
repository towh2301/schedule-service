package com.shadcn.scheduleservice.dto.response;

import java.util.List;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CourseResponse {
    String name;
    String imageUri;
    String code;
    String credit;
    String description;
    String startTime;
    String endTime;
    String startDate;
    String endDate;
    List<String> teacherIds;
    List<String> studentIds;
    List<DepartmentResponse> departments;
    //    List<LessonResponse> lessons;
    //    List<SemesterResponse> semesters;
    //    List<EnrollmentResponse> enrollments;
    //    List<TeacherReferenceResponse> teacherReferences;
}

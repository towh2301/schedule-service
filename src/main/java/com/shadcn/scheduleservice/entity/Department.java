package com.shadcn.scheduleservice.entity;

import java.util.List;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Department extends BaseEntity {

    String departmentName;

    String departmentCode;

    @ElementCollection
    @CollectionTable(name = "academic_year_department", joinColumns = @JoinColumn(name = "department_id"))
    @Column(name = "academic_year_id")
    List<Long> academicYearIds;

    //    @ElementCollection
    //    @CollectionTable(
    //            name = "academic_year_department",
    //            joinColumns = @JoinColumn(name = "department_id"))
    //    @Column(name = "academic_year_id")
    //    List<Long> academicYearIds;

    @ManyToMany
    @JoinTable(
            name = "department_course",
            joinColumns = @JoinColumn(name = "department_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    @JsonManagedReference
    List<Course> courses;

    @ManyToMany
    @JoinTable(
            name = "department_basecourse",
            joinColumns = @JoinColumn(name = "department_id"),
            inverseJoinColumns = @JoinColumn(name = "base_course_id"))
    @JsonManagedReference
    List<BaseCourse> baseCourses;

    //    @ManyToMany(mappedBy = "departments")
    //    private List<BaseCourse> baseCourses;
}

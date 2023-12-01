package com.example.demo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;

    @Override
    public void initialize(CourseCode courseCode) {
        coursePrefix = courseCode.value();
    }

    @Override
    public boolean isValid(String thecourseCode, ConstraintValidatorContext context) {
        boolean result;
        if (thecourseCode != null) {
            result = thecourseCode.startsWith(coursePrefix);
        } else {
            result = true;
        }
        return result;

    }

}

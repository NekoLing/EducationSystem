package com.education.educationsystme;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com/education/educationsystme/system/mapper","com/education/educationsystme/course/mapper"})
public class EducationSystmeApplication {

    public static void main(String[] args) {
        SpringApplication.run(EducationSystmeApplication.class, args);
    }

}

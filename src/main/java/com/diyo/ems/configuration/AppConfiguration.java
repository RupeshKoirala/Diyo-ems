package com.diyo.ems.configuration;

import com.diyo.ems.model.Project;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean(name = "proj")
    public Project getProject(){
        Project project = Project.builder()
                .name("Online Banking")
                .duration(12)
                .domain("Banking")
                .budget(20000.0)
                .build();
        System.err.println("Inside project bean creation..."+project);
        return project;
    }
}

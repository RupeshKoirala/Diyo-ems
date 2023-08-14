package com.diyo.ems.model;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class Project {
    private String name;
    private String domain;
    private Integer duration;
    private Double budget;

    public void display(){
        System.out.println(this);
    }

    /*public static void main(String[] args) {
        //Project project = new Project();
        Project project = Project.builder()
                .name("Online Banking")
                .duration(6)
                .build();
        System.err.println(project);
    }*/

    /*public Project() {
    }

    public Project(String name, String domain, Integer duration, Double budget) {
        this.name = name;
        this.domain = domain;
        this.duration = duration;
        this.budget = budget;
    }*/

    /*public Project(String name) {
        this.name = name;
    }

    public Project(String name, String domain) {
        this.name = name;
        this.domain = domain;
    }

    public Project(String name, Double budget) {
        this.name = name;
        this.budget = budget;
    }*/
}

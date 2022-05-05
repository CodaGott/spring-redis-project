package io.spring.redis.model;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String emailId;
    private Integer age;
}

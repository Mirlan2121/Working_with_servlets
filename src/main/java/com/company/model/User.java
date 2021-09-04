package com.company.model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class User {
    private Long id;
    private String login;
    private String password;
}

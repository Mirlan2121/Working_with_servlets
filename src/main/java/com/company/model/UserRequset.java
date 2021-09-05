package com.company.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequset {
    private Long id;
    private Date timeLogs;
    private User userRequest;
}
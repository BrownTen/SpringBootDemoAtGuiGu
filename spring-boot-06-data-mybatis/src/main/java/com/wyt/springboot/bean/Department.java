package com.wyt.springboot.bean;

import lombok.*;
import lombok.experimental.Accessors;

@NoArgsConstructor
@Setter
@Getter
@Accessors(chain = true)
@ToString
public class Department {
    private Integer id;
    private String departmentName;
}

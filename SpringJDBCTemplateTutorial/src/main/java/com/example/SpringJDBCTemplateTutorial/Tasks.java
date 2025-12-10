package com.example.SpringJDBCTemplateTutorial.JDBC_Template;

import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Tasks {
    @Id
    private int id;
    private String name;
    private boolean completed;
}

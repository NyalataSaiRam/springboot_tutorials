package com.example.SpringJDBCTemplateTutorial;

import java.util.List;

public interface TaskRepo {
    void create(Tasks tasks);
    List<Tasks> getALl();
    void update(Tasks tasks);
    void delete(int id);
    void deleteAll();
}

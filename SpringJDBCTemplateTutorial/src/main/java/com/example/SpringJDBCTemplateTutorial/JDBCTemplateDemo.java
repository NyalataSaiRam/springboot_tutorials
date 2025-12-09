package com.example.SpringJDBCTemplateTutorial;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class JDBCTemplateDemo implements TaskRepo {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public void create(Tasks tasks) {
        String c = "insert into tasks (name, completed) values (?, ?)";
        jdbcTemplate.update(c, tasks.getName(), tasks.isCompleted());
    }

    @Override
    public List<Tasks> getALl() {
        String g = "select * from tasks";
        BeanPropertyRowMapper<Tasks> bprm = new BeanPropertyRowMapper<>(Tasks.class);
        List<Tasks> tasks = jdbcTemplate.query(g, bprm);
        return tasks;
    }

    @Override
    public void update(Tasks tasks) {
        String c = "update tasks set name=?, completed=? where id=?";
        jdbcTemplate.update(c, tasks.getName(), tasks.isCompleted(), tasks.getId());
    }

    @Override
    public void delete(int id) {
        String c = "delete from tasks where id=?";
        jdbcTemplate.update(c,id);
    }

    @Override
    public void deleteAll() {
        String c = "truncate table tasks";
        jdbcTemplate.execute(c);
    }
}

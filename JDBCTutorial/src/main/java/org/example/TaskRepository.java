package org.example;

import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    private static DataSource getDataSource(){
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl("jdbc:h2:./todos;AUTO_SERVER=TRUE");
        return hikariDataSource;
    }

    public static void create(Task task) throws Exception{
        try (Connection connection = getDataSource().getConnection()) {
            String iq = "insert into task (name) values (?)";
            PreparedStatement ps = connection.prepareStatement(iq);
            ps.setString(1, task.getName());
            ps.execute();
        }
    }

    public static List<Task> getAll() throws Exception{
        try (Connection connection = getDataSource().getConnection()) {
            List<Task> list = new ArrayList<>();
            String sq = "select * from task";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sq);

            while(rs.next()){
                Task t = new Task(rs.getInt(1), rs.getString(2));
                list.add(t);
            }

            return list;
        }
    }

    public static void update(Task task) throws Exception{
        try (Connection connection = getDataSource().getConnection()) {
            String us = "update task set name=? where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(us);
            preparedStatement.setInt(2, task.getId());
            preparedStatement.setString(1, task.getName());
            preparedStatement.execute();
        }
    }

    public static void delete(Task task) throws Exception{
        try (Connection connection = getDataSource().getConnection()) {
            String ds = "delete from task where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(ds);
            preparedStatement.setInt(1, task.getId());
            preparedStatement.execute();
        }
    }

    public static void deleteAll() throws Exception{
        try (Connection connection = getDataSource().getConnection()) {
            String ds = "delete from task";
            Statement statement = connection.createStatement();
            statement.execute(ds);
        }
    }
}

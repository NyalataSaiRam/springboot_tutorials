package org.example;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:h2:./todos;AUTO_SERVER=TRUE");

//        String createTableQuery = "create table if not exists task (id identity primary key, name varchar )";
        Statement statement = connection.createStatement();
//        statement.execute(createTableQuery);
//
//        String insertQuery = "insert into task (name) values (?)";
//        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
//        preparedStatement.setString(1, "sai");
//        preparedStatement.execute();

//        creating table Task
//        statement.execute("create table if not exists task (id identity primary key, name varchar)");

//        inserting into TASK
//        String insertQuery = "insert into task (name) values (?)";
//        PreparedStatement ps = connection.prepareStatement(insertQuery);
//        ps.setString(1, "dinesh");
//        ps.execute();


//        retrieing data
//        ResultSet resultSet = statement.executeQuery("select * from task");
//        while(resultSet.next()){
//            System.out.println(resultSet.getString(1)+" "+resultSet.getString(2));
//        }

//        updating data
//        String updateStatement = "update task set name=? where id=? ";
//        PreparedStatement preparedStatement = connection.prepareStatement(updateStatement);
//        preparedStatement.setString(1, "ramesh");
//        preparedStatement.setInt(2, 3);
//        preparedStatement.execute();

//        deleting data
//        statement.execute("delete from task where id=3");


    }
}
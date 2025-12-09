package com.example.SpringJDBCTemplateTutorial;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringJdbcTemplateTutorialApplication implements CommandLineRunner {

    private final JDBCTemplateDemo jdbcTemplateDemo;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcTemplateTutorialApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {


//        insert new row
//        jdbcTemplateDemo.create(Tasks.builder().name("go to sleep").completed(false).build());

//        read rows
//        List<Tasks> all = jdbcTemplateDemo.getALl();
//            System.out.println(t);
//        for(Tasks t : all){
//        }

//        update
//        jdbcTemplateDemo.update(Tasks.builder().id(2).name("goto school").completed(true).build());
//        List<Tasks> all = jdbcTemplateDemo.getALl();
//        for(Tasks t : all){
//            System.out.println(t);
//        }

//        delete
//        jdbcTemplateDemo.delete(2);
//        List<Tasks> all = jdbcTemplateDemo.getALl();
//        for(Tasks t : all){
//            System.out.println(t);
//        }

//        delete all
//        jdbcTemplateDemo.deleteAll();
//        List<Tasks> all = jdbcTemplateDemo.getALl();
//        for(Tasks t : all){
//            System.out.println(t);
//        }

    }
}

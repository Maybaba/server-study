package com.jsp.chap05;

import java.util.List;

public class Test {
    public static void main(String[] args) {

        JdbcBasic jdbc = new JdbcBasic();

//        jdbc.insert(new Person(99, "고길동", 30));
//        jdbc.insert(new Person(200, "박박북", 20));
//        jdbc.insert(new Person(11, "벽벽벽", 10));

        //jdbc.delete(200);

//        List<Person> people = jdbc.findAll();

//        System.out.println("people = " + people);

        jdbc.findAll();
    }
}

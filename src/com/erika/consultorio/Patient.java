package com.erika.consultorio;

import java.util.StringTokenizer;

public class Patient {
    public Patient(String s) {

        //Pattern is id|name|age|date
        // initializer our tokenizer
        StringTokenizer st = new StringTokenizer(s, "|");
        // set the values
        this.setStudentid(st.nextToken());
        this.setName(st.nextToken());
        this.setAge(st.nextToken());
        this.setDate(st.nextToken());

    }

    public Patient() {
        super();
    }

    String name;
    String age;
    String date;
    String studentid;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }


}

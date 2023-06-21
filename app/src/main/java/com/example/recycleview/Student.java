package com.example.recycleview;




public class Student {

    private  int id;
    private String name;
    private String age;
    private String clas;


    public Student(int id, String name, String age, String clas) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.clas = clas;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public String getClas(){
        return  this.clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", clas=" + clas + "]";
    }

}
package model;

public class Student {
    private int id;
    private  String name;
    private String major;//profil

    public  Student(int id,String name,String major){
        this.id=id;
        this.name=name;
        this.major=major;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public  String toString(){
        String text="";
        text+=id+","+name+","+major;
        return  text;
    }

    @Override
    public  boolean equals(Object obj){
        Student student=(Student)  obj;
        return  student.major==this.major;
    }
}

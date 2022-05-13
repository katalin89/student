package repository;

import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private String JdbURL = "jdbc:mysql://localhost:3306/exemplu";
    private String username = "root";
    private String password = "root";
    private Connection connection = null;
    private Statement statement = null;

    public StudentRepository() {
        try {
            connection = DriverManager.getConnection(JdbURL, username, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("eroare conectare de baza de date");
        }
    }

    private void executeStatement(String execute) {
        try {
            statement.execute(execute);
        } catch (SQLException exc) {
            System.out.println("Nu am reusit" + execute);
        }
    }

    public void insertStudent(Student student) {
        String insertTo = "";
        insertTo += "insert into student";
        insertTo += "(name,major)";
        insertTo += "values(";
        insertTo += String.format("'%s','%s'", student.getName(), student.getMajor());
        insertTo += ")";
        executeStatement(insertTo);
    }

    public void stergeStudentById(int id) {
        String text = String.format("delete from student where student_id= %d", id);
        executeStatement(text);
    }

    public void updateMajor(String name, String major) {
        String update = String.format("update student set major='%s' where name='%s'", major, name);
        executeStatement(update);
    }

    public void deletNume(String name) {
        String delete = String.format("delete from student where name='%s'", name);
        executeStatement(delete);
    }

    private ResultSet allStudent() {
        executeStatement("select * from student");
        try {
            return statement.getResultSet();
        } catch (Exception e) {
            System.out.println("Nu sa executat schita");
            return null;
        }
    }


    public List<Student>allaStudents(){
        ResultSet set= allStudent();
        List<Student>students=new ArrayList<>();
        try{
            while(set.next()){
                students.add(new Student(set.getInt(1),set.getString(2),set.getString(3)));
            }
        }catch (Exception e){
            System.out.println("Nu s-a creat lista");
        }
        return  students;
    }
}

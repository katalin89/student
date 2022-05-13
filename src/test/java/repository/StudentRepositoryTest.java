package repository;

import model.Student;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryTest {

    @Test
    public void insertStudent() {
        StudentRepository studentRepository = new StudentRepository();
        Student student = new Student(1, "Gabriela", "Matematica");
        studentRepository.insertStudent(student);
    }

    @Test
    public void stergeById() {
        StudentRepository studentRepository = new StudentRepository();
        int id = 8;
        studentRepository.stergeStudentById(id);
    }

    @Test
    public void updateMajor() {
        StudentRepository studentRepository = new StudentRepository();
       studentRepository.updateMajor("Zoe","test");
    }



    @Test
    public void deleteNume() {
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.deletNume("Zoe");
    }

    @Test
    public void allStudents() {


        StudentRepository studentRepository = new StudentRepository();
        List<Student>students=studentRepository.allaStudents();
        for(Student s:students){
            System.out.println(s.toString());
        }
    }
}
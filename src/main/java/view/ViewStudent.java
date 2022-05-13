package view;

import model.Student;
import repository.StudentRepository;

import java.util.List;
import java.util.Scanner;

public class ViewStudent {
    private StudentRepository studentRepository;

    public ViewStudent(){
        studentRepository=new StudentRepository();
    }

    public  void meniu(){
        System.out.println("Apasa tasta 1 pentru a afisa toti studentii din baza de date");
        System.out.println("Apasa tasta 2 pentru a insera un studnet nou in baza de date");
        System.out.println("Apasa tasta 3 pentru a sterge un student din baza de date");
        System.out.println("Apasa tasta 4 pentru a schimba profilul studentului ");
        System.out.println("Apasa tasta 5 pentru a sterge un student dupa nume din baza de date");
    }

    public  void  play(){
        Scanner scanner=new Scanner(System.in);
        boolean run=true;
        int alegere=0;
        while(run=true){
            meniu();
            alegere=Integer.parseInt(scanner.nextLine());
            switch ( alegere){
                case 1 :showStudets();
                break;
                case 2:insertStudent();
                break;
                case 3:stergeUnStudent();
                break;
                case 4:updateMajor();
                break;
                case 5:stergeUnStudentNume();
                break;

            }
        }
    }


    public void showStudets(){
        List<Student> students=studentRepository.allaStudents();
        for(Student s:students){
            System.out.println(s.toString());
        }
    }

    public  void insertStudent(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Introduceti id");
        int id=Integer.parseInt(scanner.nextLine());
        System.out.println("Introduceti numele studentului");
        String name=scanner.nextLine();
        System.out.println("Introduceti profilul studentului");
        String major=scanner.nextLine();

        Student student=new Student(id,name,major);
        studentRepository.insertStudent(student);

    }


    public  void stergeUnStudent(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Introduceti id ul studentului pe care doriti s-l sterget");
        int id=Integer.parseInt(scanner.nextLine());
        studentRepository.stergeStudentById(id);
        System.out.println("Student s-a sters");

    }

    public  void updateMajor(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Introduceti numele studentului carui dorit sa modificati profilul");
        String name=scanner.nextLine();
        System.out.println("Introduceti major nou");
       String major=scanner.nextLine();
        studentRepository.updateMajor(name,major);

    }


    public  void  stergeUnStudentNume(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Itroduceti numele studentului care doriti sa-l stergeti");
        String name=scanner.nextLine();
        studentRepository.deletNume(name);
    }
}

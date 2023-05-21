package sql_operations;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class App{

    static {
        try {
            //Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
//        addStudent(21445678, "John Smith", "Computer Science");
//        System.out.println(searchStudent(21345678));
//        deleteStudent(2134568);
//        updateMajor(21345678, "Radiology");
//        listStudentsByName("John");
//        listAll();
//        listByMajor("Computer Science");
//        insertAll("src/sql_operations/sampleData.csv");
        Scanner input = new Scanner(System.in);
        int student_cwid;
        String student_name;
        String student_major;

        System.out.println("Welcome to SQL operation center!!!!");
        System.out.println("""
                            
                            Please choose the action you want to perform:
                            
                            1. Retrieve Student Information with CWID
                            2. Retrieve Student Information with Name
                            3. List Students based on Major
                            4. Add new Student
                            5. Update Major of the student
                            6. Delete Student Information
                            7. List all available Student
                            8. Insert Student data from csv file
                            """);
        System.out.print("Enter the operation number: ");
        int operationNum = input.nextInt();
        input.nextLine();
        System.out.println();

        switch (operationNum) {
            case 1 :
                System.out.print("Enter Student's CWID: ");
                student_cwid = input.nextInt();
                System.out.printf("%-10s %-20s %-20s ","cwid","Name", "Major");
                System.out.println(searchStudent(student_cwid));
                break;
            case 2:
                System.out.print("Enter Student's name: ");
                student_name = input.nextLine();
                System.out.printf("%-10s %-20s %-20s ","cwid","Name", "Major");
                listStudentsByName(student_name);
                break;
            case 3:
                System.out.print("Enter Student's major: ");
                student_major = input.nextLine();
                System.out.printf("%-10s %-20s %-20s ","cwid","Name", "Major");
                listByMajor(student_major);
                break;
            case 4:
                System.out.print("Enter students CWID: ");
                student_cwid = input.nextInt();
                input.nextLine();
                System.out.print("Enter Student's name: ");
                student_name = input.nextLine();
                System.out.print("Enter student's major: ");
                student_major = input.nextLine();
                addStudent(student_cwid, student_name, student_major);
                break;
            case 5:
                System.out.print("Enter the cwid of the student: ");
                student_cwid = input.nextInt();
                System.out.print("Enter new major of the student: ");
                student_major = input.nextLine();
                updateMajor(student_cwid, student_major);
                break;
            case 6:
                System.out.print("Enter CWID of student you want to delete: ");
                student_cwid = input.nextInt();
                deleteStudent(student_cwid);
            case 7:
                System.out.printf("%-10s %-20s %-20s ","cwid","Name", "Major");
                listAll();
                break;
            case 8:
                System.out.print("Enter file name: ");
                String file = input.nextLine();
                insertAll(file);
                break;
            default:
                System.out.println("Please choose a valid option number.");
                break;
        }
    }

    public static void addStudent (int id, String name, String major){
        Students s = new Students(id, name, major);
        try {
            s.connect();
            s.save(s.getCwid(), s.getName(), s.getMajor());
            System.out.println("Student added successfully to the database!");
            s.disconnect();
        } catch (Exception e){
            System.out.println("Unable to add student. Please try again!");
        }
    }
    public static String searchStudent (int id) throws SQLException {
        Students s = new Students(id);
        s.connect();
        String info = s.findStudentName(s.getCwid());
        s.disconnect();
        return info;
    }

    public static void deleteStudent(int id) {
        Students s = new Students(id);
        s.connect();
        s.delete(s.getCwid());
        s.disconnect();
    }

    public static void updateMajor(int id, String major){
        Students s = new Students(id, major);
        s.connect();
        s.update(id, major);
        s.disconnect();
    }

    public static void listStudentsByName (String name){
        Students s = new Students();
        s.setName(name);
        s.connect();
        ArrayList<String> result = s.findStudentId(s.getName());
        s.disconnect();
        result.forEach(System.out::println);
    }

    public static void listAll (){
        Students s = new Students();
        s.connect();
        ArrayList<String> result = s.listAll();
        s.disconnect();
        result.forEach(System.out::println);
    }

    public static void listByMajor(String major){
        Students s = new Students();
        s.setMajor(major);
        s.connect();
        ArrayList<String> result = s.listByMajor(s.getMajor());
        s.disconnect();
        result.forEach(System.out::println);
    }

    public static void insertAll(String file){
        Students s = new Students();
        s.connect();
        s.insertAll(file);
        s.disconnect();
    }
}
package lambda_expressions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/** This class demonstrates an example of overriding Comparable class to get desired behaviour and then sorts
 * the object based on the compareTo method. This class also shows how to override toString method to display
 * specific information rather than the address of the object. Finally, an example method reference and lambda
 * expression is used to print information for the student;
 */
public class Student implements Comparable<Student>{
    private String name;
    private int age;

    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public int getAge () {
        return age;
    }

    @Override
    public int compareTo(Student other) {
        return String.CASE_INSENSITIVE_ORDER.compare(this.name, other.name);
    }

    @Override
    public String toString() {
        return name + "\t" + age;
    }

    public static void main (String[] args) {
        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student("Dharmendra", 23));
        studentList.add(new Student("John", 21));
        studentList.add(new Student("Adam", 25));

        Collections.sort(studentList);

        studentList.forEach(student -> System.out.print(student.getName() + "\t" + student.getAge() + "\n"));

        studentList.forEach(System.out::println);
    }
}
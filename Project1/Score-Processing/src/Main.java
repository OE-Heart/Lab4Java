import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

class Student {
    private String id;
    private String name;
    private double scoreSum;
    private int takenCourseNum;
    
    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.scoreSum = 0;
        this.takenCourseNum = 0;
    }
    
    public Student(String id) {
        this.id = id;
        this.scoreSum = 0;
        this.takenCourseNum = 0;
    }

    public double getAverage() {
        return scoreSum/takenCourseNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTakenCourseNum() {
        return takenCourseNum;
    }

    public void addScoreSum(double score) {
        scoreSum += score;
    }

    public void addTakenCourseNum() {
        takenCourseNum += 1;
    }
}

class Course {
    private String name;
    private HashMap<String, Double> studentScore;

    public Course(String name) {
        this.name = name;
        this.studentScore = new HashMap<>();
    }

    public HashMap<String, Double> getStudentScore() {
        return studentScore;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        HashMap<String,Student> StudentMap = new HashMap<>();
        HashMap<String,Course> CourseMap = new HashMap<>();
        
        Scanner in = new Scanner(System.in);
        while (true) {
            String[] s = in.nextLine().split(", ");
            if (s.length == 1 && s[0].equals("END")) break;
            else if (s.length == 2) { // <student id>, <name>
                if (StudentMap.containsKey(s[0])) {
                    StudentMap.get(s[0]).setName(s[1]);
                }
                else {
                    StudentMap.put(s[0], new Student(s[0], s[1]));
                }
            }
            else if (s.length == 3) { // <student id>, <course name>, <marks>
                if (!StudentMap.containsKey(s[0])) {
                    StudentMap.put(s[0], new Student(s[0]));
                }

                if(!CourseMap.containsKey(s[1])) {
                    CourseMap.put(s[1], new Course(s[1]));
                }

                Student t = StudentMap.get(s[0]);
                Course c = CourseMap.get(s[1]);

                double score = Double.parseDouble(s[2]);

                t.addScoreSum(score);
                t.addTakenCourseNum();
                c.getStudentScore().put(s[0], score);
            }
        }
        in.close();

        LinkedList<String> StudentList = new LinkedList<>(StudentMap.keySet());
        LinkedList<String> CourseList = new LinkedList<>(CourseMap.keySet());
        Collections.sort(StudentList);
        Collections.sort(CourseList);

        System.out.print("student id, name");
        for (String name: CourseList) {
            System.out.print(", "+name);
        }
        System.out.println(", average");

        for (String id: StudentList) {
            Student t = StudentMap.get(id);
            System.out.print(id+", "+ t.getName());
            for (String name: CourseList) {
                System.out.print(", ");
                if (CourseMap.get(name).getStudentScore().get(id) != null) {
                    System.out.print(String.format("%.1f", CourseMap.get(name).getStudentScore().get(id)));
                }
            }
            System.out.print(", ");
            if (t.getTakenCourseNum() != 0) {
                System.out.print(String.format("%.1f", t.getAverage()));
            }
            System.out.println();
        }
    }
}
import java.util.Scanner;
class Student {
    int roll_no;
    void getRollNo(int r) {
        roll_no = r;
    }
    void displayRollNo() {
        System.out.println("Roll No: " + roll_no);
    }
}
class Test extends Student {
    int sub1, sub2;
    void getMarks(int m1, int m2) {
        sub1 = m1;
        sub2 = m2;
    }
    void displayMarks() {
        System.out.println("Marks in Subject 1: " + sub1);
        System.out.println("Marks in Subject 2: " + sub2);
    }
}
class Result extends Test {
    void displayResult() {
        int total = sub1 + sub2;
        System.out.println("Total Marks: " + total);
    }
}
public class MultilevelInheritanceDemo{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Result student = new Result();
        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();
        student.getRollNo(roll);
        System.out.print("Enter Marks for Subject 1: ");
        int m1 = sc.nextInt();
        System.out.print("Enter Marks for Subject 2: ");
        int m2 = sc.nextInt();
        student.getMarks(m1, m2);
        System.out.println("\n--- Student Details ---");
        student.displayRollNo();
        student.displayMarks();
        student.displayResult();
        sc.close();
    }
}
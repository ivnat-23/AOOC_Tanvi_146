class Student {
    private int rollNo;
    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
    public int getRollNo() {
        return rollNo;
    }
}
class Test extends Student {
    protected int sub1, sub2;
    public void setMarks(int m1, int m2) {
        sub1 = m1;
        sub2 = m2;
    }
    public void getMarks() {
        System.out.println("Marks in Subject 1: " + sub1);
        System.out.println("Marks in Subject 2: " + sub2);
    }
}
interface Sports {
    int sMarks = 20;  
    void set();        
}
class Result extends Test implements Sports {
    private int total;
    public void set() {
        total = sub1 + sub2 + sMarks;
    }
    public void displayResult() {
        System.out.println("Roll Number: " + getRollNo());
        getMarks();
        System.out.println("Sports Marks: " + sMarks);
        System.out.println("Total Marks: " + total);
    }
}
public class StudentResult {
    public static void main(String[] args) {
        Result student = new Result();
        student.setRollNo(146);
        student.setMarks(85, 90);
        student.set();  
        System.out.println("---- Student Result ----");
        student.displayResult();
    }
}
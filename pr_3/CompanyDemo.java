class Employee {
    protected String name;
    protected String address;
    protected double salary;
    protected String jobTitle;
    Employee(String name, String address, double salary, String jobTitle) {
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.jobTitle = jobTitle;
    }
    public double calculateBonus() {
        return salary * 0.05;
    }
    public void generatePerformanceReport() {
        System.out.println("Performance Report for " + name);
        System.out.println("Job Title: " + jobTitle);
        System.out.println("Salary: " + salary);
        System.out.println("Bonus: " + calculateBonus());
        System.out.println("----------------------------");
    }
    public void manageProject() {
        System.out.println(name + " is managing general tasks.");
    }
}
class Manager extends Employee {
    Manager(String name, String address, double salary) {
        super(name, address, salary, "Manager");
    }
    public double calculateBonus() {
        return salary * 0.20;  // 20% bonus
    }
    public void manageProject() {
        System.out.println(name + " is managing multiple company projects.");
    }
}
class Developer extends Employee {
    Developer(String name, String address, double salary) {
        super(name, address, salary, "Developer");
    }
    public double calculateBonus() {
        return salary * 0.10;  // 10% bonus
    }
    public void manageProject() {
        System.out.println(name + " is developing software modules.");
    }
}
class Programmer extends Employee {
    Programmer(String name, String address, double salary) {
        super(name, address, salary, "Programmer");
    }
    public double calculateBonus() {
        return salary * 0.08;  // 8% bonus
    }
    public void manageProject() {
        System.out.println(name + " is writing and testing code.");
    }
}
public class CompanyDemo {
    public static void main(String[] args) {
        Manager manager = new Manager("Shreya", "Pune", 80000);
        Developer developer = new Developer("Rahul", "Mumbai", 60000);
        Programmer programmer = new Programmer("Amit", "Delhi", 50000);
        manager.generatePerformanceReport();
        manager.manageProject();
        developer.generatePerformanceReport();
        developer.manageProject();
        programmer.generatePerformanceReport();
        programmer.manageProject();
    }
}
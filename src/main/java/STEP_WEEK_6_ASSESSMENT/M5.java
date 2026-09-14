package STEP_WEEK_6_ASSESSMENT;

public class M5 {
    static class Employee {
        String empName;
        double salary;
        static String companyName = "Bright Horizon Technologies";
        static int employeeCount = 0;

        public Employee(String empName, double salary) {
            this.empName = empName;
            this.salary = salary;
            employeeCount++;
        }

        static void printCompanyInfo() {
            System.out.println(companyName);
            System.out.println("Employees on record: " + employeeCount);
        }
    }
    public static void main(String[] args) {
        Employee e1 = new Employee("Aarav", 55000);
        Employee e2 = new Employee("Priya", 62000);
        Employee e3 = new Employee("Rohan", 48000);

        Employee.printCompanyInfo();
    }
}

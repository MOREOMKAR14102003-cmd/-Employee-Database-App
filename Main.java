import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeDAO dao = new EmployeeDAO();
        Scanner sc = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("\n1. Add | 2. View All | 3. Update Salary | 4. Delete | 0. Exit");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        sc.nextLine();
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("Department: ");
                        String dept = sc.nextLine();
                        System.out.print("Salary: ");
                        double sal = sc.nextDouble();
                        sc.nextLine();
                        dao.addEmployee(new Employee(0, name, dept, sal));
                        break;

                    case 2:
                        List<Employee> emps = dao.getAllEmployees();
                        emps.forEach(System.out::println);
                        break;

                    case 3:
                        System.out.print("Employee ID: ");
                        int id = sc.nextInt();
                        System.out.print("New Salary: ");
                        double newSal = sc.nextDouble();
                        dao.updateEmployeeSalary(id, newSal);
                        break;

                    case 4:
                        System.out.print("Employee ID to delete: ");
                        int delId = sc.nextInt();
                        dao.deleteEmployee(delId);
                        break;

                    case 0:
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid option.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

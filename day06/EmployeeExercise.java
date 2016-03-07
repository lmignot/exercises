import java.util.Scanner;public class EmployeeExercise { public static void main(String[] args) {
        //

        Exercise emp = new Exercise();
        emp.getEmployees();
        emp.printEmployees();
    }
    static public class Exercise {
        private int[] employeeIds;
        private String[] employeeNames;
        private int numEmployees = 10;
        public Exercise () {
            employeeIds = new int[numEmployees];
            employeeNames = new String[numEmployees];
        }
        public void getEmployees () {
            for (int i = 0; i < numEmployees; i++) {
                System.out.println("Enter an employee ID:");
                int id = Integer.parseInt(readLine());
                System.out.println("And their name:");
                String str = readLine();
                employeeIds[i] = id;
                employeeNames[i] = str;
            }
        }
        public void printEmployees () {
            for (int i = 0; i < numEmployees; i++) {
                System.out.println("Employee id: " + employeeIds[i] + ", name: " + employeeNames[i]);
            }
        }
    }

    private static Scanner __input = new Scanner(System.in);

    public static String readLine()  { return __input.nextLine(); }

    public static int    readInt()   { return Integer.parseInt(readLine());  }

    public static double readdouble(){ return Double.parseDouble(readLine());}

}
public class E07_Big_Enough {

    public static void main (String[] args) {
        Employees employees = new Employees();

        boolean done = false;
        String name;
        int id;

        while (!done) {
            System.out.println("Enter the id:");
            id = Integer.parseInt(System.console().readLine());
            System.out.println("Enter the name:");
            name = System.console().readLine();

            if (id == 0 || name.length() == 0) {
                done = true;
            } else {
                employees.add(id, name);
            }
        }

        if (employees.count() > 0) {
            employees.prettyPrint();
        }
    }
}

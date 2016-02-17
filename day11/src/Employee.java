/**
 * PiJ Day 11 - exercise 4
 */
public class Employee implements Comparable<Employee> {
    private Integer id;
    private String name;

    public Employee (int id, String name) {
        this.id = id;
        this.name = name;
        System.out.println("using int constructor");
    }

    public Employee (Integer id, String name) {
        this.id = id;
        this.name = name;
        System.out.println("using Integer constructor");
    }

    public String getName () {
        return this.name;
    }

    @Override
    public int compareTo(Employee o) {
        return o.id.compareTo(this.id);
    }
}

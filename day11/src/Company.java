/**
 * PiJ Day 11 - exercise 3
 */

import DataStructures.List;
import DataStructures.SortedList;

public class Company {

    private List<Employee> employeeNames;
    private List<NiNumber> employeeNiNumbers;
    private int curIndex;

    public Company () {
        this.employeeNames = new SortedList<>();
        this.employeeNiNumbers = new SortedList<>();
        this.curIndex = -1;
    }

    public int getListSize () {
        return this.curIndex + 1;
    }

    public void addEmployee (String name, String ni) {
        this.employeeNames.add(new Employee(this.curIndex, name));
        this.employeeNiNumbers.add(new NiNumber(this.curIndex, ni));
        this.curIndex++;
    }

    public void removeEmployee (String name, String ni) {

    }

    public void prettyPrint () {
        if (this.curIndex == (-1)) {
            return;
        }
        String out;
        for (int i = 0; i <= this.curIndex; i++) {
            out = this.employeeNames.get(i).getName();
            out += ", " + this.employeeNiNumbers.get(i).getNi();
            System.out.println(out);
        }
    }
}

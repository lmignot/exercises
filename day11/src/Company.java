/**
 * PiJ Day 11 exercise 3
 */

import DataStructures.LinkedList;
import DataStructures.List;
import DataStructures.SortedList;

public class Company {

    private List<String> employeeNames;
    private List<String> employeeNiNumbers;
    private int curIndex;

    public Company () {
        this.employeeNames = new SortedList<>();
        this.employeeNiNumbers = new LinkedList<>();
        this.curIndex = -1;
    }

    public int getListSize () {
        return this.curIndex + 1;
    }

    public void addEmployee (String name, String ni) {
        this.employeeNames.add(name);
        this.employeeNiNumbers.add(ni);
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
            out = this.employeeNames.get(i);
            out += ", " + this.employeeNiNumbers.get(i);
            System.out.println(out);
        }
    }
}

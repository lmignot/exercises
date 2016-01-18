/**
 * Created by lmignot on 18/01/2016.
 */

import DataStructures.LinkedList;
import DataStructures.List;

public class Company {

    private List<String> employeeNames;
    private List<String> employeNiNumbers;
    private int curIndex;

    public Company () {
        this.employeeNames = new LinkedList<>();
        this.employeNiNumbers = new LinkedList<>();
        this.curIndex = -1;
    }

    public int getListSize () {
        return this.curIndex + 1;
    }

    public void addEmployee (String name, String ni) {
        this.employeeNames.add(name);
        this.employeNiNumbers.add(ni);
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
            out += ", " + this.employeNiNumbers.get(i);
            System.out.println(out);
        }
    }
}

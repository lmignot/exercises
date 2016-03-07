public class Calculator {

    public int add (int numA, int numB) {
        return numA + numB;
    }

    public int subtract (int numA, int numB) {
        return numA - numB;
    }

    public int multiply (int numA, int numB) {
        return numA * numB;
    }

    public double divide (int numA, int numB) {
        double numADbl = (double) numA;
        double numBDbl = (double) numB;

        return numADbl / numBDbl;
    }
}

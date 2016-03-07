
import java.util.Scanner;

public class E07_more_double_practice { 
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
            //

            System.out.println("Enter the mortgage cost: ");
        double cost = Double.parseDouble(input.nextLine());
        System.out.println("Enter the length of the mortgage term in years (eg 25): ");
        int years = Integer.parseInt(input.nextLine());
        System.out.println("Finally, enter the rate of interest (eg 4.5): ");
        double interestRate = Double.parseDouble(input.nextLine());
        int totalCost = (int) Math.ceil(calculateTotalCost(cost, interestRate));
        int annualCost = (int) Math.ceil(calculateAnnualCost(totalCost, years));
        int yearsUntilPaid = (int) Math.ceil(calculateYearsUntilInterestPaid(cost, totalCost, annualCost));
        System.out.println("The total amount to pay is: " + totalCost);
        System.out.println("The annual payments will total: " + annualCost);
        System.out.println("Assuming all interest is paid off first, the interest will be paid within " + yearsUntilPaid + " year(s)");
    }

    private static double calculateTotalCost(double cost, double rate) {
        return cost * (1.0 + rate / 100);
    }

    private static double calculateAnnualCost(double cost, int years) {
        return cost / (years * 1.0);
    }

    private static double calculateTotalInterest(double cost, double totalCost) {
        return totalCost - cost;
    }

    private static double calculateYearsUntilInterestPaid(double cost, double totalCost, double annualCost) {
        double totalInterest = calculateTotalInterest(cost, totalCost);
        double years = annualCost / totalInterest;
        return years;
    }
}
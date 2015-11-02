public class E01_calculate {

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println("Testing addition:");
        System.out.println("225 + 456 = " + calc.add(225, 456));
        System.out.println("2 + 2 = " + calc.add(2, 2));
        System.out.println("Testing subtraction:");
        System.out.println("8 - 4 = " + calc.subtract(8, 4));
        System.out.println("1024 - 512 = " + calc.subtract(1024, 512));
        System.out.println("Testing multiplication:");
        System.out.println("9 x 4 = " + calc.multiply(9, 4));
        System.out.println("2 x 512 = " + calc.multiply(2, 512));
        System.out.println("Testing division:");
        System.out.println("45 / 5 = " + calc.divide(45, 5));
        System.out.println("8 / 4 = " + calc.divide(8, 4));
    }

}

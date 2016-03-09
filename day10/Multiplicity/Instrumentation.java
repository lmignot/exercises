package Multiplicity;

public class Instrumentation {

    public static void main (String[] args) {
        Instrumentation test = new Instrumentation();
        test.launch();
    }

    public void launch () {
        Guitar gibson = new Guitar("Gibson");

        System.out.println("Should play a song...");
        gibson.play("Hey Jude");

        System.out.println("Should burn...");
        gibson.burn();

        System.out.print("Type should be a Guitar... ");
        System.out.println(gibson.getType().equals("Guitar") ? "passed." : "failed.");

        System.out.print("Brand should be a Gibson... ");
        System.out.println(gibson.getBrand().equals("Gibson") ? "passed." : "failed.");
    }

}

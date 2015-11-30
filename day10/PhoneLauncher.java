public class PhoneLauncher {

    public static void main (String[] args) {
        PhoneLauncher launcher = new PhoneLauncher();
        launcher.launch();
    }

    public void launch () {
        String brand = "iPhone";
        SmartPhone myPhone = new SmartPhone(brand);

        String[] numbers = new String[] {
            "07565432543", "08004567281", "02190456783",
            "01978546789", "01765849291", "02987109284",
            "07985828228", "09067828281", "07765889191",
            "07556773882", "12098482919", "08456789004",
            "00496971033307", "0033645739827"
        };

        for (int i = 0; i < numbers.length; i++) {
            myPhone.call(numbers[i]);
        }

        System.out.println("");
        System.out.println("Should ring an alarm... ");
        myPhone.ringAlarm("Wake up for work");

        System.out.println("");
        System.out.println("Should play a game... ");
        myPhone.playGame("Snakes 4 Reloaded");

        System.out.println("");
        System.out.println("Should store a log of last 10 numbers called... ");
        myPhone.printCallLog();

        System.out.println("");
        System.out.print("Length of call log should not exceed " + myPhone.callLogMemorySize + "... ");
        System.out.println(myPhone.getLogSize() <= 10 ? "passed." : "failed.");

        System.out.println("");
        System.out.println("Should browse a web address... ");
        myPhone.browseWeb("http://www.bbk.ac.uk");

        System.out.println("");
        System.out.println("Should return current position as coordinates... ");
        System.out.println(myPhone.findPosition());

        System.out.println("");
        System.out.print("Should have the correct brand (" + brand + ")... ");
        System.out.println(myPhone.getBrand().equals(brand) ? "passed." : "failed.");

        SmartPhone myKidsPhone = new RestrictedSmartPhone("S6i");

        System.out.println("");
        System.out.println("Should not play a game on a boring phone...");
        myKidsPhone.playGame("Boom Beach 10 MegaFunVersion");
        System.out.println("Failed as we can't assign weaker access privileges...");
    }
}

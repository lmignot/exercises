public class LecturerTest {

    public static void main (String[] args) {
        LecturerTest test = new LecturerTest();
        test.launch();
    }

    public void launch () {
        String name = "Mik Jagger";
        Lecturer mik = new Lecturer(name);

        System.out.print("Should return the name (" + name + ")... ");
        System.out.println(mik.getName().equals(name) ? "passed." : "failed.");

        System.out.println("");
        System.out.println("Should teach... ");
        mik.teach("Awesome Rockstar Skillz");

        System.out.println("");
        System.out.println("Should do research... ");
        mik.doResearch("How to be awesome ER");
    }
}

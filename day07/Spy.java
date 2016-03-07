public class Spy {
    private static int spyCount = 0;
    private int spyId;

    public Spy (int id) {
        spyCount++;
        spyId = id;
        System.out.println("Initialised new spy with id: " + id);
        System.out.println("Total spies so far: " + spyCount);
    }

    public static int getNumberOfSpies () {
        return spyCount;
    }

    public void die () {
        spyCount--;
        System.out.println("Spy " + this.spyId + " has been detected and eliminated.");
        System.out.println("Total spies remaining: " + spyCount);
    }

    public static void main(String[] args) {
        Spy spy1 = new Spy(1);
        Spy spy2 = new Spy(2);
        Spy spy3 = new Spy(3);
        Spy spy4 = new Spy(4);
        Spy spy5 = new Spy(5);
        Spy spy6 = new Spy(6);
        Spy spy7 = new Spy(7);

        spy3.die();
        spy4.die();
        spy7.die();

        Spy spy8 = new Spy(8);
        Spy spy9 = new Spy(9);
        Spy spy22 = new Spy(22);
    }

}

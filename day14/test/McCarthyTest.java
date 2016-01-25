import org.junit.Test;

/**
 * Created by lmignot on 25/01/2016.
 */
public class McCarthyTest {

    @Test
    public void mcCarthyTest () {
        McCarthy mac = new McCarthy();
        int result = 0;

        System.out.println("--------------------");
        System.out.println("50");
        System.out.println("--------------------");
        result = mac.mcCarthy91(50);
        System.out.println("result: " + result);
        System.out.println("totalLoops: " + mac.getLoops());
        mac.reset();
        System.out.println("");
        System.out.println("--------------------");
        System.out.println("73");
        System.out.println("--------------------");
        result = mac.mcCarthy91(73);
        System.out.println("result: " + result);
        System.out.println("totalLoops: " + mac.getLoops());
        mac.reset();
        System.out.println("");
        System.out.println("--------------------");
        System.out.println("95");
        System.out.println("--------------------");
        result = mac.mcCarthy91(95);
        System.out.println("result: " + result);
        System.out.println("totalLoops: " + mac.getLoops());
        mac.reset();
        System.out.println("");
        System.out.println("--------------------");
        System.out.println("101");
        System.out.println("--------------------");
        result = mac.mcCarthy91(101);
        System.out.println("result: " + result);
        System.out.println("totalLoops: " + mac.getLoops());
        mac.reset();
    }
}

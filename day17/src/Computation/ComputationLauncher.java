package Computation;

/**
 * This class launched two heavy computations
 * sequentially first, then in parallel. 
 * Assuming there is more than one processor in 
 * the machine, parallel computations finish
 * earlier.
 * Example from PiJ
 *
 * @author PiJ
 */
public class ComputationLauncher {   
    /**
     * How many numbers to process? If too low, there is no noticeable
     * difference.
     */
     public static final int COUNT = 40000000;

    /*
     * The computations to be performed. Stored as fields so 
     * both methods (sequential and parallel) act on exactly 
     * the same data
     */
    private Computation c1 = null;
    private Computation c2 = null;
    private Computation c3 = null;
    private Computation c4 = null;

    /**
     * The main method that launches the computations
     *
     * @param args command-line arguments, ignored
     */
    public static void main(String args[]) {
	  ComputationLauncher c = new ComputationLauncher();
	  c.launch();
    }
   
    private double[] createArray(int size) {
	  double[] result = new double[size];
	  for (int i = 0; i < result.length; i++) 
		{
		    result[i] = Math.random();
		}
	  return result;
    }

    // STUDENT COMMENT:
    // AS i have 8 cores, have added more tasks - I haven't gone up to 8 but just
    // doubling the amount of threads used clearly shows the benefit of using threads
    // and letting them run in parallel. average execution time was quartered rather
    // than halved (when using only 2 threads)
    // Ideally would use some mechanism to determine the # of cores and allocate threads
    // accordingly
    private void launch() {
	  // Uncomment the following line to know how many processors your machine has
//	  System.out.println("#CPU: " + Runtime.getRuntime().availableProcessors());
	  long start, stop;
	  c1 = new Computation(createArray(COUNT/4));
	  c2 = new Computation(createArray(COUNT/4));
	  c3 = new Computation(createArray(COUNT/4));
	  c4 = new Computation(createArray(COUNT/4));
	  start = System.currentTimeMillis();
	  sequentialComputations();
	  stop = System.currentTimeMillis();
	  System.out.println("Time without threads: " + (stop - start) + "ms");
	  start = System.currentTimeMillis();
	  parallelComputations();
	  stop = System.currentTimeMillis();
	  System.out.println("Time with threads: " + (stop - start) + "ms");
    }
   
    private void sequentialComputations() {
	  c1.run();
	  c2.run();
	  c3.run();
	  c4.run();
	  double result1 = c1.getResult();
	  double result2 = c2.getResult();
	  double result3 = c3.getResult();
	  double result4 = c4.getResult();
	  System.out.println("Result: " + (result1 + result2 + result3 + result4));
    }
   
    private void parallelComputations() {
	  Thread t1 = new Thread(c1);
	  t1.start();
	  Thread t2 = new Thread(c2);
	  t2.start();
	  Thread t3 = new Thread(c3);
	  t3.start();
	  Thread t4 = new Thread(c4);
	  t4.start();
	  double result1 = c1.getResult();
	  double result2 = c2.getResult();
        double result3 = c3.getResult();
        double result4 = c4.getResult();
	  System.out.println("Result: " + (result1 + result2 + result3 + result4));
    }
}

import java.util.Scanner;public class E02_3_Hanoi_Towers { public static void main(String[] args) {
            //

            System.out.println("Enter how many discs in your tower: ");
        int discs = Integer.parseInt(readLine());
        int moves = getMoves(discs);
        System.out.println("It took " + moves + " days to solve.");
    }

    private static int getMoves(int discs) {
        if (discs == 0) {
            return 0;
        } else if (discs == 1) {
            return 1;
        } else {
            int moves = 1 + (2 * getMoves(discs - 1));
            return moves;
        }
    }
    static class Tower {
        int moves;
        void getSolutionForDiscs(int n) {
            moveDiscs(n, "A", "C", "B");
        }
        void incrementMove(String sourcePole, String targetPole) {
            moves++;
            System.out.println("move a disc from " + sourcePole + " to " + targetPole);
        }
        void moveDiscs(int discs, String start, String end, String middle) {
            if (discs == 1) {
                incrementMove(start, end);
            } else {
                moveDiscs(discs - 1, start, middle, end);
                incrementMove(start, end);
                moveDiscs(discs - 1, middle, end, start);
            }
        }
    }

    private static Scanner __input = new Scanner(System.in);

    public static String readLine()  { return __input.nextLine(); }

    public static int    readInt()   { return Integer.parseInt(readLine());  }

    public static double readdouble(){ return Double.parseDouble(readLine());}

}
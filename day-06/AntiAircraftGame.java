public class AntiAircraftGame {

    private int X;
    private int Y;
    private int Z;

    private boolean hasHit;
    private boolean isPlaying;
    private Target tgt;

    public AntiAircraftGame () {
        this.isPlaying = true;
        this.hasHit = false;
        this.tgt = new Target(10);
        this.tgt.init();
    }

    public void start () {
        System.out.println("Here they come, try and bring the plane down!");
        String str;
        while (this.isPlaying) {
            this.playRound();
            System.out.println("Would you like to play again? Y/N");
            str = System.console().readLine();
            if(str.toLowerCase().equals("y")) {
                this.playRound();
            } else {
                this.isPlaying = false;
                System.out.println("Bye.");
            }
        }
    }

    private void playRound () {
        while (!this.hasHit) {
            this.readCoordinates();
            this.parseCoordinates();
        }
    }

    private void readCoordinates () {
        System.out.print("Enter a coordinate X:");
        this.X = Integer.parseInt(System.console().readLine());
        System.out.print("Enter a coordinate Y:");
        this.Y = Integer.parseInt(System.console().readLine());
        System.out.print("Enter a coordinate Z:");
        this.Z = Integer.parseInt(System.console().readLine());
    }

    private void parseCoordinates () {
        Result result = tgt.fire(this.X, this.Y, this.Z);

        switch(result) {
            case HIT:
                System.out.println("You hit! Bravo!");
                this.hasHit = true;
                break;
            case OUT_OF_RANGE:
                System.out.println("That shot was way out of range. Try again.");
                break;
            case FAIL_LEFT:
                System.out.println("You missed, target is to the right.");
                break;
            case FAIL_RIGHT:
                System.out.println("You missed, target is to the left.");
                break;
            case FAIL_HIGH:
                System.out.println("You missed, target is lower.");
                break;
            case FAIL_LOW:
                System.out.println("You missed, target is higher.");
                break;
            case FAIL_LONG:
                System.out.println("You missed, target closer.");
                break;
            case FAIL_SHORT:
                System.out.println("You missed, target is farther.");
                break;
            default:
                break;
        }

    }

}

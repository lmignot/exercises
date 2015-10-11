// 16 Rock Paper Scissors
//

int rounds = 0;
int draws = 0;
int scoreP1 = 0;
int scoreP2 = 0;
boolean finished = false;
String p1Entry;
String p2Entry;
String winner;

println "To play the game, enter the results of both players' selections using a combination of P, R, and S";
println "Enter player 1's result first followed by player 2's results, no spaces";
println "Example: if P1 has selected Paper and P2 Scissors you would enter: PS";

while (!finished) {
    rounds++;
    println "Enter the results for this round:"
    String result = System.console().readLine().toLowerCase();

    p1Entry = result.substring(0,1);
    p2Entry = result.substring(1);

    println "Player one chose " + (p1Entry == "p" ? "Paper" : (p1Entry == "s" ? "Scissors" : "Rock"))
    println "Player two chose " + (p2Entry == "p" ? "Paper" : (p2Entry == "s" ? "Scissors" : "Rock"))

    switch (result) {
        // handle draws first
        case "ss":
        case "rr":
        case "pp":
            println "That's a draw."
            draws++;
            break;
        case "pr":
        case "sp":
        case "rs":
            println "Player one won that round."
            scoreP1++;
            break;
        case "ps":
        case "rp":
        case "sr":
            println "Player two won that round."
            scoreP2++;
            break;
        default:
            "We could not recognise that entry, please try again."
            break;
    }

    if (scoreP1 - scoreP2 >= 3) {
        winner = "Player 1";
        finished = true;
    } else if (scoreP2 - scoreP1 >= 3) {
        winner = "Player 2";
        finished = true;
    }
}

println "And the winner after " + rounds + " rounds with " + draws + " draws is " + winner;

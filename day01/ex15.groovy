// 15 Guess my number
//
// Random  number between 0 and 1000

boolean correct = false;
int randomNumber = Math.abs(1000 * Math.random());
int guesses = 0;
String colderHotter = "No my number is ";

println "Try to guess my number!";

while (!correct) {
    println "Tell me a number! (0-1000):";
    int userNum = Integer.parseInt(System.console().readLine());

    if (userNum < 0 || userNum > 1000) {
        println "That's an invalid guess, try again.";
        continue;
    }

    guesses++;

    if (userNum == randomNumber) {
        correct = true;
        break;
    }

    println colderHotter + ((userNum < randomNumber) ? "higher!" : "lower!");
}

println "CORRECT";
println "You needed " + guesses + " guesses.";

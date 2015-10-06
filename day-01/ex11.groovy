// Exercise 11

// read 5 cards
// ask for rank and suit
// validate else ask to re-enter

// get best hand
// output best hand

int hands = 1;
String rank1, rank2, rank3, rank4, rank5, 
       suit1, suit2, suit3, suit4, suit5;

String spades = "spades",
       clubs = "clubs",
       hearts = "hearts",
       diamonds = "diamonds";

println "Enter the first card's rank (1-10,J,Q,K):";
rank1 = System.console().readLine().toLowerCase()

while (rank1 != "1" && rank1 != "2" && rank1 != "3" && rank1 != "4" && rank1 != "5" && rank1 != "6" && rank1 != "7" && rank1 != "8" && rank1 != "9" && rank1 != "10" && rank1 != "j" && rank1 != "q" && rank1 != "k") {
	println "That's not a valid rank, please re-enter:";
	rank1 = System.console().readLine().toLowerCase();
}

println "And the suit (spades, clubs, hearts, diamonds):";
suit1 = System.console().readLine().toLowerCase();

while (suit1 != spades && suit1 != clubs && suit1 != hearts && suit1 != diamonds) {
	println "That's not a valid suit, please re-enter:";
	suit1 = System.console().readLine().toLowerCase();
}


println "Enter the second card's rank (1-10,J,Q,K):";
rank2 = System.console().readLine().toLowerCase();

while (rank2 != "1" && rank2 != "2" && rank2 != "3" && rank2 != "4" && rank2 != "5" && rank2 != "6" && rank2 != "7" && rank2 != "8" && rank2 != "9" && rank2 != "10" && rank2 != "j" && rank2 != "q" && rank2 != "k") {
	println "That's not a valid rank, please re-enter:";
	rank2 = System.console().readLine().toLowerCase();
}

println "And the suit (spades, clubs, hearts, diamonds):";
suit2 = System.console().readLine().toLowerCase();

while (suit2 != spades && suit2 != clubs && suit2 != hearts && suit2 != diamonds) {
	println "That's not a valid suit, please re-enter:";
	suit2 = System.console().readLine().toLowerCase();
}


println "Enter the third card's rank (1-10,J,Q,K):";
rank3 = System.console().readLine().toLowerCase();

while (rank3 != "1" && rank3 != "2" && rank3 != "3" && rank3 != "4" && rank3 != "5" && rank3 != "6" && rank3 != "7" && rank3 != "8" && rank3 != "9" && rank3 != "10" && rank3 != "j" && rank3 != "q" && rank3 != "k") {
	println "That's not a valid rank, please re-enter:";
	rank3 = System.console().readLine().toLowerCase();
}

println "And the suit (spades, clubs, hearts, diamonds):";
suit3 = System.console().readLine().toLowerCase();

while (suit3 != spades && suit3 != clubs && suit3 != hearts && suit3 != diamonds) {
	println "That's not a valid suit, please re-enter:";
	suit3 = System.console().readLine().toLowerCase();
}


println "Enter the fourth card's rank (1-10,J,Q,K):";
rank4 = System.console().readLine().toLowerCase();

while (rank4 != "1" && rank4 != "2" && rank4 != "3" && rank4 != "4" && rank4 != "5" && rank4 != "6" && rank4 != "7" && rank4 != "8" && rank4 != "9" && rank4 != "10" && rank4 != "j" && rank4 != "q" && rank4 != "k") {
	println "That's not a valid rank, please re-enter:";
	rank4 = System.console().readLine().toLowerCase();
}

println "And the suit (spades, clubs, hearts, diamonds):";
suit4 = System.console().readLine().toLowerCase();

while (suit4 != spades && suit4 != clubs && suit4 != hearts && suit4 != diamonds) {
	println "That's not a valid suit, please re-enter:";
	suit4 = System.console().readLine().toLowerCase();
}


println "Enter the fifth card's rank (1-10,J,Q,K):";
rank5 = System.console().readLine().toLowerCase();

while (rank5 != "1" && rank5 != "2" && rank5 != "3" && rank5 != "4" && rank5 != "5" && rank5 != "6" && rank5 != "7" && rank5 != "8" && rank5 != "9" && rank5 != "10" && rank5 != "j" && rank5 != "q" && rank5 != "k") {
	println "That's not a valid rank, please re-enter:";
	rank5 = System.console().readLine().toLowerCase();
}

println "And the suit (spades, clubs, hearts, diamonds):";
suit5 = System.console().readLine().toLowerCase();

while (suit5 != spades && suit5 != clubs && suit5 != hearts && suit5 != diamonds) {
	println "That's not a valid suit, please re-enter:";
	suit5 = System.console().readLine().toLowerCase();
}

println "Your hand is " + rank1 + " of " + suit1 + ", " + rank2 + " of " + suit2 + ", " + rank3 + " of " + suit3 + ", " + rank4 + " of " + suit4 + ", " + rank5 + " of " + suit5 + ".";
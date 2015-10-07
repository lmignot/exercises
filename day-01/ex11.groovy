import com.thoughtworks.xstream.converters.basic.IntConverter

import java.lang.reflect.Array

// 11 Poker

// read 5 cards
// ask for rank and suit
// validate else ask to re-enter
// sort while reading

// store suits as variables for comparison
// easier to re-use and fix if typos
String spades = "spades", clubs = "clubs", hearts = "hearts", diamonds = "diamonds";

int rank1 = 0, rank2 = 0, rank3 = 0, rank4 = 0, rank5 = 0;
String suit1 = "", suit2 = "", suit3 = "", suit4 = "", suit5 = "";

// loop reference
int capturedHands = 0;

String str;
int currentRank;
String currentSuit;
//String[] testNums = ["9", "9", "10", "4", "k"];
//String[] testSuits = ["spades","clubs","hearts","hearts","spades"];

while (capturedHands < 5) {
    println "Enter a card's rank (1-10, J, Q, K):";
    str = System.console().readLine().toLowerCase();
//    str = testNums[capturedHands]

    // convert the ranks to integers for easier sorting
    if (str == "k" ) {
        currentRank = 13;
    } else if (str == "q") {
        currentRank = 12;
    } else if (str == "j") {
        currentRank = 11;
    } else {
        currentRank = Integer.parseInt(str);
    }

    // validate rank and loop again if invalid
    if (currentRank <1 && currentRank > 13) {
        println "That's not a valid rank, please re-enter:";
        continue;
    }

    // capture the suit for the current card
    println "And the suit (spades, clubs, hearts, diamonds):";
    currentSuit = System.console().readLine().toLowerCase();
//    currentSuit = testSuits[capturedHands];

    // if they have a valid rank but not a valid suit
    // inner loop to re-capture the suit and avoid having to re-capture the whole card
    while (currentSuit != spades && currentSuit != clubs && currentSuit != hearts && currentSuit != diamonds) {
        println "That's not a valid suit, please re-enter (spades, clubs, hearts, diamonds):";
        currentSuit = System.console().readLine().toLowerCase();
//        currentSuit = testSuits[capturedHands];
    }

    int tempRank;
    String tempSuit;

    if (capturedHands == 0) {
        // first loop, this is the highest card so far
        rank5 = currentRank;
        suit5 = currentSuit;
    } else if (capturedHands == 1) {
        // 2nd loop, if higher than highest than switch places
        if (currentRank > rank5) {
            rank4 = rank5;
            suit4 = suit5;
            rank5 = currentRank;
            suit5 = currentSuit;
        } else {
            rank4 = currentRank;
            suit4 = currentSuit;
        }
    } else if (capturedHands == 2) {
        // if current card is greater than the current highest card, switch up
        if (currentRank > rank5) {
            rank3 = rank4;
            suit3 = suit4;
            rank4 = rank5;
            suit4 = suit5;
            rank5 = currentRank;
            suit5 = currentSuit;
        } else if (currentRank > rank4) {
            // not gt 5 but gt 4
            rank3 = rank4;
            suit3 = suit4;
            rank4 = currentRank;
            suit4 = currentSuit;
        } else {
            rank3 = currentRank;
            suit3 = currentSuit;
        }
    } else if (capturedHands == 3) {
        // if current card is greater than the current highest card, switch up
        if (currentRank > rank5) {
            rank2 = rank3;
            suit2 = suit3;
            rank3 = rank4;
            suit3 = suit4;
            rank4 = rank5;
            suit4 = suit5;
            rank5 = currentRank;
            suit5 = currentSuit;
        } else if (currentRank > rank4) {
            // not gt 5 but gt 4
            rank2 = rank3;
            suit2 = suit3;
            rank3 = rank4;
            suit3 = suit4;
            rank4 = currentRank;
            suit4 = currentSuit;
        } else if (currentRank > rank3) {
            // not gt 4 but gt 3
            rank2 = rank3;
            suit2 = suit3;
            rank3 = currentRank;
            suit3 = currentSuit;
        } else {
            rank2 = currentRank;
            suit2 = currentSuit;
        }
    } else if (capturedHands == 4) {
        // if current card is greater than the current highest card, switch up
        if (currentRank > rank5) {
            rank1 = rank2;
            suit1 = suit2;
            rank2 = rank3;
            suit2 = suit3;
            rank3 = rank4;
            suit3 = suit4;
            rank4 = rank5;
            suit4 = suit5;
            rank5 = currentRank;
            suit5 = currentSuit;
        } else if (currentRank > rank4) {
            // not gt 5 but gt 4
            rank1 = rank2;
            suit1 = suit2;
            rank2 = rank3;
            suit2 = suit3;
            rank3 = rank4;
            suit3 = suit4;
            rank4 = currentRank;
            suit4 = currentSuit;
        } else if (currentRank > rank3) {
            // not gt 4 but gt 3
            rank1 = rank2;
            suit1 = suit2;
            rank2 = rank3;
            suit2 = suit3;
            rank3 = currentRank;
            suit3 = currentSuit;
        } else if (currentRank > rank2) {
            // not gt 3 but gt 2
            rank1 = rank2;
            suit1 = suit2;
            rank2 = currentRank;
            suit2 = currentSuit;
        } else {
            rank1 = currentRank;
            suit1 = currentSuit;
        }
    }

    capturedHands++;
}

println "Your cards are:";
println rank1 + " of " + suit1;
println rank2 + " of " + suit2;
println rank3 + " of " + suit3;
println rank4 + " of " + suit4;
println rank5 + " of " + suit5;

// TODO: get the highest hand
// and return it

String highestHand = "";

// first check for straight flush or straight

if (rank1 + 1 == rank2 && rank2 + 1 == rank3 && rank3 + 1 == rank4 && rank4 + 1 == rank5) {
    if (suit1 == suit2 && suit1 == suit3 && suit1 == suit4 && suit1 == suit5) {
        highestHand = "Straight Flush";
    } else {
        highestHand = "Straight";
    }
} else {
    // check for Flush
    if (suit1 == suit2 && suit2 == suit3 && suit3 == suit4 && suit4 == suit5) {
        highestHand = "Flush";
    } else if ((rank1 == rank2 && rank1 == rank3 && rank1 == rank4) || (rank2 == rank3 && rank2 == rank4 && rank2 ==
            rank5)) {
        // we've sorted the cards so the options are either X0000 or 0000X
        highestHand = "4 of a kind";
    } else if (rank1 == rank2 && rank1 == rank3) {
        // if 11100, full house
        if (rank4 == rank5) {
            highestHand = "Full House";
        } else {
            highestHand = "3 of a kind";
        }
    } else if (rank3 == rank4 && rank3 == rank5) {
        // if 00111
        if (rank1 == rank2) {
            highestHand = "Full House";
        } else {
            highestHand = "3 of a kind";
        }
    } else if (rank2 == rank3 && rank2 == rank4) {
        // if X000X
        highestHand = "3 of a kind";
    } else if (rank1 == rank2) {
        // if 00XXX
        if (rank3 == rank4 || rank4 == rank5) {
            // XX00X or XXX00
            highestHand = "2 pair";
        } else {
            highestHand = "Pair";
        }
    } else if (rank2 == rank3) {
        // X00XX
        if (rank4 == rank5) {
            // X0011
            highestHand = "2 pair";
        } else {
            highestHand = "Pair";
        }
    } else if (rank3 == rank4 || rank4 == rank5) {
        // XX00X or XXX00
        highestHand = "Pair";
    }
}

println "Your highest hand is: " + highestHand;

// 17 Optimus Prime
//
// aggggh transformers reference!
// todo: while looping over every consecutive number (either up or down)
//       need to do a loop for that number to check if it is prime


println "Enter a number:";
int input = Integer.parseInt(System.console().readLine());
int primeUp;
int primeDown;
String primeReturn = "";

boolean isPrime = false;

// check for < 1, then we know we don't have to loop downwards
boolean shouldLoopDown = (input > 2);

// check for primes gt input
int i = input;
int distanceUp = 0;
int distanceDown = 0;

while (!isPrime) {
    i++;
    distanceUp++;
    if (input % i != 0) {
        isPrime = true;
        primeUp = i;
        break;
    }
}

// check for primes lt input
if (shouldLoopDown) {

    isPrime = false;
    i = input;

    while (!isPrime && i >= 2) {
        i--;
        distanceDown++;
        if (input % i != 0) {
            isPrime = true;
            primeDown = i;
            break;
        }
    }
}

if (!shouldLoopDown) {
    primeReturn += primeUp;
} else {
    if (distanceDown < distanceUp) {
        primeReturn += primeUp;
    } else if (distanceDown > distanceUp) {
        primeReturn += primeUp;
    } else {
        primeReturn += primeDown + ", " + primeUp;
    }
}

println "The closest prime number(s) to your number is(are): " + primeReturn;

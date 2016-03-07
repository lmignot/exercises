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
int inputCopy = input;
int distanceUp = 0;
int distanceDown = 0;

while (!isPrime) {
    inputCopy++;
    distanceUp++;
    if (numberIsPrime(inputCopy)) {
        isPrime = true;
        primeUp = inputCopy;
        break;
    }
}

// check for primes lt input
if (shouldLoopDown) {

    isPrime = false;
    inputCopy = input;

    while (!isPrime) {
        inputCopy--;
        distanceDown++;
        if (numberIsPrime(inputCopy)) {
            isPrime = true;
            primeDown = inputCopy;
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

boolean numberIsPrime(int num) {
    if (num <= 1) {
        return false;
    }
    if (num == 2) {
        return true;
    }

    boolean isPrime = false;
    int i = num;
    while (i > 2) {
        i--;
        if (num % i == 0) {
            isPrime = false;
            break;
        } else {
            isPrime = true;
        }
    }

    return isPrime;
}

// 04 Primes
//
// Asks for a number and calculates if it is a prime number or not

println "Enter a number";
String str = System.console().readLine();
int input = Integer.parseInt(str);

// flag to determine if is prime within loop
boolean isPrime;

if (input <= 1) {
    // prime numbers are positive natural numbers greater than 1
    isPrime = false;
} else if (input == 2) {
    isPrime = true;
} else {
    // copy of input value, decrement copy until it reaches 2
    // and divide the input by the copy
    // if a number is prime the modulus will not be 0
    int i = input;

    while (i > 2) {
        i--;
        if (input % i == 0) {
            isPrime = false;
            break;
        } else {
            isPrime = true;
        }
    }
}

// return results (print)
String toBeOrNot = isPrime ? " is" : " is not";
println "The number " + input + toBeOrNot + " a prime number.";

// 13 All the primes up to 1000
//
//

// start with 3 as we know 2 is prime and 1 is not
int num = 3;
int max = 1000;
String primes = "2, ";

while (num < max) {
    boolean isPrime;
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

    if (isPrime) {
        primes = primes + num + ((num + 1 == max) ? "" : ", ")
    }
    num++;
}

println primes;

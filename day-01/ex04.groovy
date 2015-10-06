// Exercise 4

println "Enter a number";
String str = System.console().readLine();
int input = Integer.parseInt(str);

boolean isPrime;

int i = input;

while (i > 2) {
	i--;
	isPrime = (input % i != 0);
}

println "The number " + input + " is" + (isPrime ? "" : " not") + " a prime number.";
// Exercise 6

println "Enter the first number"
String str = System.console().readLine()
int num1 = Integer.parseInt(str)
int num1c = num1

println "Enter the second number"
str = System.console().readLine()
int num2 = Integer.parseInt(str)

boolean finished = false

int quotient = 0, remainder, diff


while (!finished) {
	diff = num1 - num2
	quotient++

	if(diff >= num2) {
		num1 = diff
	} else {
		remainder = diff;
		finished = true;
	}

}

println num1c + " divided by " + num2 + " is " + quotient + ", remainder " + remainder
// 06 Division
//
// Divide 2 numbers and return the quotient and remainder
// without using / or %

println "Enter the first number"
String str = System.console().readLine()
int num1 = Integer.parseInt(str)
int num1c = num1

println "Enter the second number"
str = System.console().readLine()
int num2 = Integer.parseInt(str)

// flag to end loop
boolean finished = false

int quotient = 0,
    remainder,
    diff;

// should note that this does not account for a number
// less than or equal to 0, further checks would have to be made
// to avoid potential errors and program crashes

// one way to calculate is to determine how many times
// the second number can be subtracted from the first

//
while (!finished) {
    // subtract 2nd from 1st
	diff = num1 - num2
    // increment the quotient variable
	quotient++

    // if difference is larger than 2nd number
    // set first to difference and continue
	if(diff >= num2) {
		num1 = diff
	} else {
        // else remainder is difference
		remainder = diff;
		finished = true;
	}

}

println num1c + " divided by " + num2 + " is " + quotient + ", remainder " + remainder
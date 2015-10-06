// 08 Get the highest number
//
// Ask a user for a series of numbers
// calculate and return the largest number

boolean finished = false
String str
int current
int highest = 0

while (!finished) {
	println "Enter a number (finish with -1):"
	str = System.console().readLine()
	current = Integer.parseInt(str)

    // allow user to end series with -1
	if(current == -1) {
		finished = true
		break;
	}

    // if the current number provided is greater than previous largest num
    // set highest to current
	if(current > highest) {
		highest = current
	}
}

println "the highest number was: " + highest
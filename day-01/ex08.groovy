// Exercise 8

boolean finished = false
String str
int current
int highest = 0

while (!finished) {
	println "Enter a number (finish with -1):"
	str = System.console().readLine()
	current = Integer.parseInt(str)
	
	if(current == -1) {
		finished = true
		break;
	}

	if(current > highest) {
		highest = current
	}
}

println "the highest number was: " + highest
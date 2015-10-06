// Exercise 9

boolean finished = false
boolean goingUp = true
int prev
int iteration = 1

println "Give me a number:"
prev = Integer.parseInt(System.console().readLine())
int first = prev

while (!finished) {
	println "Give me another number (finish with -1):"
	current = Integer.parseInt(System.console().readLine())

	if(current == -1) {
		finished = true
		break;
	}

	if(current > prev) {
		goingUp = (first + iteration == current)
	} else {
		goingUp = false
	}
	
	iteration++
	prev = current
}

println goingUp ? "Yes" : "No"
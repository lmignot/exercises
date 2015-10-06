// Exercise 10

boolean finished = false
boolean inOrder = true
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
		inOrder = (first + iteration == current)
	} else if (current < prev) {
		inOrder = (first - iteration == current)
	} else {
		inOrder = false
	}
	
	iteration++
	prev = current
}

println inOrder ? "Yes" : "No"
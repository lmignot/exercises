// 10 Going up or down
//
// Determine if a series of positive numbers is
// in either ascending or descending order

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
        // current number is greater, we're going up
        // we are in order if the first number added to the iteration match
		inOrder = (first + iteration == current)
	} else if (current < prev) {
        // we are going down, so calculation is first - iteration
		inOrder = (first - iteration == current)
	} else {
		inOrder = false
	}
	
	iteration++
	prev = current
}

println inOrder ? "Yes" : "No"
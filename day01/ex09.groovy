// 09 Going Up
//
// Given a sequence of numbers
// determine if they are ascending in order
// no skips

boolean finished = false
boolean goingUp = true
int prev
int iteration = 1

// get the starting number
println "Give me a number:"
prev = Integer.parseInt(System.console().readLine())

// copy of starting number for comparison
int first = prev


while (!finished) {
	println "Give me another number (finish with -1):"
	current = Integer.parseInt(System.console().readLine())

    // end with -1
	if(current == -1) {
		finished = true
		break;
	}

    // if the current is larger than the previous number
    // we are ascending if the initial number plus the current iteration
    // is the same as the current number
	if(current > prev) {
		goingUp = (first + iteration == current)
	} else {
		goingUp = false
	}

    // increment the iteration and assign previous to current
	iteration++
	prev = current
}

println goingUp ? "Yes" : "No"
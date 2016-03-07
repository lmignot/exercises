// 07 Naive sorting
//
// without arrays and other sorting mechanisms

String str = "";

println "Enter the first number"
str = System.console().readLine()
int n1 = Integer.parseInt(str)

println "Enter the second number"
str = System.console().readLine()
int n2 = Integer.parseInt(str)

println "Enter the third number"
str = System.console().readLine()
int n3 = Integer.parseInt(str)

//println n1 + "," + n2 + "," + n3


if (n1 > n2) {
	if(n1 > n3) {
		if (n2 > n3) {
			println n3 + "," + n2 + "," + n1;
		} else {
			println n2 + "," + n3 + "," + n1;
		}
	} else {
		// n1 > n2,n3 > n1
		println n2 + "," + n1 + "," + n3;
	}
} else {
	// n2 >= n1
	if(n2 > n3) {
		if (n1 > n3) {
			println n3 + "," + n1 + "," + n2;
		} else {
			println n1 + "," + n3 + "," + n2;
		}
	} else {
		// n2 > n1,n3 > n1
		println n1 + "," + n2 + "," + n3;
	}
}


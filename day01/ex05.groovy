// 05 Multiply
//
// Multiply 2 numbers without using the * symbol

println "Enter the first number";
String strA = System.console().readLine();
int num = Integer.parseInt(strA);

println "Enter the second number";
String strB = System.console().readLine();
int count = Integer.parseInt(strB);

int i = 0;
int calc = 0;

// multiplication is simply adding one number to itself
// as many times as the second number
// so we loop the length of the second number and add the
// first number to itself
while(i < count) {
	i++;
	calc = calc + num;
}

println num + " times " + count + " equals " + calc;
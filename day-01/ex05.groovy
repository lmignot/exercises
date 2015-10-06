// Exercise 5

println "Enter the first number"
String strA = System.console().readLine()
int num = Integer.parseInt(strA)

println "Enter the second number"
String strB = System.console().readLine()
int count = Integer.parseInt(strB)

int i = 0
int calc = 0

while(i < count) {
	i++
	calc = calc + num
}

println num + " times " + count + " equals " + calc
// 01 Ternary operator
//
// Informs if user is or not older than 17
//
// Program assigns a current year to a variable, and asks
// the user to input the year they were born
// if the calculated approximate age (subtracting user's birth year from current year)
// is less than 17 it assigns the string 'not' to a String
// It uses the ternary operator to perform the if/else in one line

int currentYear = 2012;
print "When were you born (year)?";
String str = System.console().readLine();
int birthYear = Integer.parseInt(str);
int ageAprox = currentYear - birthYear;
String result = (ageAprox > 17) ? "" : "not ";
println "It seems you are " + result + "an adult.";
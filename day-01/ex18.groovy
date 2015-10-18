// 18 Pi
// 628 iterations to get 3.14 correct

println "Please enter the number of iterations you want to calculate:";
int input = Integer.parseInt(System.console().readLine());


int i = 1;
double calc = 0;

long startTime = System.currentTimeMillis();

while (i < input) {
    calc = calc + ((1 / (2 * i - 1)) - (1 / (2 * i + 1)));
    i += 2;
}

double pi = 4 * calc;
long endTime = System.currentTimeMillis();

println "calculated " + input + " iterations in ~" + (endTime - startTime) + "ms";
println pi;

// 12 Number pyramids
//
//

int num = 1;
int max = 7;

while (num <= max) {
    // output as a string so + is concatenating rather than performing addition
    String output = "";
    int i = 0;

    while (i < num) {
        output = output + num;
        i++;
    }

    println output;
    i = 0;
    num++;
}

println "\\ldots";

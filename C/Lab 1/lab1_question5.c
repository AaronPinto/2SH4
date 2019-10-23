//
// Created by aaron on 2019-09-17.
//
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <math.h>

void question5() {
    char buf[CHAR_BIT * sizeof(int)];
    long double pi = 4.0;
    long n = 0, denom = 3, j = 1;

    fputs("Please input the value of n (n >= 1): ", stdout);
    fgets(buf, sizeof buf, stdin);
    n = strtol(buf, NULL, 10);

    while (j < n) {
        // We want integer division for the 2nd arg of pow() because it rounds down
        pi += 4.0 / denom * pow(-1.0, denom / 2);
        denom += 2, j++;
    }
    printf("The approximate value of pi is: %.15Lf\n", pi);
}

//int main() {
//    question5();
//    return 0;
//}

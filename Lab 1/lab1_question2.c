//
// Created by aaron on 2019-09-17.
//
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

void question2() {
    // I use char arrays, fgets and strtol for input, instead of scanf
    // See https://stackoverflow.com/questions/3302255/c-scanf-vs-gets-vs-fgets
    // https://stackoverflow.com/questions/22865622/atoi-vs-atol-vs-strtol-vs-strtoul-vs-sscanf
    char buf[CHAR_BIT * sizeof(int)];
    long n = 0, input = 0, smallest = LONG_MAX, i;

    do {
        fputs("Please input the value of n (n > 0): ", stdout);
        fgets(buf, sizeof buf, stdin);
        n = strtol(buf, NULL, 10);
    } while (n <= 0);

    for (i = 0; i < n; i++) {
        fputs("Please input an integer: ", stdout);
        fgets(buf, sizeof buf, stdin);

        if ((input = strtol(buf, NULL, 10)) < smallest)
            smallest = input;
    }
    printf("The smallest smallest inputted number is %ld\n", smallest);
}

//int main() {
//    question2();
//    return 0;
//}

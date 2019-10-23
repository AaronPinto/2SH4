//
// Created by aaron on 2019-09-17.
//
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

void question3() {
    char buf[CHAR_BIT * sizeof(int)];
    long input = 0, absInput = 0;

    do {
        fputs("Please input an integer (0 to end): ", stdout);
        fgets(buf, sizeof buf, stdin);
        input = strtol(buf, NULL, 10);
        absInput = labs(input); // abs-val for type long

        if (absInput >= 10000 && absInput < 100000)
            printf("Your input is a five-digit number: %ld\n", input);
    } while (input != 0);
    fputs("Thank you for using my software. Bye!", stdout);
}

//int main() {
//    question3();
//    return 0;
//}

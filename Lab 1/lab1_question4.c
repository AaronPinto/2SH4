//
// Created by aaron on 2019-09-17.
//
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

void question4() {
    char buf[CHAR_BIT * sizeof(float)];
    float input = 0;

    fputs("Please input an integer (0 to 100 inclusive): ", stdout);
    fgets(buf, sizeof buf, stdin);
    input = strtof(buf, NULL);

    if (input >= 0.0 && input <= 100.0) {
        if (input >= 90.0)
            fputs("4", stdout);
        else if (input >= 80.0)
            fputs("3", stdout);
        else if (input >= 70.0)
            fputs("2", stdout);
        else if (input >= 60.0)
            fputs("1", stdout);
        else
            fputs("0", stdout);
    } else
        fputs("Invalid input! Must be a float from 0-100 inclusive.", stdout);
}

//int main() {
//    question4();
//    return 0;
//}

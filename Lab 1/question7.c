//
// Created by aaron on 2019-09-17.
//
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <math.h>

void question7() {
    char buf[CHAR_BIT * sizeof(int)];
    unsigned long long sum = 0, x, y, i;
    long m = 0;

    fputs("Please input the value of m (m > 1): ", stdout);
    fgets(buf, sizeof buf, stdin);
    m = strtol(buf, NULL, 10);

    // All perfect numbers are = to 2^(p - 1) * (2^p - 1), so we can just increment p each iteration
    // This method is also much more performant than iterating from 1 to m and checking each number
    // https://en.wikipedia.org/wiki/List_of_perfect_numbers https://en.wikipedia.org/wiki/Perfect_number
    for (i = 1; i < LONG_MAX; i++) {
        y = pow(2, i - 1) * (pow(2, i) - 1);

        if (y <= m) {
            sum = 0;

            for (x = 1; x <= y / 2; x++) // Only need to check factors up to and including 1/2 the number
                if (y % x == 0)
                    sum += x;

            if (y == sum)
                printf("%llu is a perfect number\n", y);
        } else break;
    }
}

//int main() {
//    question7();
//    return 0;
//}

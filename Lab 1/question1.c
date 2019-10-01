//
// Created by aaron on 2019-09-17.
//
#include <stdio.h>

void question1() {
    // We know 4 will only have even numbers as multiples so we can optimize the
    // loops and add 2 each time to our iteration variable, i, instead of 1
    int i, sum = 0;
    for (i = 30; i <= 1000; i += 2)
        if (i % 4 == 0)
            sum += i;
    printf("For loop sum: %d\n", sum);

    i = 30, sum = 0;
    while (i <= 1000) {
        if (i % 4 == 0)
            sum += i;

        i += 2;
    }
    printf("While loop sum: %d\n", sum);

    i = 30, sum = 0;
    do {
        if (i % 4 == 0)
            sum += i;

        i += 2;
    } while (i <= 1000);
    printf("Do-while loop sum: %d\n", sum);
}

//int main() {
//    question1();
//    return 0;
//}

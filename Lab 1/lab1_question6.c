//
// Created by aaron on 2019-09-17.
//
#include <stdio.h>

void question6() {
    long total = 0, side1, side2, hyp;

    for (side2 = 1; side2 < 401; side2++)
        for (side1 = 1; side1 <= side2; side1++)
            for (hyp = 1; hyp < 401; hyp++)
                // Check if calculated hyp is equal to any valid integer hyp
                if (side1 * side1 + side2 * side2 == hyp * hyp) {
                    printf("Triple found! Side 1 = %ld, Side 2 = %ld, Hypotenuse = %ld\n", side1, side2, hyp);
                    total++;
                    break;
                }
    printf("Total number of triples: %ld", total);
}

//int main() {
//    question6();
//    return 0;
//}

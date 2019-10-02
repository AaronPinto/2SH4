//
// Created by aaron on 2019-09-25.
//
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include "lab2.h"

#define N 3

int is_diag_dom(int mat[N][N]) {
    int rowSum, diagEl;

    for (int i = 0; i < N; i++) {
        rowSum = 0, diagEl = abs(mat[i][i]);

        for (int j = 0; j < N; j++)
            rowSum += abs(mat[i][j]);

        rowSum -= diagEl;

        if (diagEl <= rowSum)
            return false;
    }
    return true;
}

void question2() {
    // https://en.wikipedia.org/wiki/Diagonally_dominant_matrix#Examples
    int a[][N] = {
            {3, -2, 1},
            {1, -3, 2},
            {-1, 2, 4},
    };
    printf("Weak diagonal dominance: %d\n", is_diag_dom(a));

    int b[][N] = {
            {-2, 2, 1},
            {1, 3, 2},
            {1, -2, 0},
    };
    printf("No diagonal dominance: %d\n", is_diag_dom(b));

    int c[][N] = {
            {-4, 2, 1},
            {1, 6, 2},
            {1, -2, 5},
    };
    printf("Strict diagonal dominance: %d\n", is_diag_dom(c));
}

//int main() {
//    question2();
//    return 0;
//}

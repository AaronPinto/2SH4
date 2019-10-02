//
// Created by aaron on 2019-09-25.
//
#include <stdio.h>
#include "lab2.h"

#define N 4

void print_sq_matrix_diag(int mat[][N]) {
    int currCol, currRow, colUpper;

    // currDiag is the current diagonal in the square matrix, 2 * (N - 1) is the diagonal upper bound, both from 0
    for (int currDiag = 0; currDiag <= 2 * (N - 1); currDiag++) {
        if (currDiag < N) {
            currRow = colUpper = currDiag;
            currCol = 0;
        } else {
            // when currDiag >= N, currRow should start on the index of the last row, colUpper should be
            // the index of the last col, and currCol should start at 1 more than the previous iteration
            currRow = colUpper = N - 1;
            currCol = currDiag - N + 1;
        }

        for (; currCol <= colUpper; currCol++) {
            printf("%d ", mat[currRow][currCol]);
            currRow--;
        }
    }
}

void question3() {
    int a[][N] = {
            {1, 12, 13, 49},
            {5, 16, 17, 81},
            {9, 10, 11, 20},
            {2, 45, 19, 14},
    };
    print_sq_matrix_diag(a);
}

//int main() {
//    question3();
//    return 0;
//}

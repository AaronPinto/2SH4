//
// Created by aaron on 2019-09-25.
//
#include <stdio.h>

void efficient(const int source[], int val[], int pos[], int size) {
    int j = 0;

    for (int i = 0; i < size; i++)
        if (source[i] != 0) {
            val[j] = source[i];
            pos[j++] = i;
        }
}

void reconstruct(int source[], int m, const int val[], const int pos[], int n) {
    for (int i = 0; i < n; i++)
        source[pos[i]] = val[i];
}

#define xSize 8
#define k 3
void question6() {
    int x[xSize] = {0, 0, 23, 0, -7, 0, 0, 48}, val[k] = {0}, pos[k] = {0};
    puts("input sparse vector:");
    for (int i = 0; i < xSize; i++)
        printf("%d ", x[i]);
    puts("");

    efficient(x, val, pos, xSize);

    puts("\nval:");
    for (int i = 0; i < k; i++)
        printf("%d ", val[i]);
    puts("");

    puts("\npos:");
    for (int i = 0; i < k; i++)
        printf("%d ", pos[i]);
    puts("");

    int rec[xSize] = {0};
    reconstruct(rec, xSize, val, pos, k);

    puts("\nreconstructed sparse vector:");
    for (int i = 0; i < xSize; i++)
        printf("%d ", rec[i]);
    puts("");
}

//int main() {
//    question6();
//    return 0;
//}

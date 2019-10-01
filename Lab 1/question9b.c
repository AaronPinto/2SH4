//
// Created by aaron on 2019-09-17.
//
#include <stdio.h>
#include <stdbool.h>

void question9b() {
    FILE *input = fopen("inputfile2.txt", "r");
    FILE *output = fopen("outputfile2.txt", "w");
    bool handleOnes = false; // false = handling zeros, true = handling ones
    int numGroups = 0, totalBits = 0, i, j;

    fscanf(input, "%d", &numGroups);
    int numBitsPerGroup[numGroups];

    for (i = 0; i < numGroups; i++) {
        fscanf(input, "%d", &numBitsPerGroup[i]);
        totalBits += numBitsPerGroup[i];
    }
    fprintf(output, "%d ", totalBits);

    for (i = 0; i < numGroups; i++) {
        for (j = 0; j < numBitsPerGroup[i]; j++)
            fprintf(output, "%d ", handleOnes ? 1 : 0);

        handleOnes = !handleOnes;
    }
    fclose(input);
    fclose(output);
}

//int main() {
//    question9b();
//    return 0;
//}

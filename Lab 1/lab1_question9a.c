//
// Created by aaron on 2019-09-17.
//
#include <stdio.h>
#include <stdbool.h>

void question9a() {
    FILE *input = fopen("inputfile1.txt", "r");
    FILE *output = fopen("outputfile1.txt", "w");
    bool handleOnes = false; // false = handling zeros, true = handling ones
    int totalBits = 0, numOfEachType = 0, bit, i;

    fscanf(input, "%d", &totalBits);

    for (i = 0; i < totalBits; i++) {
        fscanf(input, "%d", &bit);

        if (!handleOnes)
            if (bit == 0)
                numOfEachType++;
            else {
                handleOnes = !handleOnes;
                fprintf(output, "%d ", numOfEachType);
                numOfEachType = 1;
            }
        else if (bit == 1)
            numOfEachType++;
        else {
            handleOnes = !handleOnes;
            fprintf(output, "%d ", numOfEachType);
            numOfEachType = 1;
        }
    }
    fprintf(output, "%d", numOfEachType);
    fclose(input);
    fclose(output);
}

//int main() {
//    question9a();
//    return 0;
//}

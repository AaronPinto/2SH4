//
// Created by aaron on 2019-09-25.
//
#include <stdio.h>
#include "lab2.h"

void letter_freq(const char word[], int freq[]) {
    int c;
    while (*word) {
        c = (*word++) - 'A'; // Handle upper case, then lower
        if (c < 26 || (c -= ('a' - 'A')) < 26)
            freq[c]++;
    }

    for (int i = 0; i < 26; i++)
        printf("The count of '%c' and '%c' is %d\n", 'A' + i, 'a' + i, freq[i]);
}

void question4() {
    int frequency[26] = {0};
    letter_freq("DdAaNnKk", frequency);
}

//int main() {
//    question4();
//    return 0;
//}

//
// Created by aaron on 2019-09-25.
//
#include <stdio.h>

#define size 20

void string_copy(const char source[], char destination[], int n) {
    for (int i = 0; i < n - 1; i++)
        if (source[i] != 0)
            destination[i] = source[i];
        else {
            destination[i] = source[i];
            return;
        }
    destination[n - 1] = '\0';
}

void question5() {
    char src[] = "shorter than dest", dest[size] = {0};
    string_copy(src, dest, size);
    puts(dest);

    char src2[] = "a same size as dest", dest2[size] = {0};
    string_copy(src2, dest2, size);
    puts(dest2);

    char src3[] = "definitely longer than dest", dest3[size] = {0};
    string_copy(src3, dest3, size);
    puts(dest3);
}

//int main() {
//    question5();
//    return 0;
//}

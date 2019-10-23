//
// Created by aaron on 2019-10-09.
//
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char *my_strcat(const char *const str1, const char *const str2) {
    unsigned long size1 = strlen(str1), size2 = strlen(str2);

    char *str3 = calloc(size1 + size2 + 1, sizeof(char));

    for (unsigned long i = 0; i < size1; i++) {
        if (str1[i] != '\n')
            str3[i] = str1[i];
        else size1--;
    }

    for (unsigned long i = 0; i < size2; i++) {
        str3[i + size1] = str2[i];
    }

    return str3;
}

void question1() {
    printf("Given test case: %s\n", my_strcat("Hello", "world!"));

    int n;
    fputs("Please enter the length of the first string: ", stdout);
    scanf("%d", &n);
    getchar();
    char string1[n];
    fputs("Please enter the first string: ", stdout);
    fgets(string1, n, stdin);

    fputs("Please enter the length of the second string: ", stdout);
    scanf("%d", &n);
    getchar();
    char string2[n];
    fputs("Please enter the second string: ", stdout);
    fgets(string2, n, stdin);

    printf("%s\n", my_strcat(string1, string2));

    free(string1);
    free(string2);
}

//int main() {
//    question1();
//    return 0;
//}

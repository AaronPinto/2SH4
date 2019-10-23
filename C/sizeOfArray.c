//
// Created by aaron on 2019-09-30.
//
#include <stdio.h>

void sizeInFunction(char (*array)[11]) {
    char *start = array[0];
    char *end = *(&(array[0]) + 1);
    printf("%p %p %p %p %p %p\n", start, end, array, (array + 1), &array, (&array + 1));
    printf("%ld\n", end - start);
    printf("%c %c", *start, *(end - 1));
}

void mainSize() {
//    double array[] = {1.2, 3.0, 4.654, 32423.323, 342.43};
    char array[] = {'h', 'e', 'l', 'l', 'o', 'h', 'e', 'l', 'l', 'o', '\0'};
    char *start = &array[0];
    char *end = *(&array + 1);
    printf("%p %p %p %p %p %p\n", start, end, array, (array + 1), &array, (&array + 1));
    printf("%ld\n", end - start);
    printf("%c %c", *start, *(end - 1));

    puts("\n");
    sizeInFunction(&array);
}

//
// Created by aaron on 2019-09-25.
//
#include <stdio.h>
#include <math.h>
#include "lab2.h"

void print_vector(double array[], int size) {
    for (int i = 0; i < size - 1; i++)
        printf("%f, ", array[i]);
    printf("%f\n", array[size - 1]);
}

void add_vectors(double vector1[], double vector2[], double vector3[], int n) {
    for (int i = 0; i < n; i++)
        vector3[i] = vector1[i] + vector2[i];
}

double scalar_prod(double vector1[], double vector2[], int n) {
    double sum = 0;

    for (int i = 0; i < n; i++)
        sum += vector1[i] * vector2[i];
    return sum;
}

double norm2(double vector1[], int n) {
    return sqrt(scalar_prod(vector1, vector1, n));
}

void question1() {
    double a[] = {0.0, 1.0, 2.0}, b[] = {2.0, 4.0, 6.0}, c[3] = {0};

    puts("Vector a:");
    print_vector(a, 3);

    puts("Vector b:");
    print_vector(b, 3);

    add_vectors(a, b, c, 3);
    puts("Sum of vectors a & b:");
    print_vector(c, 3);

    printf("Scalar prod of a & b: %f\n", scalar_prod(a, b, 3));
    printf("Norm2 of a: %f\n", norm2(a, 3));
}

//int main() {
//    question1();
//    return 0;
//}

//
// Created by aaron on 2019-09-17.
//
#include <stdio.h>

void question8() {
    int n = 0, result = 0;

    printf("Please enter an integer you want reversed: ");
    scanf("%d", &n);

    while (n > 0) {
        result = result * 10 + n % 10; // Shift result 1 digit left and add the rightmost digit of n
        n /= 10; // Discard rightmost digit with integer div
    }
    printf("The reversed number is: %d", result);
}

//int main() {
//    question8();
//    return 0;
//}
